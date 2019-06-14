package com.hejian.mobile.client.dto;

import java.io.Serializable;

/**
 * @author hejian 
 * Date:2019年6月14日下午4:52:50 
 */
public class ApiDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String interfaceName;
	
	private String methodName;
	
	private String paramType;
	
	public ApiDTO(String interfaceName, String methodName, String paramType) {
		this.interfaceName = interfaceName;
		this.methodName = methodName;
		this.paramType = paramType;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	@Override
	public String toString() {
		return "ApiDTO [interfaceName=" + interfaceName + ", methodName=" + methodName + ", paramType=" + paramType
				+ "]";
	}
}
