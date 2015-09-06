package com.jroa.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jroa.common.form.HelloWorldForm;

public class HelloWorldAction extends Action{

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) 
			throws Exception{
		
		HelloWorldForm helloWorldForm = (HelloWorldForm)form;
		helloWorldForm.setMessage("Hello World! Struts");
		
		return mapping.findForward("success");
	}
}
