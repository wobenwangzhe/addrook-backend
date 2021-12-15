package org.example.addrook.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.addrook.pojo.vo.UserVO;

/**
 * <b>个人通讯录系统物业层接口</b>
 * @author 王晗
 * @version 5.0.0
 */
public interface UserService {
	/**
	 * <b>根据手机号码查询用户</b>
	 * @param cellphone 手机号码
	 * @return 用户信息
	 * @throws Exception 异常
	 */
	UserVO findUserVObyCellphone(String cellphone)throws Exception;

	/**
	 * <b>根据电子邮件查询用户信息</b>
	 * @param email 电子邮件
	 * @return 用户信息
	 * @throws Exception 异常
	 */
	UserVO findUserVObyEmail(String email)throws Exception;

	/**
	 * <b>分页查询</b>
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @param queryVO 条件
	 * @return IPage<UserVO>
	 */
	IPage<UserVO> findPageByQuery(Long pageNum, Long pageSize, UserVO queryVO)throws Exception;
}
