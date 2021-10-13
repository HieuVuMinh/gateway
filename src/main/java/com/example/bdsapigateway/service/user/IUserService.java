package com.example.bdsapigateway.service.user;

import com.example.bdsapigateway.model.User;
import com.example.bdsapigateway.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends GeneralService<User>, UserDetailsService {
    User findByUserName(String userName);

}
