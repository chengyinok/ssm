package com.ssm.login.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ssm.user.entity.User;
import com.ssm.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chengyin on 2017/8/20.
 */
@Controller
@RequestMapping("/sys")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @ApiOperation(value = "用户登录")
    @RequestMapping(value="/login", method= RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String login(HttpServletRequest request,@RequestBody User user){
        String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";
        String username = user.getUserName();
        String password = user.getUserAccount();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        logger.info("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            logger.info("对用户[" + username + "]进行登录验证..验证通过");
            resultPageURL = "main";
        }catch(UnknownAccountException uae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
//            request.setAttribute("message_login", "未知账户");
        }catch(IncorrectCredentialsException ice){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
//            request.setAttribute("message_login", "密码不正确");
        }catch(LockedAccountException lae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
//            request.setAttribute("message_login", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
//            request.setAttribute("message_login", "用户名或密码错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
           logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
//            request.setAttribute("message_login", "用户名或密码不正确");
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            user=userService.selectOne(new EntityWrapper<>(user));
            User sessionUser= (User) request.getSession().getAttribute("userAccount");
            if(user == null && sessionUser == null){
                return InternalResourceViewResolver.FORWARD_URL_PREFIX +"/sys/toLogin";
            }
            request.setAttribute("userAccount", user);
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", user);
            session.setAttribute("token", token);
            return "forward:/sys/theHome";
        }else{
            token.clear();
            return InternalResourceViewResolver.REDIRECT_URL_PREFIX +"/sys/toLogin";
        }
    }


    /**
     * 用户登出
     */
    @ApiOperation(value = "用户退出")
    @RequestMapping(value = "/logout",method = RequestMethod.POST ,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String logout(HttpSession session){
        String currentUser = (String) session.getAttribute("userAccount");
        SecurityUtils.getSubject().logout();
        logger.info("用户[" + currentUser + "]已登出");
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @ApiOperation(value = "调整登录页面")
    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    @ResponseBody
    public String toLogin(){
        return "page/login";
    }

}
