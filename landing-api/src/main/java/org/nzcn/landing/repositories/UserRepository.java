package org.nzcn.landing.repositories;

import org.nzcn.landing.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created by kinlin on 8/27/16.
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "/user")
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findUserByEmail(@Param("email") String email);
}
