package org.example.base.exception;


import org.example.base.pojo.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <b>系统全局异常处理类</b>
 * @RestController 全局异常信息都会发送到这个类中
 * @author 王晗
 * @version 1.0.0
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHadler {
	/*
		spring内置的日志工具为 logback
		log4j=>logbavk=> slf4j
		使用时使用slf4j下的Logger和LoggerFactory
	 */
	//当出现异常时,需要记录日志,就需要创建Logger日志对象
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHadler.class);

	/**
	 * <b>全局异常处理</b>
	 * @param request HttpServletRequest请求
	 * @param response HttpServletResponse 响应
	 * @param e Exceprion 异常
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseVO globalException(HttpServletRequest request, HttpServletResponse response,Exception e){
		//将错误信息记录到日志中
		logger.error(e.getMessage()+":"+new Date());
		//将异常信息发送到前台
		return ResponseVO.getException(e);
	}

}
