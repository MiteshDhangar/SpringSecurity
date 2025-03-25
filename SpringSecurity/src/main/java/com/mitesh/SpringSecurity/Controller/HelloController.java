package com.mitesh.SpringSecurity.Controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("csrf")
    public CsrfToken getcsrf(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }

    @GetMapping("hello")
    public String hello(HttpServletRequest req){
        return "Java is Awesome"+ req.getSession().getId();
    }
    @GetMapping("about")
    public String about(HttpServletRequest req){
        return "Mitesh "+ req.getSession().getId();
    }
}
