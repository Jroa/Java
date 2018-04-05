package pe.com.jroa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorld {

	@WebMethod(operationName="saludar")
	public String saludar();
}
