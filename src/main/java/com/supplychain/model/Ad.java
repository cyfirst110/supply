package com.supplychain.model;

import java.io.Serializable;
import java.util.Date;

public class Ad implements Serializable {
    private Integer id;

    private String title;

    private String showlink;

    private String detaillink;

    private Integer showtime;

    private String isshow;

    private String publicer;

    private String type;

    private Date pubtime;

    private Integer sequence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getShowlink() {
        return showlink;
    }

    public void setShowlink(String showlink) {
        this.showlink = showlink == null ? null : showlink.trim();
    }

    public String getDetaillink() {
        return detaillink;
    }

    public void setDetaillink(String detaillink) {
        this.detaillink = detaillink == null ? null : detaillink.trim();
    }

    public Integer getShowtime() {
        return showtime;
    }

    public void setShowtime(Integer showtime) {
        this.showtime = showtime;
    }

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow == null ? null : isshow.trim();
    }

    public String getPublicer() {
        return publicer;
    }

    public void setPublicer(String publicer) {
        this.publicer = publicer == null ? null : publicer.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}