package cn.jxau.soft.domain;

import java.io.Serializable;

/**
 * 权限组和单个权限操作的关系类
 * @author cwq
 * @version V1.0 2017/8/25
 */
public class PriGrpPriRelation implements Serializable {
	private static final long serialVersionUID = -238048037770943344L;
	private PriGrpPriRelationId pgpRelationId; //联合主键

	public PriGrpPriRelationId getPgpRelationId() {
		return pgpRelationId;
	}

	public void setPgpRelationId(PriGrpPriRelationId pgpRelationId) {
		this.pgpRelationId = pgpRelationId;
	}
}
