package com.demo.browser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crete by Marlon
 * Create Date: 2018/4/18
 * Class Describe
 **/

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping
    public Object test(Authentication authentication) {
        System.out.println("-------------------------" + "test");
        return authentication;
    }

    @GetMapping("/me")
    public Object me(@AuthenticationPrincipal UserDetails userDetails) {
        //SecurityContextHolder.getContext().getAuthentication()
        System.out.println("-------------------------" + "me");
        return userDetails ;
    }


/**
 * {
 authorities: [{
 authority: "admin"
 }],
 details: {
 remoteAddress: "0:0:0:0:0:0:0:1",
 sessionId: "59099BFAC649625CA3D9B19D527AE0BF"
 },
 authenticated: true,
 principal: {
 password: null,
 username: "admin",
 authorities: [{
 authority: "admin"
 }],
 accountNonExpired: true,
 accountNonLocked: true,
 credentialsNonExpired: true,
 enabled: true
 },
 credentials: null,
 name: "admin"
 }
 */

}
