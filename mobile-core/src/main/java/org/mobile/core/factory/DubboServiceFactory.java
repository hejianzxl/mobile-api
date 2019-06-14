package org.mobile.core.factory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;

@Component
public class DubboServiceFactory {
	private ApplicationConfig applicationConfig;
	private RegistryConfig registryConfig;

	private static class SingletonHolder {
		private static DubboServiceFactory INSTANCE = new DubboServiceFactory();
	}

	private DubboServiceFactory() {
		/*Properties prop = new Properties();
		ClassLoader loader = DubboServiceFactory.class.getClassLoader();

		try {
			prop.load(loader.getResourceAsStream("dubboconf.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("mydubbo1");
		// 这里配置了dubbo的application信息*(demo只配置了name)*，因此demo没有额外的dubbo.xml配置文件
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress("47.100.39.251:2181");
		registryConfig.setProtocol("zookeeper");
		// 这里配置dubbo的注册中心信息，因此demo没有额外的dubbo.xml配置文件

		this.applicationConfig = applicationConfig;
		this.registryConfig = registryConfig;

	}

	public static DubboServiceFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public Object genericInvoke(String interfaceClass, String methodName,List<String> paramTyeps,Map<String, Object> parameters) {
		ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
		reference.setApplication(applicationConfig);
		reference.setRegistry(registryConfig);
		reference.setInterface(interfaceClass); // 接口名
		reference.setGeneric(true); // 声明为泛化接口
		reference.setVersion("1.0.0");
		// ReferenceConfig实例很重，封装了与注册中心的连接以及与提供者的连接，
		// 需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏。
		// API方式编程时，容易忽略此问题。
		// 这里使用dubbo内置的简单缓存工具类进行缓存

		ReferenceConfigCache cache = ReferenceConfigCache.getCache();
		GenericService genericService = cache.get(reference);
		// 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
		String[] paramTypes = new String[paramTyeps.size()];
		/*parameters.forEach((k, v) -> {
			
		});;*/
		for(int i=0;i<paramTyeps.size(); i++) {
			paramTypes[i] = paramTyeps.get(i);
		}
		return genericService.$invoke(methodName, paramTypes, new Object[] {2000});
	}
}
