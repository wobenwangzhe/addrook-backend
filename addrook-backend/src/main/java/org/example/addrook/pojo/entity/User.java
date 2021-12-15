package org.example.addrook.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import org.example.addrook.pojo.vo.UserVO;
import org.example.base.pojo.entity.BaseEntity;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * <b>用户信息实体类</b>
 * @author 王晗
 * @version 5.0.0
 */
@TableName("sys_user")
public final class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1858933323802711801L;
	@TableId(value = "id",type = IdType.AUTO)
	@OrderBy(sort = Short.MIN_VALUE)
	private Long id;            //主键
	@TableField(value = "name")
	private String name;        //姓名
	@TableField(value = "cellphone",insertStrategy=FieldStrategy.NOT_EMPTY, updateStrategy=FieldStrategy.NOT_EMPTY )
	private String cellphone;   //手机号码
	@TableField(value = "password" )
	private String password;    //登录密码
	@TableField(value = "email" )
	private String email;       //电子邮件
	@TableField(value = "address" )
	private String address;     //联系地址
	@TableField(value = "avatar" )
	private String avatar;      //头像

	/**
	 * <b>用户信息实体类转换为用户信息视图类</b>
	 * @param user 用户信息实体类
	 * @return 用户信息视图类
	 */
	public static UserVO getParseUserVOFromUser(User user){
		UserVO userVO =new UserVO();
		BeanUtils.copyProperties(user, userVO);
		return userVO;
	}
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cellphone='" + cellphone + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", avatar='" + avatar + '\'' +
				'}';
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
