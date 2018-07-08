package com.action;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.serviceimpl.UserServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class UserUpdate {
    public String userName;                                             //用户名
    public String userPw;                                               //新密码
    public String terminus;
    public String mobile;
    public String contacts;
    public UserServiceImpl userService;
    private User user;
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    public void setUserName(String userName) {
        try {
            this.userName = new String(userName.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPw(String userPw) {
        try {
            this.userPw = new String(userPw.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getUserPw() {
        return userPw;
    }

    public void setTerminus(String terminus) {
        this.terminus = terminus;
    }

    public String getTerminus() {
        return terminus;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        try {
            this.contacts =new String(contacts.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getMobile() {
        return mobile;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String updateuser(){                                                 //更新
        System.out.println(userName+userPw+terminus+mobile+contacts);
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user1 = new User();
        if (userName==""||userName==null){
            return "fail";
        }
        if (userPw==""||userPw==null){
            return "fail";
        }
        System.out.println(session.getAttribute("userName"));
        if (session.getAttribute("userName").equals(userName)&&userService.isExists(userName,terminus)){
            user1.setUserName(userName);
            user1.setUserPw(userPw);
            user1.setMobile(mobile);
            user1.setContacts(contacts);
            userService.update(user1);
            System.out.println("成功更新");
            return "success";
        }
        return "fail";
        //System.out.println(userName+userPw);


    }
}
