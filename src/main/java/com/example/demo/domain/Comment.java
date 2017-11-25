package com.example.demo.domain;

import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name")    
    private String name;
    
    @Column(name = "comment")    
    private String comment;
    
    @Column(name = "timeStamp")
    private long ts;
    
////    @Column(name = "title")
////    private String title;
    
    @Transient
    private String tsdiff;
    
    public Comment() {
    }
    
    public Comment(String name, String comment) {
        super();
        this.name = name;
        this.comment = comment;
        this.ts = System.currentTimeMillis() / 1000;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', comment='%s']",
                id, name, comment);
    }

////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getTsdiff() {
        return calculateTime(System.currentTimeMillis() / 1000 - ts);
    }
    
    public void setTsdiff(String tsdiffStr) {
        this.tsdiff = tsdiffStr;
    }
    
    
    private String calculateTime(long totalSeconds) {
        int days = (int) TimeUnit.SECONDS.toDays(totalSeconds);
        long hours = TimeUnit.SECONDS.toHours(totalSeconds) - (days * 24);
        long minutes = TimeUnit.SECONDS.toMinutes(totalSeconds) - (TimeUnit.SECONDS.toHours(totalSeconds) * 60);
        long seconds = TimeUnit.SECONDS.toSeconds(totalSeconds) - (TimeUnit.SECONDS.toMinutes(totalSeconds) * 60);

        String ret = seconds + " seconds ago";
        if (minutes > 0) {
            ret = minutes + " minutes " + ret;
        }
        if (hours > 0) {
            ret = hours + " hours " + ret;
        }
        if (days > 0) {
            ret = days + " days " + ret;
        }
        return ret;
    }
}