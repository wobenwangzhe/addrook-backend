package org.example.base.util;

import java.io.IOException;
import java.util.Properties;

/**
 * <b>swagger配置文件读取工具类,方法均采用单例模式</b>
 * @author 王晗
 * @version 5.0.0
 */
public class SwaggerPropertiesUtil {
	private SwaggerPropertiesUtil(){}

	private static Properties props=new Properties();
	private static String tittle;                       //文档标题
	private static String description;                  //描述
	private static String version;                      //版本
	private static String contactName;                  //联系人姓名
	private static String contactUrl;                   //联系人网址
	private static String contactEmail;                 //联系人email
	private static String basePackage;                  //swagger生成交互文档时扫描的位置
	private static String license;                      //许可
	private static String licenseUrl;                   //许可信息网址
	private static String termsOfServiceUrl;            //服务条款网址
	static {
		try {
			props.load(SwaggerPropertiesUtil.class.getClassLoader().getResourceAsStream("properties/swagger.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>获得服务条款网址</b>
	 * @return 服务条款网址
	 */
	public static String getTermsOfServiceUrl(){
		if(termsOfServiceUrl==null){
			synchronized(props){
				if(termsOfServiceUrl==null)
					termsOfServiceUrl = props.getProperty("swagger.terms.service.url");
			}
		}
		return termsOfServiceUrl;
	}

	/**
	 * <b>获得许可地址</b>
	 * @return 许可地址
	 */
	public static String getLicenseUrl(){
		if(licenseUrl==null){
			synchronized (props){
				if(licenseUrl==null)
					licenseUrl = props.getProperty("swagger.license.url");
			}
		}
		return licenseUrl;
	}

	/**
	 * <b>获得许可证</b>
	 * @return 许可证
	 */
	public static String getLicense(){
		if(license==null){
			synchronized(props){
				if(license==null)
					license = props.getProperty("swagger.license");
			}
		}
		return license;
	}

	/**
	 * <b>获得swagger扫描基础包位置</b>
	 * @return swagger扫描基础包位置
	 */
	public static String getBasePackage(){
		if(basePackage==null){
			synchronized(props){
				if(basePackage==null)
					basePackage = props.getProperty("swagger.base.package");
			}
		}
		return basePackage;
	}

	/**
	 * <b>获得联系人电子邮件</b>
	 * @return 联系人电子邮件
	 */
	public static String getContactEmail(){
		if(contactEmail==null){
			synchronized(props){
				if(contactEmail==null)
					contactEmail = props.getProperty("swagger.contact.email");
			}
		}
		return contactEmail;
	}

	/**
	 * <b>获得联系人网址</b>
	 * @return 联系人网址
	 */
	public static String getContactUrl(){
		if(contactUrl==null){
			synchronized(props){
				contactUrl = props.getProperty("swagger.contact.url");
			}
		}
		return contactUrl;
	}

	/**
	 * <b>获得联系人姓名</b>
	 * @return 联系人姓名
	 */
	public static String getContactName(){
		if(contactName==null){
			synchronized (props){
				if(contactName==null)
					contactName = props.getProperty("swagger.contact.name");
			}
		}
		return contactName;
	}

	/**
	 * <b>获得版本号</b>
	 * @return 版本号
	 */
	public static String getVersion(){
		if(version==null){
			synchronized(props){
				if(version==null){
					version = props.getProperty("swagger.version");
				}
			}
		}
		return version;
	}

	/**
	 * <b>获得swagger文档描述信息</b>
	 * @return swagger文档描述
	 */
	public static String getDescription(){
		if(description==null){
			synchronized(props){
				if(description==null)
					description=props.getProperty("swagger.description");
			}
		}
		return description;
	}
	/**
	 * <b>获得swagger文档标题</b>
	 * @return 文档标题
	 */
	public static String getTittle(){
		if(tittle==null){
			synchronized (props){
				if(tittle==null)
					/*
						加锁后判断tittle是否为空，再赋值。
						有可能一个进程加锁后，另一个进程判断tittle==null也来访问，导致多次读取文件
					 */
				tittle=props.getProperty("swagger.tittle");
			}
		}
		return tittle;
	}

}
