package org.edu.kspt.controllers;

import org.edu.kspt.entity.ProductInStock;
import org.edu.kspt.entity.User;
import org.edu.kspt.entity.UserOrder;
import org.edu.kspt.service.UserOrderService;
import org.edu.kspt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //@Autowired
    private UserOrderService userOrderService;

    @Autowired
    public void setUserOrderService(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    private String sortDateMethod = "ASC";

    @RequestMapping(value="/user/home", method = RequestMethod.GET)
    public ModelAndView homeUser(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());  //auth.getName() - email
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","This page Only for Users with User Role");

        List<UserOrder> userOrders = filterAndSort();
        modelAndView.addObject("userorders_th", userOrders);

        modelAndView.setViewName("user/home");
        return modelAndView;
    }

    private List<UserOrder> filterAndSort() {
        List<UserOrder> userOrders = null;
        switch (sortDateMethod) {
            case "ASC":
                userOrders = userOrderService.findAllByOrderByAmountAsc();
                break;
            case "DESC":
                userOrders = userOrderService.findAllByOrderByAmountDesc();
                break;
        }
        return userOrders;
    }

    @GetMapping("/user/delete/{id}")
    //@RequestMapping(value="/user/delete/{userOrderId}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        userOrderService.deleteUserOrder(id);
        return "redirect:/user/home";
    }

    @GetMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        UserOrder userOrder = userOrderService.getUserOrderById(id);
        model.addAttribute("clientorder_th", userOrder);
        return "user/edit";
    }

    @PostMapping("/user/update")
    public String updateUserOrder(@RequestParam int userOrderId, @RequestParam int userId,
                               @RequestParam int amount, @RequestParam byte statusMOrder,
                               @RequestParam byte statusPPayOrder, @RequestParam byte statusFullPayOrder) {
        userOrderService.updateUserOrder(userOrderId, userId, amount, statusMOrder, statusPPayOrder, statusFullPayOrder);
        return "redirect:/user/home";
    }

    @PostMapping("/user/save")
    public String saveUserOrder(@RequestParam int userId, @RequestParam int amount,
                             @RequestParam byte statusMOrder, @RequestParam byte statusPPayOrder,
                             @RequestParam byte statusFullPayOrder) {
        userOrderService.saveUserOrder(new UserOrder(userId, amount, statusMOrder, statusPPayOrder, statusFullPayOrder));
        return "redirect:/user/home";
    }

    @PostMapping("/user/saveorder")
    public String saveUserOrderProduct(@RequestParam int productId, @RequestParam int productCount) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        int userId = user.getId();
        int productPrice = userOrderService.getProductPriceOrderById(productId).getProductPrice();
        int amount = productCount * productPrice;
        byte smo = 0;
        byte sppo = 0;
        byte sfpo = 0;
        userOrderService.saveUserOrder(new UserOrder(userId, amount, smo, sppo, sfpo));
        //userOrderService.
        return "redirect:/user/home";
    }

    @RequestMapping(value="/user/new", method = RequestMethod.GET)
    public ModelAndView newUserOrder(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());  //auth.getName() - email
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","This page Only for Users with User Role");

        List<ProductInStock> productInStocks = filterAndSortProductInStocks();
        modelAndView.addObject("productInStocks_th", productInStocks);

        modelAndView.setViewName("user/new");
        return modelAndView;
    }

    private List<ProductInStock> filterAndSortProductInStocks() {
        List<ProductInStock> productInStocks = null;
        switch (sortDateMethod) {
            case "ASC":
                productInStocks = userOrderService.findAllByOrderByProductNameAsc();
                break;
            case "DESC":
                productInStocks = userOrderService.findAllByOrderByProductNameDesc();
                break;
        }
        return productInStocks;
    }



    /*@GetMapping("/user/new")
    public String newUserOrder() {

        return "user/new";
    }*/




    /*@GetMapping("/user/home")
    public String list(Model model) {
        List<UserOrder> clients = filterAndSort();
        model.addAttribute("clients_th", clients);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }*/

}
