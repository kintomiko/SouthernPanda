package org.nzcn.landing.rest;

import org.nzcn.landing.models.User;
import org.nzcn.landing.services.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kinlin on 8/27/16.
 */
@RepositoryRestController
public class UserController {

    @Autowired
    BaseRestService<User> userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user, @PathVariable String userId){
        User oldUser = userService.findObject(userId);
        user.setPassword(oldUser.getPassword());
        return userService.update(userId, user);
    }
}
