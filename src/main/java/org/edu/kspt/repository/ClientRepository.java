package org.edu.kspt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.edu.kspt.entity.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAllByOrderByDateAsc();
    List<Client> findAllByOrderByDateDesc();
}
