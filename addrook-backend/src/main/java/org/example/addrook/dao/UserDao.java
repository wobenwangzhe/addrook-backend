package org.example.addrook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.addrook.pojo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <b>个人通信录系统数据持久层接口</b>
 * @author 王晗
 * @version 5.0.0
 */
@Repository
public interface UserDao extends BaseMapper<User> {

}
