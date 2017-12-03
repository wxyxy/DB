package com.bwei.retrofit;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class NewslistBean {
    /**
     * ctime : 2017-06-06 15:00
     * title : 真是很少见！日本一家银行只存姑娘不存钱
     * description : 明星花边
     * picUrl : http://www.luanbian.com/d/file/lishi/yiyu/2017-06-05/small8681bec69f9c1d6a43ef920082d04bf21496647674.jpg
     * url : http://www.luanbian.com//lishi/yiyu/25329.html
     */
    @Id(autoincrement = true)
    private Long id;
    private String ctime;
    private String title;
    private String description;
    private String picUrl;
    private String url;

    @Generated(hash = 1402622097)
    public NewslistBean(Long id, String ctime, String title, String description, String picUrl, String url) {
        this.id = id;
        this.ctime = ctime;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    @Generated(hash = 923354944)
    public NewslistBean() {
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewslistBean{" +
                "id=" + id +
                ", ctime='" + ctime + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}