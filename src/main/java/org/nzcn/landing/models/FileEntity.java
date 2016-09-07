package org.nzcn.landing.models;

import javax.persistence.Entity;

/**
 * Created by kinlin on 9/7/16.
 */
@Entity
public class FileEntity extends BaseEntity{

    String path;

    String name;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
