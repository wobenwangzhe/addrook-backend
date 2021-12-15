package org.example.addrook.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>分页对象映射工具类</b>
 */
public class PageMapperUtil  {
	private PageMapperUtil(){}


	/**
	 * <b>对分页对象进行类型转换</b>
	 * @param reiPage 要装换类型的分页对象
	 * @param taClass 目标类型
	 * @param <RE> 来源类型
	 * @param <TA> 目标类型
	 * @return
	 */
	public static <RE,TA> IPage<TA> pageMapperTAToRE (IPage<RE> reiPage, Class<TA> taClass){
		IPage<TA> taiPage =new Page<>();
		//复制普通属性
		BeanUtils.copyProperties(reiPage, taiPage);
		//分页列表
		List<TA> newList=new ArrayList<>();
		for (RE re: reiPage.getRecords()) {
			try {
				TA ta =taClass.getConstructor().newInstance();
				BeanUtils.copyProperties(re, ta);
				newList.add(ta);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//加入分页列表
		taiPage.setRecords(newList);
		return taiPage;
	}
}
