package org.nzcn.landing.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by kinlin on 8/27/16.
 */
@MappedSuperclass
public abstract class BaseEntity {

    private String id;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
