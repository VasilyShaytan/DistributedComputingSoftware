package org.edu.kspt.service;


import org.edu.kspt.entity.ProductInStock;
import org.edu.kspt.entity.UserOrder;

import java.util.List;

public interface UserOrderService {

    //public UserOrder findUserByEmail(String email);

    UserOrder getUserOrderById(int id);
    ProductInStock getProductPriceOrderById(int id);

    void saveUserOrder(UserOrder userOrder);
    void updateUserOrder(int uoid, int uid, int am, byte smo, byte sppo, byte sfpo);
    void deleteUserOrder(int userOrderId);



    List<ProductInStock> findAllByOrderByProductNameAsc();
    List<ProductInStock> findAllByOrderByProductNameDesc();

    List<UserOrder> findAllByOrderByAmountAsc();
    List<UserOrder> findAllByOrderByAmountDesc();
}
