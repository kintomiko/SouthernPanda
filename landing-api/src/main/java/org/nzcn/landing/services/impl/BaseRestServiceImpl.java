package org.nzcn.landing.services.impl;

import org.nzcn.landing.exceptions.NotFoundException;
import org.nzcn.landing.models.BaseEntity;
import org.nzcn.landing.services.BaseRestService;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kinlin on 8/27/16.
 */
public class BaseRestServiceImpl<T extends BaseEntity> implements BaseRestService<T> {

    private CrudRepository<T, String> repository;

    private Class<T> entityClass;

    public BaseRestServiceImpl(CrudRepository<T, String> repository, Class<T> entityClass) {
        this.repository = repository;
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void setRepository(CrudRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T object) {
        return repository.save(object);
    }

    @Override
    public T findObject(String id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T update(String id, T object) {
        T oldObject = repository.findOne(id);
        if(oldObject == null)
            throw new NotFoundException("Item Not Found!");
        object.setId(id);
        return repository.save(object);
    }

}
