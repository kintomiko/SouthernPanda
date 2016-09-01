package org.nzcn.landing.repositories.handlers;

import org.nzcn.landing.models.User;
import org.nzcn.landing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by kinlin on 8/27/16.
 */
@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @HandleBeforeCreate
    public void handleUserCreate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @HandleBeforeSave
    public void handleUserUpdate(User user) {
        if (user.getPassword() == null || user.getPassword().equals("")) {
            //keeps the last password
            User storedUser = userRepository.findOne(user.getId());
            user.setPassword(storedUser.getPassword());
        }
        else {
            //password change request
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
    }
}