package com.springapp.mvc.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Prakhash on 8/26/15.
 */
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {


            String failiurResponseDecider = (String) httpServletRequest.getSession().getAttribute("userLoginRemainder");

        //failiurResponseDecider has to be checked in order to remove null pointer exception

            System.out.println("Testing the new modification in jenkins");

            System.out.println("Testing the new second in jenkins");


        httpServletResponse.sendRedirect("login");
    }
}
