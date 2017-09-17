package cn.jxau.soft.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 定义一个管理员的类
 * 
 * @author cwq
 * @version V1.0 2017/7/17
 */
public class Admin implements Serializable {
	private static final long serialVersionUID = -1611308096853984448L;
	private Integer id; // 管理员id
	private String loginUser; // 管理员用户名
	private String loginPass; // 管理员密码
	private String unabled; // 管理员是否被停用 1表示未停用，0表示停用，默认为未停用
	private Date createdDate; // 该管理员被创建的时间

	private Set<Admin> manageredAdmins = new HashSet<Admin>(); // 管理员与管理员之间管理与被管理的关系
	private Set<Topic> topics = new HashSet<Topic>(); // 管理员创建的主题
	private PrivilegeGroup privilegeGroup; // 该管理员对应的角色(权限组)

	public Admin() {
		super();
	}

	public Admin(Integer id, String loginUser, String loginPass,
			String unabled, Date createdDate, Set<Admin> manageredAdmins,
			Set<Topic> topics, PrivilegeGroup privilegeGroup) {
		super();
		this.id = id;
		this.loginUser = loginUser;
		this.loginPass = loginPass;
		this.unabled = unabled;
		this.createdDate = createdDate;
		this.manageredAdmins = manageredAdmins;
		this.topics = topics;
		this.privilegeGroup = privilegeGroup;
	}

	public Integer getId() {
		return id;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public Set<Admin> getManageredAdmins() {
		return manageredAdmins;
	}

	public void setManageredAdmins(Set<Admin> manageredAdmins) {
		this.manageredAdmins = manageredAdmins;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public PrivilegeGroup getPrivilegeGroup() {
		return privilegeGroup;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public String getUnabled() {
		return unabled;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public void setPrivilegeGroup(PrivilegeGroup privilegeGroup) {
		this.privilegeGroup = privilegeGroup;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public void setUnabled(String unabled) {
		this.unabled = unabled;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginUser=" + loginUser + ", loginPass="
				+ loginPass + ", unabled=" + unabled + ", createdDate="
				+ createdDate + ", manageredAdmins=" + manageredAdmins
				+ ", topics=" + topics + ", privilegeGroup=" + privilegeGroup
				+ "]";
	}

}
