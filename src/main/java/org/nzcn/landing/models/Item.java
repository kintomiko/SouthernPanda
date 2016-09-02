package org.nzcn.landing.models;
import org.nzcn.landing.enums.ItemCategory;

import javax.persistence.*;

/**
 * Created by kinlin on 8/26/16.
 */
@Entity
public class Item extends BaseEntity{

    private String title;
    private ServiceProvider serviceProvider;
    private ItemCategory itemCategory;
    private ItemType itemType;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Enumerated(EnumType.STRING)
    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    @ManyToOne
    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
