package com.myzf.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import java.util.Locale;

public class LanguageAction {

    public String execute(){
        String localString= ServletActionContext.getRequest().getParameter("request_locale");
        String[] strs=localString.split("_");
        Locale locale=new Locale(strs[0],strs[1]);
        ActionContext.getContext().setLocale(locale);//设置上下文本地化
        return "index";
    }

}
