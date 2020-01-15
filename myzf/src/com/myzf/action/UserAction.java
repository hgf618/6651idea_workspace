package com.myzf.action;

import com.opensymphony.xwork2.ActionContext;
import com.myzf.entity.User;
import com.myzf.service.UserService;
import com.myzf.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 用户控制层
 */
public class UserAction extends ActionSupport {
    private User user;
    private String upass2;
    private UserService userService=new UserServiceImpl();

    /**
     * 登录
     * @return
     */
    public String login(){
        User loginUser=userService.checkLogin(user);
        if(loginUser!=null){
            ActionContext.getContext().getSession().put("LOGIN_USER",loginUser);//把登录用户放入到session中
          //  ActionContext.getContext().getApplication().put("LOGIN_COUNT", 1);//获取Application
            return "success";
        }else{
           // return "error";
            HttpServletRequest request=ServletActionContext.getRequest();  //获取Servet请求
            HttpServletResponse response=ServletActionContext.getResponse();//获取响应
            try {
                request.setAttribute("msg", "账号或者密码错误");
                request.getRequestDispatcher("login.jsp").forward(request, response);//跳转页面
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 登录验证
     */
    /*
    public void validateLogin(){
        if(user.getUname()==null||user.getUname().equals("")){
            addFieldError("unameError", "用户名不能为空");
        }
        if(user.getUpass()==null||user.getUpass().equals("")){
            addFieldError("userPassError", "密码不能为空");
        }
    }
*/
    /**
     * 注册
     * @return
     */
    public String register(){
        if(userService.save(user)){
            return "login";
        }else{
            return "error";
        }
    }


    /**
     * 注册验证
     */
    /*
    public void validateRegister(){
        if(user.getUname()==null||user.getUname().equals("")){
            addFieldError("unameError", "用户名不能为空!");
        }
        if(user.getUpass()==null||user.getUpass().equals("")){
            addFieldError("userPassError", "密码不能为空!");
        }
        if(!user.getUpass().equals(upass2)){
            addFieldError("userPassError2", "两次密码不一致!");
        }

    }*/


    public String logOut(){
        ActionContext.getContext().getSession().remove("LOGIN_USER");
       // ActionContext.getContext().getSession().clear();//清空session
        return "logOutSuccess";
    }

    //////////////////////////////////////////////
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUpass2() {
        return upass2;
    }

    public void setUpass2(String upass2) {
        this.upass2 = upass2;
    }
}
