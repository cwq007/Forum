package cn.jxau.soft.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 定义一个文章信息的类
 * @author cwq
 * @version V1.0 2017/7/17
 */
public class ForumChapter implements Serializable {
	private static final long serialVersionUID = 2789145624148585262L;
	private Integer id; // 新闻id
	private String title; // 新闻标题
	private User author; // 新闻作者
	private Date createDate; // 新闻创建日期
	private String content; // 新闻内容
	private Integer readCount; // 新闻浏览次数
	private Set<Summary> summarys = new HashSet<Summary>(); // 新闻评论
	private Set<Praise> praises = new HashSet<Praise>(); // 新闻点赞
	private Set<Attachment> attachments = new HashSet<Attachment>(); // 新闻附件
	private Set<Topic> topics = new HashSet<Topic>(); // 新闻所属主题

	public ForumChapter() {
		super();
	}

	public ForumChapter(Integer id, String title, User author, Date createDate,
			String content, Integer readCount, Set<Summary> summarys,
			Set<Praise> praises, Set<Attachment> attachments, Set<Topic> topics) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.createDate = createDate;
		this.content = content;
		this.readCount = readCount;
		this.summarys = summarys;
		this.praises = praises;
		this.attachments = attachments;
		this.topics = topics;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Set<Summary> getSummarys() {
		return summarys;
	}

	public void setSummarys(Set<Summary> summarys) {
		this.summarys = summarys;
	}

	public Set<Praise> getPraises() {
		return praises;
	}

	public void setPraises(Set<Praise> praises) {
		this.praises = praises;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topic) {
		this.topics = topic;
	}

	@Override
	public String toString() {
		return "ForumChapter [id=" + id + ", title=" + title + ", author="
				+ author + ", createDate=" + createDate + ", content="
				+ content + ", readCount=" + readCount + ", summarys="
				+ summarys + ", praises=" + praises + ", attachments="
				+ attachments + ", topics=" + topics + "]";
	}

}
