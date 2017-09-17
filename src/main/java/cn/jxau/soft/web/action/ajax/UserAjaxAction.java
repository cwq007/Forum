package cn.jxau.soft.web.action.ajax;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.jxau.soft.domain.User;
import cn.jxau.soft.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAjaxAction")
@Scope(value = "prototype")
public class UserAjaxAction extends ActionSupport 
	implements SessionAware, ModelDriven<User> {
	private static final long serialVersionUID = -4179604776711252862L;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	/**===================================**/
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//更新用户信息
	public String updateuser() {
		User loginedUser = (User) session.get("loginedUser");
		if (user.getNickname() != null && StringUtils.isNotBlank(user.getNickname())) {
			loginedUser.setNickname(user.getNickname());
		}
		if (user.getSex() != null && ! StringUtils.isNotBlank(user.getSex())){
			loginedUser.setSex(user.getSex());
		}
		if (user.getBirth() != null) {
			loginedUser.setBirth(user.getBirth());
		}
		if (user.getNativePlace() != null && StringUtils.isNotBlank(user.getNativePlace())) {
			loginedUser.setNativePlace(user.getNativePlace().replace(", ", "-"));
		}
		if (user.getQq() != null && StringUtils.isNotBlank(user.getQq())) {
			loginedUser.setQq(user.getQq());
		}
		if (user.getEmail() != null && StringUtils.isNotBlank(user.getEmail())) {
			loginedUser.setEmail(user.getEmail());
		}
		if (user.getPhoneNum() != null && StringUtils.isNotBlank(user.getPhoneNum())) {
			loginedUser.setPhoneNum(user.getPhoneNum());
		}
		if (user.getUserPhotoPath() != null && StringUtils.isNotBlank(user.getUserPhotoPath())) {
			loginedUser.setUserPhotoPath(user.getUserPhotoPath());
		}
		if (user.getInfo() != null && StringUtils.isNotBlank(user.getInfo())) {
			loginedUser.setInfo(user.getInfo());
		}
		userService.updateUser(loginedUser);
		result = "success";
		return "success";
	}
	/**====================================**/
	
	

	/**====================================**/
	private String jsonFilePath = "/js/ChineseCities.json";
	private String province;
	private String city;
	private String area;	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	// 初始加载省市信息 
	public String initNativePlaces() {
		String realFilePath = ServletActionContext.getServletContext().getRealPath(jsonFilePath);
		
		String content = null;
		try {
			content = IOUtils.toString(new FileInputStream(realFilePath), "gbk");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONArray jsonArray = JSONArray.fromObject(content);
		StringBuffer proBuff = new StringBuffer("{\"provinces\":[");
		StringBuffer cityBuff = new StringBuffer("\"cities\":[");
		String areaStr = "";
		for (int i = 0; i < jsonArray.size(); i++) {
			String proviceElem = jsonArray.getJSONObject(i).getString("name");
			if (i != jsonArray.size()-1) proBuff.append("\"" + proviceElem + "\",");
			else proBuff.append("\"" + proviceElem + "\"],");
			
			if (proviceElem.equals(getProvince())) {
				JSONArray citiesArray = jsonArray.getJSONObject(i).getJSONArray("city");
				for (int j = 0; j < citiesArray.size(); j++) {
					String cityElem = citiesArray.getJSONObject(j).getString("name");
					if (j != citiesArray.size()-1) cityBuff.append("\"" + cityElem + "\",");
					else cityBuff.append("\"" + cityElem + "\"],");
					
					if (cityElem.equals(getCity())) {
						JSONArray areasArray = citiesArray.getJSONObject(j).getJSONArray("area");
						areaStr += ("\"areas\":" + areasArray.toString());
					}
				}
			}
		}
		proBuff.append(cityBuff);
		proBuff.append(areaStr);
		proBuff.append("}");
		result = proBuff.toString();
		return "success";
	}
	
	// 改变省市信息
	public String changeNativePlace() {
		String realFilePath = ServletActionContext.getServletContext().getRealPath(jsonFilePath);
		
		String content = null;
		try {
			content = IOUtils.toString(new FileInputStream(realFilePath), "gbk");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONArray jsonArray = JSONArray.fromObject(content);
		JSONArray citiesSelected = null;
		for (int i=0; i<jsonArray.size(); i++) {
			String provinceElem = jsonArray.getJSONObject(i).getString("name");
			if (provinceElem.equals(getProvince())) {
				citiesSelected = jsonArray.getJSONObject(i).getJSONArray("city");
				break;
			}
		}
		
		StringBuffer strBuff = new StringBuffer("{\"cities\":[");
		String areaStr = "";
		for (int i=0; i<citiesSelected.size(); i++) {
			String cityElem = citiesSelected.getJSONObject(i).getString("name");
			if (i != citiesSelected.size()-1) strBuff.append("\"" + cityElem + "\",");
			else strBuff.append("\"" + cityElem + "\"],");
			
			if (cityElem.equals(getCity())) {
				JSONArray areaArray = citiesSelected.getJSONObject(i).getJSONArray("area");
				areaStr += ("\"areas\":" + areaArray.toString());
			}
		}
		if ("".equals(getCity())) {
			JSONArray areaArray = citiesSelected.getJSONObject(0).getJSONArray("area");
			areaStr += ("\"areas\":" + areaArray.toString());
		}
		strBuff.append(areaStr);
		strBuff.append("}");
		result = strBuff.toString();
		return "success";
	}
	/**====================================**/
	
	
	
	
	
	/**====================================**/
	private String loginUser;
	public String getLoginUser() {
		
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	// 检查用户名是否重复
	public String ckRepLoginUser() {
		if (userService.getUserByLoginUser(loginUser) != null) {
			result = "用户名已存在";
		} else {
			result = "true";
		}
		return "success";
	}
	/**====================================**/
	
	
	
	
	
	/**====================================**/
	private String nickname;
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	// 检查昵称是否重复
	public String ckRepNickname() {
		if (userService.getUserByNickname(nickname) != null) {
			result = "该昵称已存在，请重新输入！";
		} else {
			result = "true";
		}
		return "success";
	}
	/**====================================**/
	
	
	
	
	
	/**====================================**/
	private String loginVerifyCode;
	public String getLoginVerifyCode() {
		return loginVerifyCode;
	}

	public void setLoginVerifyCode(String loginVerifyCode) {
		this.loginVerifyCode = loginVerifyCode;
	}

	// 检查验证码是否正确
	public String ckRigLoginVerifyCode() {
		String vc = (String) session.get("verifyCode");
		if (vc.equalsIgnoreCase(loginVerifyCode)) {
			result = "true";
		} else {
			result = "验证码错误";
		}
		return "success";
	}
	/**====================================**/
	
	
	
	@Resource(name=UserService.SERVICENAME)
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}
	
}
