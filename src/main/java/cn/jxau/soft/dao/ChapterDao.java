package cn.jxau.soft.dao;

import java.util.LinkedHashMap;
import java.util.List;

import cn.jxau.soft.domain.ForumChapter;
import cn.jxau.soft.utils.Pager;

/**
 * 
 * @author cwq
 * @version V1.0 2017年9月8日 下午3:21:05
 */
public interface ChapterDao extends CommonDao<ForumChapter>{
	
	String SERVICENAME = "cn.jxau.soft.dao.impl.ChapterDaoImpl";
	
	/**
	 * 分页获取用户发表的文章
	 * @param loginName 用户名
	 * @return 用户发表的文章
	 */
	List<ForumChapter> getAllChapterOfAuthor(String loginName, Object[] params,
			LinkedHashMap<String, String> orderBy, Pager pager);
	
	/**
	 * 添加文章
	 * @param chapter 要添加的文章
	 */
	void saveChapter(ForumChapter chapter);
	
	/**
	 * 获取作者为user发表的文章总数
	 * @return 作者为user发表的文章总数
	 */
	Integer getCountOfChapters(String whereHql, Object[] params);
	
}
