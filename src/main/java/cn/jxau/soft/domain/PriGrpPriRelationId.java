package cn.jxau.soft.domain;

import java.io.Serializable;

/**
 * 权限组和单个权限操作的关系的联合主键类
 * 
 * @author cwq
 * @version V1.0 2017/8/25
 */
public class PriGrpPriRelationId implements Serializable {
	private static final long serialVersionUID = -1719673044931939292L;
	private String privilegeGroupId; // 角色id
	private String module; // 模块名称
	private String operation; // 操作名称

	public String getPrivilegeGroupId() {
		return privilegeGroupId;
	}

	public void setPrivilegeGroupId(String privilegeGroupId) {
		this.privilegeGroupId = privilegeGroupId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result
				+ ((operation == null) ? 0 : operation.hashCode());
		result = prime
				* result
				+ ((privilegeGroupId == null) ? 0 : privilegeGroupId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriGrpPriRelationId other = (PriGrpPriRelationId) obj;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (privilegeGroupId == null) {
			if (other.privilegeGroupId != null)
				return false;
		} else if (!privilegeGroupId.equals(other.privilegeGroupId))
			return false;
		return true;
	}

}
