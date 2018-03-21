package org.edu.kspt.service;

import org.edu.kspt.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.edu.kspt.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;

    @Autowired
    public void setProductRepository(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client getClientById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void saveClient(Client client) {
        repository.save(client);
    }

    @Override
    public void updateClient(Integer id, String login, String password, String name, String surname, int roleid, int money) {
        Client updated = repository.getOne(id);
        updated.setLogin(login);
        updated.setPassword(password);
        updated.setName(name);
        updated.setSurname(surname);
        updated.setRoleId(roleid);
        updated.setMoney(money);
        repository.save(updated);
    }

    @Override
    public void deleteClient(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> findAllByOrderByDateAsc() {
        return repository.findAllByOrderByDateAsc();
    }

    @Override
    public List<Client> findAllByOrderByDateDesc() {
        return repository.findAllByOrderByDateDesc();
    }
}
