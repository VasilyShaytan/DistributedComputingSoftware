package org.edu.kspt.controllers;

import org.edu.kspt.entity.Role;
import org.edu.kspt.entity.User;
import org.edu.kspt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/default")
    public String defaultAfterLogin(Authentication authentication/*HttpServletRequest request*/) {

        boolean isAdmin = false;
        boolean isUser = false;
        boolean isProvider = false;
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        System.out.println("-----------------------------");
        System.out.println(authorities);
        System.out.println("-----------------------------");
        for (GrantedAuthority grantedAuthority : authorities){
            if (grantedAuthority.getAuthority().equals("USER")) {
                isUser = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("PROVIDER")) {
                isProvider = true;
                break;
            }
        }

        if (isAdmin) {
            return "redirect:/admin/home";
        } else if (isUser) {
            return "redirect:/user/home";
        } else if (isProvider) {
            return "redirect:/provider/home";
        } else {
            throw new IllegalStateException();
        }

    }


    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView homeAdmin(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }



    @RequestMapping(value="/provider/home", method = RequestMethod.GET)
    public ModelAndView homeProvider() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("provider/home");
        return modelAndView;
    }


}