package cn.jxau.soft.web.action.ajax;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.jxau.soft.domain.ForumChapter;
import cn.jxau.soft.domain.User;
import cn.jxau.soft.service.ChapterService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("chapterAjaxAction")
@Scope(value = "prototype")
public class ChapterAjaxAction extends ActionSupport implements ModelDriven<ForumChapter>, SessionAware {
	private static final long serialVersionUID = 5267874313053865670L;
	
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	/**=======================**/
	private ForumChapter chapter;
	public ForumChapter getChapter() {
		return chapter;
	}
	public void setChapter(ForumChapter chapter) {
		this.chapter = chapter;
	}
	
	public String publish() {
		chapter.setCreateDate(new Date());
		chapter.setAuthor((User) session.get("loginedUser"));
		
		chapterService.saveChapter(chapter);
		
		result = "success";
		return "success";
	}
	/**=======================**/
	
	@Resource(name=ChapterService.SERVICENAME)
	private ChapterService chapterService;
	
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}	
	
	@Override
	public ForumChapter getModel() {
		if (chapter == null) {
			chapter = new ForumChapter();
		}
		return chapter;
	}
	
}