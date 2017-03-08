package com.mall.handler;

import com.mall.application.ApplicationContextLisenter;
import com.mall.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangxiaoyu on 17/3/5.
 */
public class AuthenticationFailHandlerImpl extends SimpleUrlAuthenticationFailureHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

//    @Autowired
//    UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {


        //可以在这里捕获异常然后 返回对应的错误信息给前台
//        用户名不存在:UsernameNotFoundException;
//        密码错误:BadCredentialException;
//        帐户被锁:LockedException;
//        帐户未启动:DisabledException;
//        密码过期:CredentialsExpiredException;等等!
//        if (e instanceof BadCredentialsException){
//            Object usrename =  httpServletRequest.getAttribute("username");
            String account =  httpServletRequest.getParameter("account");
//
//            IAccountService accountService = ApplicationContextLisenter.getService("accountService");
//            httpServletRequest.getSession().setAttribute("info",e.getMessage());
//        }else if(e instanceof LockedException){
//            httpServletRequest.getSession().setAttribute("info","帐户被锁");
//        }else if(e instanceof CredentialsExpiredException){
//            httpServletRequest.getSession().setAttribute("info","密码过期");
//        }else if(e instanceof UsernameNotFoundException){
//            httpServletRequest.getSession().setAttribute("info","用户名不存在");
//        }else if(e instanceof DisabledException){
//            httpServletRequest.getSession().setAttribute("info","帐户未启动");
//        }else {
//            httpServletRequest.getSession().setAttribute("info","未知错误");
//        }
        httpServletRequest.getSession().setAttribute("info",e.getMessage());
        httpServletRequest.getSession().setAttribute("account",account);

        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/login?failed=true");
    }
}
