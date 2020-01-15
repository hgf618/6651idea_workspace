package com.myzf.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 登录拦截器
 */
public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object objUser= ActionContext.getContext().getSession().get("LOGIN_USER");
        if(objUser==null){
            ServletActionContext.getRequest().setAttribute("msg", "请先登录");
            return "login";
        }else{
            return actionInvocation.invoke();
        }

    }
}
