package cn.jxau.soft.web.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.jxau.soft.domain.ForumChapter;
import cn.jxau.soft.domain.User;
import cn.jxau.soft.service.ChapterService;
import cn.jxau.soft.service.UserService;
import cn.jxau.soft.utils.ActiveCodeGenerator;
import cn.jxau.soft.utils.EmailSender;
import cn.jxau.soft.utils.Pager;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope(value = "prototype")
public class UserAction extends ActionSupport 
	implements ModelDriven<User>, SessionAware {
	private static final long serialVersionUID = 5356901466380381463L;
	
	/**===================**/
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String loginVerifyCode; //登陆验证码
	public String getLoginVerifyCode() {
		return loginVerifyCode;
	}
	
	public void setLoginVerifyCode(String loginVerifyCode) {
		this.loginVerifyCode = loginVerifyCode;
	}
	
	// 登录入口
	public String login() {
		User userDb = userService.getUserByLoginUser(user.getLoginUser());
		if (userDb != null && userDb.getLoginPass().equals(user.getLoginPass())) {
			if (userDb.getActived().equals("1")) {
				userDb.setLastLoginDate(new Date());
				userDb.setLastLoginIpAddr(ServletActionContext.getRequest().getRemoteAddr());
				userService.updateUser(userDb); //更新用户信息

				session.put("loginedUser", userDb);
				return "redirIndex";
			} else {
				addActionError("该账号还未激活，请到注册时使用的邮箱地址中进行激活！");
				return "input";
			}
		} else {
			addActionError("用户名或者密码不正确");
			return "input";
		}
	}
	
	// 注册入口
	public String regist() {
		ActiveCodeGenerator generator = new ActiveCodeGenerator();
		String activecode = generator.generateActionCode();
		user.setRegistDate(new Date());
		user.setActivecode(activecode);
		userService.saveUser(user);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		sendActiveEmail(user, request.getScheme()+"://"+request.getServerName()+":" + request.getServerPort() + 
				request.getContextPath() +"/user/user_active.action");
		
		return "registSuccess";
	}
	/**===================**/
	
	
	/**===================**/
	private String part;
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	
	private Integer curPage;
	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	// 用户信息入口
	public String profile() {
		User loginedUser = (User) session.get("loginedUser");

		if ("userinfo".equals(part)) {
			return part;
		}
		
		if ("chapterinfo".equals(part)) {
			LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
			orderBy.put("createDate", "desc");
			Pager pager = new Pager();
			pager.setPageSize(6); // 每页显示6篇文章
			
			pager.setCurPage(curPage);
			
			if (pager.getCurPage() == null) {
				pager.setCurPage(1);
			} 
			
			pager.setRowsCount(chapterService.getCountOfChapters(loginedUser));
			
			List<ForumChapter> forumChapters = chapterService.getAllChapterOfAuthor(loginedUser, 
					pager, orderBy);
			
			session.put("forumChapters", forumChapters);
			session.put("pager", pager);
		} else {
			if ("userlikes".equals(part)) {
				
				
			} else {
				if ("usersubscribe".equals(part)) {
					
					
				}
			}
		}
		return part;
	}
	/**===================**/

	
	
	/**===================**/
	private ByteArrayInputStream inputStream;
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	// 显示头像入口
	public String showimg() {
		User userSubDb = userService.getUserByLoginUser(user.getLoginUser());
		String realPath = ServletActionContext.getServletContext().getRealPath(userSubDb.getUserPhotoPath());
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(realPath);
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			IOUtils.copy(fis, byteOut);
			inputStream = new ByteArrayInputStream(byteOut.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return "showImg";
	}
	/**===================**/
	
	
	/**===================**/
	// 注销登录入口
	public String loginout() {
		session.remove("loginedUser");
		return "redirIndex";
	}
	/**===================**/
	
	
	/**===================**/
	// 激活用户入口
	public String active() {
		User userDb = userService.getUserByLoginUser(user.getLoginUser());
		if (userDb.getActivecode().equals(user.getActivecode())) {
			userDb.setActived("1");
			userService.updateUser(userDb); //更新用户
		}
		return "redirLogin";
	}
	/**===================**/
	
	
	/**
	 * 发送邮箱验证信息
	 * @param email 要发送到的地址
	 * @param actioncode 激活码
	 */
	private void sendActiveEmail(final User user, final String forwareUrl) {
		final EmailSender sender = new EmailSender();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("sendActiveEmail: " + user.getActivecode());
					sender.sendTo(user.getEmail(), "欢迎注册，<a href='"+ forwareUrl 
								+"?user.loginUser=" + user.getLoginUser()
								+ "&user.activecode="+ user.getActivecode() +"'>点击这里</a>进行激活！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Resource(name = UserService.SERVICENAME)
	private UserService userService;
	@Resource(name=ChapterService.SERVICENAME)
	private ChapterService chapterService;
	
	
	@Override
	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
