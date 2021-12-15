package org.example.base.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.example.base.pojo.enums.ResponseCode;

import java.io.Serializable;

/**
 * <b>返回系统响应视图对象</b>
 * @author 王晗
 * @version 5.0.0
 */
@ApiModel(value = "系统响应视图信息" ,description = "系统响应视图信息ResponseVO")
public class ResponseVO implements Serializable {
	private static final long serialVersionUID = -8985290324044388509L;
	@ApiModelProperty(value = "响应编码")
	private Integer code;                //响应编码
	@ApiModelProperty(value = "响应信息")
	private String message;             //响应信息
	@ApiModelProperty(value = "响应数据")
	private Object data;                //响应数据

	/**
	 * <b>获得系统业务处理成功响应视图信息</b>
	 * @return 系统业务处理成功响应视图
	 */
	public static ResponseVO getSuccess(){
		return new ResponseVO(ResponseCode.RESPONSE_SUCCESS.getCode(), ResponseCode.RESPONSE_SUCCESS.getRemark(),"");
	}

	/**
	 * <b>获得系统业务处理成功响应视图信息</b>
	 * @param data 系统业务处理成功返回数据
	 * @return 系统业务处理成功响应视图
	 */
	public static ResponseVO getSuccess(Object data){

		return new ResponseVO(ResponseCode.RESPONSE_SUCCESS.getCode(), ResponseCode.RESPONSE_SUCCESS.getRemark(),data);
	}

	/**
	 * <b>获得系统业务处理逻辑错误视图信息</b>
	 * @param message 系统业务处理逻辑错误信息
	 * @return 系统业务处理逻辑错误视图
	 */
	public static ResponseVO getError(String message){
		return new ResponseVO(ResponseCode.RESPONSE_ERROR.getCode(),message,"");
	}

	/**
	 * <b>获得系统未登录视图信息</b>
	 * @return 系统未登录视图
	 */
	public static ResponseVO getUnAuth(){
		return new ResponseVO(ResponseCode.RESPONSE_UNAUTH.getCode(), ResponseCode.RESPONSE_UNAUTH.getRemark(), "");
	}

	/**
	 * <b>获得系统响应异常视图信息</b>
	 * @param e 异常
	 * @return 系统响应异常视图
	 */
	public static ResponseVO getException(Exception e){
		return new ResponseVO(ResponseCode.RESPONSE_EXCEPTION.getCode(), e.getMessage(), "");
	}


	private ResponseVO(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
