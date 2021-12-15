package org.example.base.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础实体类</b>
 * @author 王晗
 * @version 1.0.0
 * @since 1.0.0
 */

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -3118252561215860185L;
	@TableField(exist = false)
	private String status;              //系统状态
	@TableField(exist = false)
	private String creator;             //创建人
	@TableField(exist = false)
	private String modifiedBy;          //修改人
	@TableField(value = "createTime",fill = FieldFill.INSERT)
	private Date createTime;            //创建时间
	@TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;            //修改时间

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
