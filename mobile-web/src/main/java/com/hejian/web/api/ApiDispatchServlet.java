package com.hejian.web.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mobile.core.factory.DubboServiceFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hejian.mobile.client.dto.ApiDTO;

@WebServlet(value="/*")
public class ApiDispatchServlet extends HttpServlet {
	
	// 模拟缓存
	static Map<String, ApiDTO> cache = new java.util.concurrent.ConcurrentHashMap<String, ApiDTO>();
	
	static {
		ApiDTO apiDTO1 = new ApiDTO("com.jyly.mydubbo.service.Student", "getName",long.class.getName());
		ApiDTO apiDTO2 = new ApiDTO("com.jyly.mydubbo.service.Student", "getInfo","com.jyly.mydubbo.dto.Person");
		cache.put("user.getName", apiDTO1);
		cache.put("user.getInfo", apiDTO2);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _m = request.getParameter("_m");
		String token = request.getHeader("_t");
		String sign = request.getHeader("_s");
		
		// 鉴权相关
		
		// 模拟获取对应api mehtod----> dubbo method
		ApiDTO apiDTO = cache.get(_m);
		String interfaceName = apiDTO.getInterfaceName(); // xx.getInfo
		String method = apiDTO.getMethodName();
		
		// 参数类型
		List<String> paramTypeList = new ArrayList<>();
		paramTypeList.add(apiDTO.getParamType());  //后端接口参数类型
     
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
        response.getWriter().print(result);
	}
	
}
