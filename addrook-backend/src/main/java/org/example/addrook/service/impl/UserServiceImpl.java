package org.example.addrook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.addrook.dao.UserDao;
import org.example.addrook.pojo.entity.User;
import org.example.addrook.pojo.vo.UserVO;
import org.example.addrook.service.UserService;
import org.example.addrook.util.PageMapperUtil;
import org.example.base.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>个人通讯录系统物业层接口实现类</b>
 * @author 王晗
 * @version 5.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	/**
	 * <b>根据手机号码查询用户</b>
	 * @param cellphone 手机号码
	 * @return 用户信息
	 * @throws Exception 异常
	 */
	@Override
	public UserVO findUserVObyCellphone(String cellphone) throws Exception {
		//在redis中查询
		UserVO userVO = (UserVO) RedisUtil.findFromRedis(cellphone, UserVO.class);
		//若未查询到,在mybatis中查询
		if(userVO==null){
			//查询条件
			QueryWrapper<User> wrapper =new QueryWrapper<>();
			wrapper.eq("cellphone", cellphone);
			//查询
			User user = userDao.selectOne(wrapper);
			if(user==null)
				return new UserVO();
			userVO=User.getParseUserVOFromUser(user);
			//在redis中没有查到,在mybatis中查到了
			if(userVO!=null)
				RedisUtil.saveToRedis(cellphone, userVO);
		}
		return userVO;
	}

	/**
	 * <b>根据电子邮件查询用户信息</b>
	 * @param email 电子邮件
	 * @return 用户信息
	 * @throws Exception 异常
	 */
	@Override
	public UserVO findUserVObyEmail(String email) throws Exception {
		//在redis中查询
		UserVO userVO = (UserVO) RedisUtil.findFromRedis(email, UserVO.class);
		//若未查询到,在mybatis中查询
		if(userVO==null){
			//查询条件
			QueryWrapper<User> wrapper =new QueryWrapper<>();
			wrapper.eq("email", email);
			//查询
			User user = userDao.selectOne(wrapper);
			if(user==null)
				return new UserVO();
			userVO=User.getParseUserVOFromUser(user);
			//在redis中没有查到,在mybatis中查到了
			if(userVO!=null)
				RedisUtil.saveToRedis(email, userVO);
		}
		return userVO;
	}

	/**
	 * <b>分页查询</b>
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @param queryVO 条件
	 * @return IPage<UserVO>
	 */
	@Override
	public IPage<UserVO> findPageByQuery(Long pageNum, Long pageSize, UserVO queryVO) throws Exception {
		//分页条件
		Page<User> page = new Page<>(pageNum, pageSize);
		//查询条件
		QueryWrapper<User> wrapper =new QueryWrapper<>();
		if (queryVO != null) {
			if(queryVO.getName()!=null)
				wrapper.eq("name", queryVO.getName());
			if(queryVO.getCellphone()!=null)
				wrapper.eq("cellphone", queryVO.getCellphone());
			if(queryVO.getEmail()!=null)
				wrapper.eq("email", queryVO.getEmail());
			if(queryVO.getAddress()!=null)
				wrapper.like("address", queryVO.getAddress());
		}
			//排序
			wrapper.orderByAsc("id");

		//查询
		page =userDao.selectPage(page, wrapper);
		//转化为视图对象
		IPage<UserVO> pageVO =new Page<>();
		pageVO = PageMapperUtil.pageMapperTAToRE(page,UserVO.class);
		return pageVO;
	}
}
