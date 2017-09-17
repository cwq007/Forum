package cn.jxau.soft.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.jxau.soft.dao.CommonDao;
import cn.jxau.soft.utils.GerenicClassUtils;
import cn.jxau.soft.utils.Pager;

/**
 * 定义关于通用Dao接口的实现
 * 
 * @author cwq
 * @param <T>  泛型
 */
public class CommDaoHiberate4Impl<T> extends HibernateDaoSupport implements
		CommonDao<T> {

	Class<?> entityClass = GerenicClassUtils
			.getSuperGerenicArg(this.getClass());

	/**
	 * 经过源码的分析，调用HibernateDaoSupport对象的setSessionFactory方法时
	 * 会创建一个新的HibernateDaoSupport对象
	 * 
	 * @param sessionFactory
	 */
	@Resource(name = "sessionFactory")
	public void setSessionFactoryDI(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findObjectById(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public void deleteByIds(Serializable... ids) {
		HibernateTemplate temp = this.getHibernateTemplate();
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				Object obj = temp.get(entityClass, ids[i]);
				if (obj == null)
					throw new RuntimeException("你查找的[" + ids[i] + "]不存在");
				temp.delete(obj);
			}
		}
	}

	@Override
	public void deleteAllObjects(Collection<T> entities) {
		this.getHibernateTemplate().deleteAll(entities);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			final Object[] params, LinkedHashMap<String, String> orderBy) {
		HibernateTemplate template = this.getHibernateTemplate();
		StringBuffer strBuff = new StringBuffer("select o from "
				+ entityClass.getSimpleName() + " o where 1 = 1 and ");

		if (StringUtils.isNotBlank(whereHql)) {
			strBuff.append(whereHql);
		} else {
			strBuff.substring(0, strBuff.lastIndexOf("and"));
		}
		strBuff.append(buildOrderBy(orderBy));

		final String fHql = strBuff.toString();

		List<T> objList = template.execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(fHql);
				// 设置参数
				setParams(query, params);
				return query.list();
			}
		});

		return objList;
	}

	@Override
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			Object[] params) {
		return findObjectsByConditionWithNoPage(whereHql, params, null);
	}

	@Override
	public List<T> findObjectsByConditionWithNoPage(
			LinkedHashMap<String, String> orderBy) {
		return findObjectsByConditionWithNoPage(null, null, orderBy);
	}

	@Override
	public List<T> findObjectsByConditionWithNoPage() {
		return findObjectsByConditionWithNoPage(null, null, null);
	}

	@Override
	public List<T> findObjectsByConditionWithNoPageCache(String whereHql,
			Object[] params, LinkedHashMap<String, String> orderBy) {
		return null;
	}

	@Override
	public List<T> findObjectsByConditionWithPage(String whereHql, final Object[] params,
			LinkedHashMap<String, String> orderBy, final Pager pager) {
		HibernateTemplate template = this.getHibernateTemplate();
		StringBuffer strBuff = new StringBuffer("select o from "
				+ entityClass.getSimpleName() + " o where 1 = 1 and ");

		if (StringUtils.isNotBlank(whereHql)) {
			strBuff.append(whereHql);
		} else {
			strBuff.substring(0, strBuff.lastIndexOf("and"));
		}
		
		strBuff.append(buildOrderBy(orderBy));
		
		final String fHql = strBuff.toString();
		System.out.println("fHql:" + fHql);

		List<T> objList = template.execute(new HibernateCallback<List<T>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(fHql);
				if (pager != null && pager.getCurPage()!=null && pager.getPageSize() != null) {
					query.setFirstResult((pager.getCurPage()-1)*pager.getPageSize());
					query.setMaxResults(pager.getPageSize());
				}
				// 设置参数
				setParams(query, params);
				return query.list();
			}
		});

		return objList;
	}

	@Override
	public List<T> findObjectsByConditionWithPage(String whereHql,
			Object[] params, Pager pager) {
		return findObjectsByConditionWithPage(whereHql, params, null, pager);
	}

	@Override
	public List<T> findObjectsByConditionWithPage(LinkedHashMap<String, String> orderBy, Pager pager) {
		return findObjectsByConditionWithPage(null, null, orderBy, pager);
	}

	@Override
	public List<T> findObjectsByConditionWithPage(Pager pager) {
		return findObjectsByConditionWithPage(null, null, null, pager);
	}

	@Override
	public List<T> findObjectsByConditionWithPageCache(String whereHql, Object[] params, 
			LinkedHashMap<String, String> orderBy, Pager pager) {
		return null;
	}

	@Override
	public List<Long> getCountOfObjectsWithGroupBy(String whereHql, final Object[] params, String columnName) {
		HibernateTemplate template = this.getHibernateTemplate();
		StringBuffer strBuff = new StringBuffer("select count(*) from " + entityClass.getSimpleName()  
					+ " o where 1=1 ");
		if (StringUtils.isNotBlank(whereHql)) {
			strBuff.append(whereHql);
		}
		
		if (columnName != null && StringUtils.isNotBlank(columnName)) {
			strBuff.append("group by " + columnName);
		}
		
		final String fHql = strBuff.toString();

		List<Long> objList = template.execute(new HibernateCallback<List<Long>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Long> doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(fHql);
				// 设置参数
				setParams(query, params);
				return query.list();
			}
		});

		return objList;
	}

	@Override
	public Long getCountOfObjectsWithNoGroupBy(String whereHql, Object[] params) {
		return getCountOfObjectsWithGroupBy(whereHql, params, null).get(0);
	}

	/**
	 * 拼接排序字段
	 * 
	 * @param orderByMap
	 *            排序map对象
	 * @return 拼接排序字段组成的字符串
	 */
	private String buildOrderBy(LinkedHashMap<String, String> orderByMap) {
		if (orderByMap == null)
			return "";
		StringBuffer orderBy = new StringBuffer(" order by ");
		for (String key : orderByMap.keySet()) {
			orderBy.append(" " + key + " " + orderByMap.get(key));
		}
		return orderBy.toString();
	}

	/**
	 * 设置sql查询参数
	 * 
	 * @param query
	 *            sql查询对象
	 * @param params
	 *            查询参数数组
	 */
	private void setParams(Query query, Object[] params) {
		if (params == null)
			return;
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

}
