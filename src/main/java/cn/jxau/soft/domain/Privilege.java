package cn.jxau.soft.domain;

/**
 * 单个权限操作类
 * @author cwq
 * @version V1.0 2017/8/25
 */
public class Privilege {
	private PrivilegeId privilegeId; // 单个权限操作联合主键
	private String name; // 单个权限名称
	private String tip; // 单个权限的功能提示
	private Integer sort; // 单个权限的排序权重
	private String info; // 单个权限的信息

	public Privilege() {
		super();
	}

	public Privilege(PrivilegeId privilegeId, String name, String tip,
			Integer sort, String desc) {
		super();
		this.privilegeId = privilegeId;
		this.name = name;
		this.tip = tip;
		this.sort = sort;
		this.info = desc;
	}

	public PrivilegeId getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(PrivilegeId privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String desc) {
		this.info = desc;
	}

	@Override
	public String toString() {
		return "Privilege [privilegeId=" + privilegeId + ", name=" + name
				+ ", tip=" + tip + ", sort=" + sort + ", desc=" + info + "]";
	}

}
