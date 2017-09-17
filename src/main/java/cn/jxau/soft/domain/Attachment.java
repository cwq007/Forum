package cn.jxau.soft.domain;

import java.io.Serializable;

/**
 * 定义附件类
 * 
 * @author cwq
 */
public class Attachment implements Serializable {
	private static final long serialVersionUID = -6219137726962839516L;
	private String id; // 附件id
	private String name; // 附件名
	private String url; // 附件url地址
	private String info; // 附件信息
	private Integer downloadCount; //附件下载次数

	private ForumChapter chapter; // 附件所属文章id

	public Attachment() {
		super();
	}
	
	public Attachment(String id, String name, String url, String info,
			Integer downloadCount, ForumChapter chapter) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.info = info;
		this.downloadCount = downloadCount;
		this.chapter = chapter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public ForumChapter getChapter() {
		return chapter;
	}

	public void setChapter(ForumChapter chapter) {
		this.chapter = chapter;
	}

	public Integer getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", name=" + name + ", url=" + url
				+ ", info=" + info + ", downloadCount=" + downloadCount
				+ ", chapter=" + chapter + "]";
	}

}
