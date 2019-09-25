package com.backbase.service.auth.service;

import com.backbase.service.auth.dao.UserDAOImpl;
import com.backbase.service.auth.domain.CustomExternalUser;
import org.springframework.stereotype.Component;


@Component
public class CustomUserService {

    private final UserDAOImpl userDao;

    public CustomUserService(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    public CustomExternalUser retrieveUser(String username, String password) {
        return userDao.loadUserByUsernameAndPassword(username, password);
    }
}