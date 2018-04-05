package pe.com.jroa;

import javax.jws.WebService;

@WebService(endpointInterface="pe.com.jroa.HelloWorld", serviceName="saludarws")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String saludar() {
		return "Hello World";
	}

}
