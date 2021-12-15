package org.example.base.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础视图类</b>
 * @author 王晗
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "基础视图信息",description = "基础视图信息BaseVO")
public class BaseVO implements Serializable {
	private static final long serialVersionUID = 6402955678809299032L;
	@ApiModelProperty(value = "系统状态")
	private String status;              //系统状态
	@ApiModelProperty(value = "创建时间")
	private Date createTime;            //创建时间
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;            //修改时间

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
