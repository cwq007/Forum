package cn.jxau.soft.domain;

import java.io.Serializable;

/**
 * 角色类 (权限组类)
 * @author Administrator
 */
public class PrivilegeGroup implements Serializable {
	private static final long serialVersionUID = -2660415366364168075L;
	private Integer id;  //角色id 
	private String name; //角色名称
	private String info; //角色描述

	public PrivilegeGroup() {
		super();
	}

	public PrivilegeGroup(Integer id, String roleName, String desc) {
		super();
		this.id = id;
		this.name = roleName;
		this.info = desc;
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

	public void setName(String roleName) {
		this.name = roleName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String desc) {
		this.info = desc;
	}

	@Override
	public String toString() {
		return "PrivilegeGroup [id=" + id + ", roleName=" + name + ", desc="
				+ info + "]";
	}

}
