package org.nzcn.landing.configs;

import org.nzcn.landing.models.Item;
import org.nzcn.landing.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by kinlin on 8/27/16.
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Item.class);
    }

}
