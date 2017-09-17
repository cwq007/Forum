package cn.jxau.soft.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import cn.jxau.soft.utils.Pager;

public interface CommonDao<T> {

	/**
	 * 定义关于保存实体的方法
	 * @param entity 要保存的实体
	 */
	void save(T entity);	
	
	/**
	 * 定义关于更新实体的方法
	 * @param entity 要更新的实体
	 */
	void update(T entity);
	
	/**
	 * 定义关于根据id查找实体的方法
	 * @param id 实体id号
	 * @return id号为指定id的实体
	 */
	T findObjectById(Serializable id);
	
	/**
	 * 定义根据一系列id号删除实体的方法
	 * @param ids 一系列id号
	 */
	void deleteByIds(Serializable ... ids);
	
	/**
	 * 定义删除集合类中包含实体的方法
	 * @param entities 包含要删除实体的集合
	 */
	void deleteAllObjects(Collection<T> entities);
	
	/**
	 * 通过条件进行查找
	 * @param whereHql 过滤sql语句
	 * @param params 参数
	 * @param orderBy 排序规则
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithNoPage(String whereHql, Object[] params, LinkedHashMap<String, String> orderBy);
	
	/**
	 * 通过条件进行查找
	 * @param whereHql 过滤sql语句
	 * @param params 参数
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithNoPage(String whereHql, Object[] params);
	
	/**
	 * 通过条件进行查找
	 * @param orderBy 排序规则
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithNoPage(LinkedHashMap<String, String> orderBy);
	
	/**
	 * 通过条件进行查找
	 * @return 找的实体集合
	 */
	List<T> findObjectsByConditionWithNoPage();
	
	/**
	 * 通过条件进行查找，并使用二级缓存
	 * @param whereHql 过滤sql语句
	 * @param params 参数
	 * @param orderBy 排序规则
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithNoPageCache(String whereHql, Object[] params, LinkedHashMap<String, String> orderBy);
	
	
	
	/**
	 * 通过条件进行分页 查找
	 * @param sql 过滤sql语句
	 * @param params 参数
	 * @param orderBy 排序规则
	 * @param pager 分页规则
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithPage(String sql, Object[] params, LinkedHashMap<String, String> orderBy, Pager pager);
	
	/**
	 * 通过条件进行分页查找
	 * @param whereHql 过滤sql语句
	 * @param params 参数
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithPage(String whereHql, Object[] params, Pager pager);
	
	/**
	 * 通过条件进行分页查找
	 * @param orderBy 排序规则
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithPage(LinkedHashMap<String, String> orderBy, Pager pager);
	
	/**
	 * 通过条件进行分页查找
	 * @return 找的实体集合
	 */
	List<T> findObjectsByConditionWithPage(Pager pager);
	
	/**
	 * 通过条件进行分页查找，并使用二级缓存
	 * @param whereHql 过滤sql语句
	 * @param params 参数
	 * @param orderBy 排序规则
	 * @return 查找的实体集合
	 */
	List<T> findObjectsByConditionWithPageCache(String whereHql, Object[] params, LinkedHashMap<String, String> orderBy, Pager pager);
	
	/**
	 * 根据条件，计算出每个分组中的记录数
	 * @param whereHql 过滤sql语句
	 * @param params 参数
	 * @param columnName 分组列名
	 * @return 符合条件的总记录数
	 */
	List<Long> getCountOfObjectsWithGroupBy(String whereHql, Object[] params, String columnName);
	
	/**
	 * 根据条件，计算出符合条件的总记录数
	 * @param whereHql 过滤sql语句
	 * @param params 参数
	 * @return 符合条件的总记录数
	 */
	Long getCountOfObjectsWithNoGroupBy(String whereHql, Object[] params);
	
}
