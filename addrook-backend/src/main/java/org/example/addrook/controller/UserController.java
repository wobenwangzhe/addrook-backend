package org.example.addrook.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.addrook.pojo.vo.UserVO;
import org.example.addrook.service.UserService;
import org.example.addrook.util.PropertiesUtil;
import org.example.base.controller.BaseController;
import org.example.base.pojo.vo.ResponseVO;
import org.example.base.util.ValidateUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <b>个人通讯录控制层</b>
 * @author 王晗
 * @version 5.0.0
 */
@CrossOrigin
@Api(value = "个人通讯录-控制层类",tags = "个人通讯录交互接口")
@RequestMapping("/user")
@RestController("userController")
public class UserController  extends BaseController {
	@Resource(name = "userService")
	private UserService userService;

	/**
	 * <b>校验手机号码是否可用</b>
	 * @param query 只有cellphone和id
	 * @return ResponseVO
	 * @throws Exception 所有异常
	 */
	@ApiOperation(value = "验证该手机号码能否使用",tags = "验证该手机号码能否使用",httpMethod = "POST")
	@PostMapping("/check/cellphone")
	public ResponseVO checkCellphone(@RequestBody UserVO query) throws Exception{
		//拿出前端传过来的cellphone和id
		Long id = query.getId();
		String cellphone = query.getCellphone();
		System.out.println(UserController.class.getName()+"\n 手机号码:"+cellphone);
		//验证手机号码格式是否正确
		if(!ValidateUtil.isCellphone(cellphone))
			return ResponseVO.getError("请输入正确的手机号码");
		//查询手机号码
		UserVO userVO = userService.findUserVObyCellphone(cellphone);
		if( userVO.getId()!=null &&!userVO.getId().equals(id)){
			//不可用
			return ResponseVO.getError("该手机号码已被使用");
		}
		//可用
		return ResponseVO.getSuccess("该手机号码可用");
	}

	/**
	 * <b>校验电子邮箱是否可用</b>
	 * @param email 电子邮箱
	 * @param id 用户id,可为null
	 * @return ResponseVO
	 * @throws Exception 所有异常
	 */
	@ApiOperation(value="验证邮箱能否使用",tags = "验证邮箱能否使用",httpMethod = "POST")
	@PostMapping("/check/email")
	public ResponseVO checkEmail(String email,Long id) throws Exception{
		//验证电子邮箱格式
		if(!ValidateUtil.isEmail(email))
			return ResponseVO.getError("请输入正确的电子邮箱");
		//查询电子邮箱
		UserVO userVO = userService.findUserVObyEmail(email);
		if(userVO==null || userVO.getId().equals(id))
			//可用
			return ResponseVO.getSuccess("该电子邮件可用");
		//不可用
		return ResponseVO.getError("该电子邮件已被使用");
	}

	/**
	 * <b>保存用户信息</b>
	 * @param userVO 要保存的用户信息
	 * @return ResponseVO
	 * @throws Exception 异常信息
	 */
	@ApiOperation(value = "保存用户信息",tags = "保存用户信息",httpMethod = "POST")
	@PostMapping("/save")
	public ResponseVO saveUser(@RequestBody UserVO userVO) throws Exception{
		return ResponseVO.getError("保存用户信息失败");
	}

	/**
	 * <b>用户登录</b>
	 * @param cellphone 手机号码
	 * @param passWord 登录密码
	 * @return ResponseVO
	 * @throws Exception 异常
	 */
	@ApiOperation(value = "用户登录",tags = "用户登录",httpMethod = "POST")
	@PostMapping("/login")
	public ResponseVO loginUser(String cellphone,String passWord)throws Exception{

		return ResponseVO.getError("登陆失败");
	}

	/**
	 * <b>分页查询</b>
	 * @param pageNum 页码数
	 * @param pageSize 每页数量
	 * @return ResponseVO
	 * @throws Exception 异常信息
	 */
	@ApiOperation(value = "分页查询",tags = "分页查询",httpMethod = "POST")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryPage(@PathVariable("pageNum") Long pageNum
	                            ,@PathVariable("pageSize") Long pageSize
								,@RequestBody UserVO queryVO)throws Exception{
		//如果分页页码错误,使用默认页码
		if(pageNum==null ||pageNum<1)
			pageNum = PropertiesUtil.getPageNum();
		if(pageSize==null || pageSize<1)
			pageSize = PropertiesUtil.getPageSize();
		IPage<UserVO> iPage = userService.findPageByQuery(pageNum,pageSize,queryVO);
		//返回系统响应
		ResponseVO responseVO=ResponseVO.getSuccess(iPage);
		return responseVO;
	}

	/**
	 * <b>修改用户信息</b>
	 * @param userVO 用户信息
	 * @return ResponseVO
	 * @throws Exception 异常信息
	 */
	@ApiOperation(value = "修改用户信息",tags = "修改用户信息",httpMethod = "POST")
	@PostMapping("/update")
	public ResponseVO updateUser(@RequestBody UserVO userVO) throws Exception{

		return ResponseVO.getError("修改用户信息失败");
	}

	/**
	 * <b>删除用户信息</b>
	 * @param id 用户id
	 * @return ResponseVO
	 * @throws Exception 异常信息
	 */
	@ApiOperation(value = "删除用户",tags = "删除用户",httpMethod = "GET")
	@GetMapping ("/delete")
	public ResponseVO deleteById(Long id)throws Exception {

		return ResponseVO.getError("删除用户信息失败");
	}
}
