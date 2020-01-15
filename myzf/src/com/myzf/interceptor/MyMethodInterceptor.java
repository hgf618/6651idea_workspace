package com.myzf.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 演示方法拦截器
 */
public class MyMethodInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object objUser= ActionContext.getContext().getSession().get("LOGIN_USER");
        if(objUser==null){
            ServletActionContext.getRequest().setAttribute("msg", "请先登录");
            return "login";
        }else{
            return actionInvocation.invoke();
        }
    }
}
