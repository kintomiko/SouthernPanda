package org.nzcn.landing.services;

import org.nzcn.landing.models.Item;

/**
 * Created by kinlin on 8/27/16.
 */
public interface BaseRestService<T> {

    T create(T object);

    T findObject(String id);

    Iterable<T> findAll();

    T update(String id, T object);
}
