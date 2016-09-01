package org.nzcn.landing.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by kinlin on 8/26/16.
 */
@Entity
public class ItemType extends BaseEntity{

    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
