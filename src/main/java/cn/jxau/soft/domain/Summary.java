package cn.jxau.soft.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论类
 * @author cwq
 */
public class Summary implements Serializable {
	private static final long serialVersionUID = 7262739243095534797L;
	private String id; // 用户评论id
	private String content; // 评论内容
	private Date createDate; // 评论创建事件
	private Integer chapterId; // 评论所属的文章id
	private User user; // 评论用户

	public Summary() {
		super();
	}

	public Summary(String id, String content, Date createDate,
			Integer chapterId, User user) {
		super();
		this.id = id;
		this.content = content;
		this.createDate = createDate;
		this.chapterId = chapterId;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		return "Summary [id=" + id + ", content=" + content + ", createDate="
				+ createDate + ", chapterId=" + chapterId + ", user=" + user
				+ "]";
	}

}
