package cn.jxau.soft.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxau.soft.dao.ChapterDao;
import cn.jxau.soft.domain.ForumChapter;
import cn.jxau.soft.domain.User;
import cn.jxau.soft.service.ChapterService;
import cn.jxau.soft.utils.Pager;

/**
 * 
 * @author cwq
 * @version V1.0 2017年9月8日 下午3:33:49
 */
@Service(ChapterService.SERVICENAME)
public class ChapterServiceImpl implements ChapterService {
	@Resource(name=ChapterDao.SERVICENAME)
	private ChapterDao chapterDao;

	@Override
	public List<ForumChapter> getAllChapterOfAuthor(User user,
			Pager pager, LinkedHashMap<String, String> orderBy) {
		return chapterDao.getAllChapterOfAuthor("author=?", new Object[]{user}, orderBy, pager);
	}

	@Override
	public void saveChapter(ForumChapter chapter) {
		chapterDao.save(chapter);
	}

	@Override
	public Integer getCountOfChapters(User user) {
		return chapterDao.getCountOfChapters("author=?", new Object[]{user});
	}	
	
}
