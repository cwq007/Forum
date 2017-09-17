package cn.jxau.soft.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jxau.soft.dao.ChapterDao;
import cn.jxau.soft.domain.ForumChapter;
import cn.jxau.soft.utils.Pager;

/**
 * 
 * @author cwq
 * @version V1.0 2017年9月8日 下午3:25:12
 */
@Repository(ChapterDao.SERVICENAME)
public class ChapterDaoImpl extends CommDaoHiberate4Impl<ForumChapter> implements
		ChapterDao {

	@Override
	public List<ForumChapter> getAllChapterOfAuthor(String whereHql, Object[] params, 
			LinkedHashMap<String, String> orderBy, Pager pager) {
		return this.findObjectsByConditionWithPage(whereHql, params, orderBy, pager);
	}

	@Override
	public void saveChapter(ForumChapter chapter) {
		this.getHibernateTemplate().save(chapter);
	}

	@Override
	public Integer getCountOfChapters(String whereHql, Object[] params) {
		return this.findObjectsByConditionWithNoPage(whereHql, params).size();
	}


}
