package com.group4.source.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.group4.source.Service.Session.Session;
import com.group4.source.Model.User;
@Service
public class AuthorizeInterceptor implements HandlerInterceptor {
    @Autowired
    Session sessionService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
                             Object handler) throws Exception {
        String uri = req.getRequestURI();
        User user = sessionService.getAttribute("user");

        String error = "";

        if(user == null) {
            error="Not logged in!";
            resp.sendRedirect("/account/login?error=" + error);
            return false;
        }
//        else if(!user.getAdmin() && uri.startsWith("/home/admin")) {
//            error="Access denined!";
//            resp.sendRedirect("/account/accessDeny?error=" + error);
//            return false;
//        }
        return true;
    }
}
