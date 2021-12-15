package org.example.base.util;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Pattern;

/**
 * <b>验证前台传输的数据是否合理的</b>
 * @author 王晗
 * @version 5.0.0
 */
public class ValidateUtil {
	//手机号码正则表达式
	private static Pattern CELLPHONE_REGEX=Pattern.compile("1[0-9]{10}");
	//登录密码正则表达式
	private static Pattern PASSWORD_REGEX=Pattern.compile("[A-Za-z0-9]{6,}");
	//电子邮件正则表达式
	private static Pattern EMAIL_REGEX=Pattern.compile("\\w+@\\w+.com");

	private ValidateUtil(){}

	/**
	 * <b>判断手机号码是否正常</b>
	 * @param cellphone 手机号码
	 * @return boolean
	 */
	public static boolean isCellphone(String cellphone){
		if(StrUtil.isBlank(cellphone))
			return false;
		return CELLPHONE_REGEX.matcher(cellphone).matches();
	}

	/**
	 * <b>判断Email是否正常</b>
	 * @param email email
	 * @return boolean
	 */
	public static boolean isEmail(String email){
		if(StrUtil.isBlank(email))
			return false;
		return EMAIL_REGEX.matcher(email).matches();
	}

	/**
	 * <b>判断密码是否正常</b>
	 * @param password 密码
	 * @return boolean
	 */
	public static boolean isPassword(String password ){
		if(StrUtil.isBlank(password))
			return false;
		return PASSWORD_REGEX.matcher(password).matches();
	}
}
