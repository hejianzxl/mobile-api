package com.hejian.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.mobile.core.factory.DubboServiceFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispatchApi {
	
	@RequestMapping("/v1/api")
	public void execute(HttpServletRequest request) {
		String method = request.getParameter("_m");
		String token = request.getHeader("_t");
		String sign = request.getHeader("_s");
		
		// redis 获取对应api mehtod----> dubbo method
		String interfaceName = "com.jyly.mydubbo.service.Student"; // xx.getInfo
		method = "getName";
		
		// 参数类型
		List<String> paramTypeList = new ArrayList<>();
		paramTypeList.add(long.class.getName());  //后端接口参数类型
     
		// 参数
		Map<String, Object> paramInfos= new HashMap<>();
        paramInfos.put("id", 2000);
       //paramInfos.put("name", "test");
       
        // 调用服务方
        DubboServiceFactory  dubbo = DubboServiceFactory.getInstance();
        Object result = dubbo.genericInvoke(interfaceName, method, paramTypeList, paramInfos);
        if(result instanceof HashMap) {
        	((HashMap) result).remove("class");
        }
        System.out.println("=============" + result);
	}
}
