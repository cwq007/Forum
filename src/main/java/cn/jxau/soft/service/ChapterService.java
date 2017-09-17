package cn.jxau.soft.service;

import java.util.LinkedHashMap;
import java.util.List;

import cn.jxau.soft.domain.ForumChapter;
import cn.jxau.soft.domain.User;
import cn.jxau.soft.utils.Pager;

/**
 * 
 * @author cwq
 * @version V1.0 2017年9月8日 下午3:32:29
 */
public interface ChapterService {
	
	String SERVICENAME = "cn.jxau.soft.service.impl.ChapterServiceImpl";
	
	/**
	 * 分页获取用户发表的文章
	 * @param loginName 用户名
	 * @return 用户发表的文章
	 */
	List<ForumChapter> getAllChapterOfAuthor(User user, Pager pager,
			LinkedHashMap<String, String> orderBy);
	
	/**
	 * 添加文章
	 * @param chapter 要添加的文章
	 */
	void saveChapter(ForumChapter chapter);

	/**
	 * 获取作者为user发表的文章总数
	 * @return 作者为user发表的文章总数
	 */ 
	Integer getCountOfChapters(User user);
	
}
