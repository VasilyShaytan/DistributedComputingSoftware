package org.edu.kspt.service;

import org.edu.kspt.entity.Client;

import java.util.List;

public interface ClientService {
    Client getClientById(Integer id);
    void saveClient(Client client);
    void updateClient(Integer id, String login, String password, String name, String surname, int roleid, int money);
    void deleteClient(Integer id);
    List<Client> findAllByOrderByDateAsc();
    List<Client> findAllByOrderByDateDesc();
}
