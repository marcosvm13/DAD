package es.urjc.hotelo;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.config.TcpIpConfig;

import es.urjc.hotelo.entity.Hotel;


@SpringBootApplication
@EnableHazelcastHttpSession
public class HoteloApplication {
	
	@Value("${nodes}")
	private String nodes;
	
	@Bean
	public RedisStandaloneConfiguration redisStandaloneConfiguration() {
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
		config.setHostName("redis");
        config.setPort(6379);
		return config;
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return  new JedisConnectionFactory(redisStandaloneConfiguration());
	}
	
	@Bean
	public RedisTemplate<String, Hotel> redisTemplate() {
		RedisTemplate<String, Hotel> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(true);
		
		return redisTemplate;
	}


	@Bean
	public Config config() {
		
		Config config = new Config();
		JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		
		joinConfig.getMulticastConfig().setEnabled(false);
		
		TcpIpConfig tcpIpConf = joinConfig.getTcpIpConfig();
		if(nodes.isEmpty()) {
			tcpIpConf.addMember("127.0.0.1");
		}
		else {
			tcpIpConf.addMember(nodes);			
		}	
		tcpIpConf.setEnabled(true);
		return config;
	}
	

	
	
	
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		SpringApplication.run(HoteloApplication.class, args);
	}

}
