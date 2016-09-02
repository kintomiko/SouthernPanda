package org.nzcn.landing.repositories;

import org.nzcn.landing.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by kinlin on 8/27/16.
 */
@RepositoryRestResource(collectionResourceRel = "items", path = "/item")
public interface ItemRepository extends CrudRepository<Item, String> {
}
