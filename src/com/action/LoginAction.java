package com.action;

import com.model.Across;
import com.opensymphony.xwork2.ActionContext;
import com.serviceimpl.AcrossServiceImpl;
import com.serviceimpl.TrainServiceImpl;
import com.serviceimpl.UserServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class LoginAction {
    public String userName;                                                         //用户名
    public String userPw;                                                           //密码
    public UserServiceImpl userService;
    public TrainServiceImpl trainService;
    public AcrossServiceImpl acrossService;
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public AcrossServiceImpl getAcrossService() {
        return acrossService;
    }

    public TrainServiceImpl getTrainService() {
        return trainService;
    }

    public void setAcrossService(AcrossServiceImpl acrossService) {
        this.acrossService = acrossService;
    }

    public void setTrainService(TrainServiceImpl trainService) {
        this.trainService = trainService;
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
        this.userPw = userPw;
    }

    public String getUserPw() {
        return userPw;
    }

    public String login(){                                              //登录功能
        if (userName==""||userName==null){                          //判断是否为空或不存在
            return "fail";
        }
        if (userPw==""||userPw==null){
            return "fail";
        }
        System.out.println(userName+userPw);
        if (userService.isExists(userName,userPw)){                         //判断登录的用户账号是否存在

            Map session = ActionContext.getContext().getSession();              //使用Struts 封装的session
            session.put("userName",userName );                                  //存入session
            HttpSession session1 = ServletActionContext.getRequest().getSession();
            session1.setAttribute("userName",userName);
            return "success";
        }
        else
            return "fail";
    }

    public String findMinPath(String from, String to, Date date)//最短路径
    {
        JSONArray train = trainService.selectTrain(from, to, date);
        double path = 0,minpath=0;
        String trainId1 ="0";//最短路径对应的车次Id
        List<Across> acrosses;
        if (train.isEmpty()!=true)
        {

            for (int i=0;i<train.size();i++)
            {
                JSONObject train1 = train.getJSONObject(i);
                String trainId =(String)train1.get("id");
                acrosses=acrossService.findAcross(trainId);
                int j=0;
                for (j=0;j<acrosses.size();j++)
                    if(acrosses.get(j).getStation()==from)
                        break;
                while(acrosses.get(j).getNextStation()!=to)
                {
                    path+=acrosses.get(j).getDistance();
                    j++;//往across表中存数据时按照车次所经站点依次顺序存储。
                }
                if (i==0)
                {
                    minpath=path;
                }
                if(path<minpath)
                {
                    minpath=path;
                    trainId1 =trainId;
                }
            }

            Map session = ActionContext.getContext().getSession();
            session.put("minPath",minpath);
            session.put("MinPathTrainId",trainId1);
            HttpSession session1 = ServletActionContext.getRequest().getSession();
            session1.setAttribute("minPath",minpath);
            session1.setAttribute("MinPathTrainId",trainId1);
            return "sucess";
        }
        else
            return "fail";
    }

    public String findAcross(String from, String to, Date date)
    {
        JSONArray train = trainService.selectTrain(from, to, date);
        List<Across> acrosses;
        if (train.isEmpty()!=true)
        {
            Map session = ActionContext.getContext().getSession();
            HttpSession session1 = ServletActionContext.getRequest().getSession();
            for (int i=0;i<train.size();i++)
            {
                JSONObject train1 = train.getJSONObject(i);
                String trainId = (String) train1.get("trainId");
                acrosses=acrossService.findAcross(trainId);

                session.put("across"+i,acrosses);
                session1.setAttribute("across"+i,acrosses);
            }
            return "sucess";
        }
        else
            return "fail";
    }
}
