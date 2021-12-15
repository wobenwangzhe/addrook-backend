package org.example.base.pojo.enums;


/**
 * <b>系统响应编码枚举类</b>
 * @author 王晗
 * @version 5.0.0
 */
public enum ResponseCode{

	RESPONSE_SUCCESS(20000,"系统业务处理完成响应成功"),
	RESPONSE_UNAUTH(30000,"用户未进行系统认证"),
	RESPONSE_ERROR(40000,"系统业务处理逻辑错误"),
	RESPONSE_EXCEPTION(50000,"系统响应异常");
	private Integer code;           //系统响应编码
	private String remark;          //系统响应说明

	ResponseCode(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}


	public String getRemark() {
		return remark;
	}

}
