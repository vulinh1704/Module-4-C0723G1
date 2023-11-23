package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("counter")
public class DemoCookie {

    //    @GetMapping("/index")
//    public String count(@CookieValue(value = "count", defaultValue = "0") Long counter, HttpServletResponse httpServletResponse, Model model){
//        counter++;
//        Cookie cookie = new Cookie("count", counter.toString());
//        cookie.setMaxAge(60 * 60 * 24);
//        httpServletResponse.addCookie(cookie);
//        model.addAttribute("cookieValue", counter);
//        return "demo";
//    }

    @GetMapping("/index")
    public String get(@ModelAttribute("counter") Long counter, HttpSession httpSession, Model model) {
        Long count = (Long) httpSession.getAttribute("counter");
        if(count == null) {
            count = 0L;
        } else  {
            count++;
        }
        httpSession.setAttribute("counter", count);
        model.addAttribute("sessionValue", count);
        return "demo";
    }
}
