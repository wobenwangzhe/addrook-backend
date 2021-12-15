package org.example.addrook.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.example.addrook.pojo.entity.User;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * <b>用户信息视图类</b>
 * @author 王晗
 * @version 5.0.0
 */
@ApiModel(value = "用户信息视图",description = "用户信息视图")
public final class UserVO implements Serializable {
	private static final long serialVersionUID = 3747045626052934225L;
	@ApiModelProperty(value = "主键")
	private Long id;            //主键
	@ApiModelProperty(value = "姓名")
	private String name;        //姓名
	@ApiModelProperty(value = "手机号码")
	private String cellphone;   //手机号码
	@ApiModelProperty(value = "登录密码")
	private String password;    //登录密码
	@ApiModelProperty(value = "电子邮件")
	private String email;       //电子邮件
	@ApiModelProperty(value = "联系地址")
	private String address;     //联系地址
	@ApiModelProperty(value = "用户头像")
	private String avatar;      //头像

	/**
	 * <b>将用户视图对象转化为用户实体对象</b>
	 * @param userVO 用户视图对象
	 * @return 用户实体对象
	 */
	public static User getParseUserfromUserVO(UserVO userVO){
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		return user;
	}
	@Override
	public String toString() {
		return "UserVO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cellphone='" + cellphone + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", avatar='" + avatar + '\'' +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
