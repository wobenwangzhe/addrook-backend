package org.example.addrook.util;

import java.io.IOException;
import java.util.Properties;

/**
 * <b>获得读取properties文件对象工具类</b>
 * @author 王晗
 * @version 5.0.0
 */
public class PropertiesUtil {
	private PropertiesUtil(){}
	private static Properties props=new Properties();

	private static Long pageNum;                    //分页页码
	private static Long pageSize;                   //每页数量

	/**
	 * <b>获得properties/config.properties 读取类</b>
	 * @return
	 */
	static {
		try {
			props.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("properties/config.properties"));
		} catch (IOException e) {
			System.out.println(PropertiesUtil.class.getName()+" getBaseProperties()读取properties/config.properties失败");
		}
	}

	/**
	 * <b>获得分页页码</b>
	 * @return Integer
	 */
	public static Long getPageNum(){
		if(pageNum==null){
			synchronized(props){
				if(pageNum==null)
					pageNum=Long.parseLong(props.getProperty("page.num"));
			}
		}
		return pageNum;
	}

	/**
	 * <b>获得每页数量</b>
	 * @return Integer
	 */
	public static Long getPageSize(){
		if(pageSize==null){
			synchronized(props){
				if(pageSize==null)
					pageSize=Long.parseLong(props.getProperty("page.size"));
			}
		}
		return pageSize;
	}

}
