package cn.jxau.soft.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 普通用户类
 * 
 * @author cwq
 */
public class User implements Serializable {
	private static final long serialVersionUID = -202914196711501042L;
	private Integer id; // 用户id
	private String nickname; // 用户昵称
	private String loginUser; // 用户名
	private String loginPass; // 密码
	private String sex; // 用户年龄
	private Date birth; // 用户出生年月
	private String nativePlace; // 用户籍贯
	private String qq; // 用户qq号
	private String email; // 用户邮箱地址
	private String phoneNum; // 用户电话
	private String userPhotoPath; // 用户头像
									// 默认为'/WEB-INF/users/userphotos/default.gif'
	private Date registDate; // 用户注册事件
	private Date lastLoginDate; // 用户上次登录时间
	private String lastLoginIpAddr; // 用户上次登录ip
	private Set<ForumChapter> forumChapters = new HashSet<ForumChapter>(); // 用户发表的文章
	private Set<User> subscribeUsers = new HashSet<User>(); // 用户关注的用户
	private Set<Topic> likeTopics = new HashSet<Topic>(); // 用户订阅的文章主题
	private String info; // 用户个人描述 默认为'这个人很懒，什么都没留下'
	private Integer scores; // 用户积分 默认为0
	private String activecode; // 用户注册激活码
	private String actived; // 用户是否被激活    0表示未激活， 1表示激活， 默认为未激活0

	public String getActived() {
		return actived;
	}

	public void setActived(String actived) {
		this.actived = actived;
	}

	public User(Integer id, String nickname, String loginUser,
			String loginPass, String sex, Date birth, String nativePlace,
			String qq, String email, String phoneNum, String userPhotoPath,
			Date registDate, Date lastLoginDate, String lastLoginIpAddr,
			Set<ForumChapter> forumChapters, Set<User> subscribeUsers,
			Set<Topic> likeTopics, String info, Integer scores,
			String activecode, String actived) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.loginUser = loginUser;
		this.loginPass = loginPass;
		this.sex = sex;
		this.birth = birth;
		this.nativePlace = nativePlace;
		this.qq = qq;
		this.email = email;
		this.phoneNum = phoneNum;
		this.userPhotoPath = userPhotoPath;
		this.registDate = registDate;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIpAddr = lastLoginIpAddr;
		this.forumChapters = forumChapters;
		this.subscribeUsers = subscribeUsers;
		this.likeTopics = likeTopics;
		this.info = info;
		this.scores = scores;
		this.activecode = activecode;
		this.actived = actived;
	}

	public User() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Set<ForumChapter> getForumChapters() {
		return forumChapters;
	}

	public void setForumChapters(Set<ForumChapter> forumChapters) {
		this.forumChapters = forumChapters;
	}

	public String getActivecode() {
		return activecode;
	}

	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getUserPhotoPath() {
		return userPhotoPath;
	}

	public void setUserPhotoPath(String userPhotoPath) {
		this.userPhotoPath = userPhotoPath;
	}

	public Set<User> getSubscribeUsers() {
		return subscribeUsers;
	}

	public void setSubscribeUsers(Set<User> subscribeUsers) {
		this.subscribeUsers = subscribeUsers;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIpAddr() {
		return lastLoginIpAddr;
	}

	public void setLastLoginIpAddr(String lastLoginIpAddr) {
		this.lastLoginIpAddr = lastLoginIpAddr;
	}

	public Set<Topic> getLikeTopics() {
		return likeTopics;
	}

	public void setLikeTopics(Set<Topic> likeTopics) {
		this.likeTopics = likeTopics;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getScores() {
		return scores;
	}

	public void setScores(Integer scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", loginUser="
				+ loginUser + ", loginPass=" + loginPass + ", sex=" + sex
				+ ", birth=" + birth + ", nativePlace=" + nativePlace + ", qq="
				+ qq + ", email=" + email + ", phoneNum=" + phoneNum
				+ ", userPhotoPath=" + userPhotoPath + ", registDate="
				+ registDate + ", lastLoginDate=" + lastLoginDate
				+ ", lastLoginIpAddr=" + lastLoginIpAddr + ", forumChapters="
				+ forumChapters + ", subscribeUsers=" + subscribeUsers
				+ ", likeTopics=" + likeTopics + ", info=" + info + ", scores="
				+ scores + ", activecode=" + activecode + ", actived="
				+ actived + "]";
	}

}
