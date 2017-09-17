package cn.jxau.soft.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 定义一个文章主题(类别)的类
 * @author cwq
 * @version V1.0 2017/7/17
 */
public class Topic implements Serializable {
	private static final long serialVersionUID = -8254861404586480419L;
	private Integer id; // 主题id
	private String name; // 主题名称
	private String pycode; // 主题拼音码，根据这个属性进行排序
	private Date createDate; // 主题创建时间
	private Date updateDate; // 主题更新时间
	private Admin author; // 主题创建者
	private Set<ForumChapter> forumChapters = new HashSet<ForumChapter>(); // 主题类别为该类别的所有文章

	public Topic() {
		super();
	}

	public Topic(Integer id, String name, String pycode, Admin author,
			Date createDate, Date updateDate, Set<ForumChapter> forumChapters) {
		super();
		this.id = id;
		this.name = name;
		this.pycode = pycode;
		this.author = author;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.forumChapters = forumChapters;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public Admin getAuthor() {
		return author;
	}

	public void setAuthor(Admin author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Set<ForumChapter> getForumChapters() {
		return forumChapters;
	}

	public void setForumChapters(Set<ForumChapter> forumChapters) {
		this.forumChapters = forumChapters;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", pycode=" + pycode
				+ ", author=" + author + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", forumChapters="
				+ forumChapters + "]";
	}

}
