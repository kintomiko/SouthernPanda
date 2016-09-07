package org.nzcn.landing.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.nzcn.landing.models.Item;
import org.nzcn.landing.models.User;
import org.nzcn.landing.repositories.ItemRepository;
import org.nzcn.landing.repositories.UserRepository;
import org.nzcn.landing.services.BaseRestService;
import org.nzcn.landing.services.impl.BaseRestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResourceLoader;

/**
 * Created by kinlin on 8/27/16.
 */
@Configuration
public class ServiceConfig {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Bean
    public BaseRestService<Item> itemService(){
        return new BaseRestServiceImpl<Item>(itemRepository, Item.class);
    }

    @Bean
    public BaseRestService<User> userService(){
        return new BaseRestServiceImpl<User>(userRepository, User.class);
    }

}
