package org.example.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>基础控制类-含有控制层需要用到的一些属性</b>
 */
@Controller
public class BaseController {
	@Autowired
	protected HttpServletRequest request;           //http请求
	@Autowired
	protected HttpServletResponse response;         //http回应
	@Autowired
	protected HttpSession session;                  //http会话
}
