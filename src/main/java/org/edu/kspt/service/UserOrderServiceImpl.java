package org.edu.kspt.service;

import org.edu.kspt.entity.ProductInStock;
import org.edu.kspt.entity.UserOrder;
import org.edu.kspt.repository.ProductInStockRepository;
import org.edu.kspt.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userOrderService")
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private ProductInStockRepository productInStockRepository;


    /*@Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }*/

    @Override
    public UserOrder getUserOrderById(int id) {
        return userOrderRepository.getOne(id);
    }

    @Override
    public ProductInStock getProductPriceOrderById(int id) {
        return productInStockRepository.getOne(id);
    }

    @Override
    public void saveUserOrder(UserOrder userOrder) {
        System.out.println("&&&&&&&&&&&&&&&&+++++++++++&&&&&&&&&&&&&&&&&&&");
        userOrderRepository.save(userOrder);
        ///user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setPassword(user.getPassword());
        ///user.setActive(1);
        ///Role userRole = roleRepository.findByRole("ADMIN");
        ///user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        ///userRepository.save(user);
    }

    @Override
    public void updateUserOrder(int uoid, int uid, int am, byte smo, byte sppo, byte sfpo) {
        UserOrder updated = userOrderRepository.getOne(uoid);
        updated.setUserId(uid);
        updated.setAmount(am);
        updated.setStatusMOrder(smo);
        updated.setStatusPPayOrder(sppo);
        updated.setStatusFullPayOrder(sfpo);
        userOrderRepository.save(updated);
    }

    @Override
    public void deleteUserOrder(int id) {
        userOrderRepository.deleteById(id);
    }

    @Override
    public List<ProductInStock> findAllByOrderByProductNameAsc() {
        return productInStockRepository.findAllByOrderByProductNameAsc();
    }

    @Override
    public List<ProductInStock> findAllByOrderByProductNameDesc() {
        return productInStockRepository.findAllByOrderByProductNameDesc();
    }


    @Override
    public List<UserOrder> findAllByOrderByAmountAsc() {
        return userOrderRepository.findAllByOrderByAmountAsc();
    }

    @Override
    public List<UserOrder> findAllByOrderByAmountDesc() {
        return userOrderRepository.findAllByOrderByAmountDesc();
    }
}
