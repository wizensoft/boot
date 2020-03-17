package com.wizen.web.portal.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/*
 * https://github.com/weirjiang/spring-boot-demo/blob/master/spring-boot-redis/src/main/java/com/redis/config/RedisConfig.java
 */

@Configuration
public class RedisConfig {

	// public static Logger LOGGER = LoggerFactory.getLogger(RedisDataConfig.class);
	private Log logger = LogFactory.getLog(getClass());;

	/*
	 * @Bean(name = "jedis.pool")
	 * 
	 * @Autowired public JedisPool jedisPool(@Qualifier("jedis.pool.config")
	 * JedisPoolConfig config , @Value("${jedis.pool.host}") String host
	 * , @Value("${jedis.pool.port}") int port) { System.out.println(host); return
	 * new JedisPool(config, host, port); }
	 * 
	 * @Bean(name = "jedis.pool.config") public JedisPoolConfig
	 * jedisPoolConfig(@Value("${jedis.pool.maxTotal}") int
	 * maxTotal, @Value("${jedis.pool.maxIdle}") int maxIdle,
	 * 
	 * @Value("${jedis.pool.maxWaitMillis}") int maxWaitMillis) { JedisPoolConfig
	 * config = new JedisPoolConfig(); config.setMaxTotal(maxTotal);
	 * config.setMaxIdle(maxIdle); config.setMaxWaitMillis(maxWaitMillis); return
	 * config; }
	 */
	/*
	@Bean
	public RedisConnectionFactory redisConnectionFactory() throws UnknownHostException {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(20);
		poolConfig.setMinIdle(2);
		poolConfig.setMaxIdle(5);

		JedisConnectionFactory factory = new JedisConnectionFactory(poolConfig);
		factory.setHostName("192.168.0.10");
		factory.setUsePool(true);
		factory.setPort(6379);
		return factory;
	}

	@Bean(name = "redisUserTemplate")
	public RedisTemplate<String, String> redisTemplateUser(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return template;
	}
	*/
}
