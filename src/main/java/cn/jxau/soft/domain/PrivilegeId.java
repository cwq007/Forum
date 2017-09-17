package cn.jxau.soft.domain;

import java.io.Serializable;

/**
 * 单个权限操作的联合主键类
 * 
 * @author Administrator
 * @version V1.0 2017/8/25
 */
public class PrivilegeId implements Serializable {
	private static final long serialVersionUID = -8387684023717870983L;
	private String module; // 单个权限的模块名称
	private String operation; // 单个权限的操作名称

	public PrivilegeId() {
		super();
	}

	public PrivilegeId(String module, String operation) {
		super();
		this.module = module;
		this.operation = operation;
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
		PrivilegeId other = (PrivilegeId) obj;
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
		return true;
	}
}
