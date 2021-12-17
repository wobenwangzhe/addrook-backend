package org.example.base.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.base.pojo.entity.BaseEntity;
import org.example.base.pojo.vo.BaseVO;
import org.example.base.pojo.vo.PageVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>分页对象映射工具类</b>
 */
public class PageMapperUtil  {
	private PageMapperUtil(){}


	/**
	 * <b>将实体分页对象转换为视图分页对象</b>
	 * @param reiPage 要装换类型的分页对象
	 * @param taClass 目标类型
	 * @param <RE> 来源类型泛型 继承于BaseEntity
	 * @param <TA> 目标类型泛型 继承与BaseVO
	 * @return
	 */
	public static <RE extends BaseEntity,TA extends BaseVO> PageVO<TA> pageMapperTAToRE (IPage<RE> reiPage, Class<TA> taClass) throws Exception{
		PageVO<TA> taiPage =new PageVO<TA>();
		//复制普通属性
		BeanUtils.copyProperties(reiPage, taiPage);
		//分页列表
		List<TA> newList=new ArrayList<>();
		for (RE re: reiPage.getRecords()) {
				TA ta =taClass.getConstructor().newInstance();
				BeanUtils.copyProperties(re, ta);
				newList.add(ta);
		}
		//将分页列表加入分页对象
		taiPage.setRecords(newList);
		return taiPage;
	}
}
