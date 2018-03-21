package org.edu.kspt.repository;

import org.edu.kspt.entity.ProductInStock;
import org.edu.kspt.entity.User;
import org.edu.kspt.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

    List<UserOrder> findAllByOrderByAmountAsc();
    List<UserOrder> findAllByOrderByAmountDesc();
}
