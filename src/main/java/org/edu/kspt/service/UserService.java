package org.edu.kspt.service;

import org.edu.kspt.entity.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
