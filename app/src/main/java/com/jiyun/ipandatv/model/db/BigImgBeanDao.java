package com.jiyun.ipandatv.model.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Lenovo on 2017/9/16.
 */
@Entity(nameInDb = "imgdao")
public class BigImgBeanDao {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "imgs")
    private String imgs;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "time")
    private String time;
    @Generated(hash = 1555331774)
    public BigImgBeanDao(Long id, String imgs, String title, String time) {
        this.id = id;
        this.imgs = imgs;
        this.title = title;
        this.time = time;
    }
    @Generated(hash = 691487527)
    public BigImgBeanDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImgs() {
        return this.imgs;
    }
    public void setImgs(String imgs) {
        this.imgs = imgs;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    
}
