package cn.jxau.soft.domain;

import java.io.Serializable;

/**
 * 文章点赞类
 * @author cwq
 */
public class Praise implements Serializable {
	private static final long serialVersionUID = -5388995819539421415L;
	private String id; // 点赞id
	private Integer chapterId; // 点赞所属的文章
	private User user; // 点赞所属的用户

	public Praise() {
		super();
	}

	public Praise(String id, Integer chapterId, User user) {
		super();
		this.id = id;
		this.chapterId = chapterId;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Praise [id=" + id + ", chapterId=" + chapterId + ", user="
				+ user + "]";
	}

}
