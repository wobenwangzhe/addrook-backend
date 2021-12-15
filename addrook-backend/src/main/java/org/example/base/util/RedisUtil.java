package org.example.base.util;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.addrook.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <b>redis工具类</b>
 *
 */
@Component
public class RedisUtil {
	@Autowired
	private StringRedisTemplate template;

	private static final JsonMapper jsonMapper = new JsonMapper();

	private static StringRedisTemplate redisTemplate;

	private RedisUtil(){}
	/**
	 * <b>RedisUtil初始化方法</b>
	 */
	@PostConstruct
	public void init(){
		if(redisTemplate==null){
			redisTemplate=template;
		}
	}

	/**
	 * <b>根据key将对象以json格式存入到Redis中</b>
	 * @param key redis中保存的键
	 * @param value redis中保存的值
	 * @return 是否保存成功
	 */
	public static boolean saveToRedis(String key,Object value){
		try {
			//将value转为String
			String strJson = jsonMapper.writeValueAsString(value);
			//保存
			redisTemplate.opsForValue().set(key, strJson);
			return true;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * <b>根据key从Redis中进行查询</b>
	 * @param key redis中保存的键
	 * @param valueType redis中保存的值原本的类型
	 * @return redis中保存的对象
	 */
	public static  Object findFromRedis(String key, Class valueType){
		try{
			//查询
			String valueStr = redisTemplate.opsForValue().get(key);
			if(StrUtil.isNotBlank(valueStr)) {
				//将 valueStr转为对象
				return jsonMapper.readValue(valueStr, valueType);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <b>根据key删除Redis中的数据</b>
	 * @param key redis中保存的键
	 * @return redis删除操作是否成功
	 */
	public static  boolean removeFromRedis(String key){
		try{
			//从redis中删除key及其对应的value
			redisTemplate.delete(key);
			return true;
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
