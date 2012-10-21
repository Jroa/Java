package pe.com.jroa.editor;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="editor")
public class EditorBean {

	private String value ="Este es un editor proveido por PrimeFaces";
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
}
