package cn.jxau.soft.domain;

import java.io.Serializable;

/**
 * 定义单个权限菜单项类
 * 
 * @author cwq
 */
public class PrivilegeMenuItem implements Serializable {
	private static final long serialVersionUID = -7029256378062070849L;
	private PrivilegeId id; // 菜单的联合主键
	private String name; // 菜单显示名称
	private Integer sort; // 菜单的排序
	private String tip; // 菜单显示提示
	private String url; // 菜单的url
	private String info; // 菜单信息

	public PrivilegeMenuItem() {
		super();
	}

	public PrivilegeMenuItem(PrivilegeId id, String name, Integer sort,
			String tip, String url, String info) {
		super();
		this.id = id;
		this.name = name;
		this.sort = sort;
		this.tip = tip;
		this.url = url;
		this.info = info;
	}

	public PrivilegeId getId() {
		return id;
	}

	public void setId(PrivilegeId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
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

	@Override
	public String toString() {
		return "PrivilegeMenuItem [id=" + id + ", name=" + name + ", sort="
				+ sort + ", tip=" + tip + ", url=" + url + ", info=" + info
				+ "]";
	}

}
