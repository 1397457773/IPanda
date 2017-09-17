package com.jiyun.ipandatv.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 2017/9/15.
 */
@Entity
public class DaoTopBean {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "order")
    private String order;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "type")
    private String type;
    @Property(nameInDb = "url")
    private String url;
    @Generated(hash = 1551807589)
    public DaoTopBean(Long id, String order, String title, String type,
            String url) {
        this.id = id;
        this.order = order;
        this.title = title;
        this.type = type;
        this.url = url;
    }
    @Generated(hash = 614155449)
    public DaoTopBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrder() {
        return this.order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
