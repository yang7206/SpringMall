package com.mall.handler;

import com.mall.controller.BaseController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yangxiaoyu on 17/3/3.
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        String targetUrl = getTargetUrl(authentication);
        if (httpServletResponse.isCommitted()) return;

        BaseController.logger.info("targetUrl :"+targetUrl);
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,targetUrl);
    }


    private String getTargetUrl(Authentication authentication){
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority auth :
                authorities) {
            roles.add(auth.getAuthority());
        }

        if (isAdmin(roles)) {
            return "/admin";
        } else if (isUser(roles)){
            return "/personcenter";
        }
        return "/";

    }

    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_USER")) {
            return true;
        }
        return false;
    }

    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ROLE_ADMIN")) {
            return true;
        }
        return false;
    }

    private boolean isManager(List<String> roles) {
        if (roles.contains("ROLE_MANAGER")) {
            return true;
        }
        return false;
    }
}
