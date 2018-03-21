package org.edu.kspt.controllers;

/*import org.edu.kspt.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.edu.kspt.service.ClientService;

import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;
    private String sortDateMethod = "ASC";

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Client> clients = filterAndSort();
        model.addAttribute("clients_th", clients);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "admin/home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

    @GetMapping("/auth")
    public String authLogin(Model model) {
        List<Client> clients = filterAndSort();
        model.addAttribute("clients_th", clients);
        model.addAttribute("sort", sortDateMethod);
        return "auth";
    }

    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client_th", client);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String updateClient(@RequestParam Integer id, @RequestParam String login,
                             @RequestParam String password, @RequestParam String name,
                             @RequestParam String surname, @RequestParam int roleid,
                             @RequestParam int money) {
        clientService.updateClient(id, login, password, name, surname, roleid, money);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newClient() {
        return "operations/new";
    }

    @PostMapping("/save")
    public String saveClient(@RequestParam String login, @RequestParam String password,
                             @RequestParam String name, @RequestParam String surname,
                             @RequestParam int roleid, @RequestParam int money) {
        clientService.saveClient(new Client(login, password, name, surname, roleid, money));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return "redirect:/";
    }

    private List<Client> filterAndSort() {
        List<Client> clients = null;
        switch (sortDateMethod) {
            case "ASC":
                clients = clientService.findAllByOrderByDateAsc();
                break;
            case "DESC":
                clients = clientService.findAllByOrderByDateDesc();
                break;
        }
        return clients;
    }

}*/
