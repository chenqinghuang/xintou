package com.hn.sanya.xintou.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统初始化加载时调用的方法，用于初始化字典配置、缓存、环境等
 * @author ZSX
 */

@Component
@Order(value = 1)  // @Order 注解的执行优先级是按value值从小到大顺序
public class MyStartupRunner implements CommandLineRunner {
	
	private static Log logger = LogFactory.getLog(MyStartupRunner.class);
	

	@Override
	public void run(String... args) throws Exception {

		System.out.println("恭喜你！系统启动完毕！！！");

	}

}
