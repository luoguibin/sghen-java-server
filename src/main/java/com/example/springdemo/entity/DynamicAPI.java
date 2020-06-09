package com.example.springdemo.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

public class DynamicAPI {

    private BigInteger id;
    private String name;
    private String comment;
    private String content;

    private int status;
    private Timestamp timeCreate;
    private Timestamp timeUpdate;

    private BigInteger userId;
    private String suffixPath;
    private int count;

    public DynamicAPI(BigInteger id, String name, String suffixPath) {
        this.id = id;
        this.name = name;
        this.suffixPath = suffixPath;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Timestamp getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getSuffixPath() {
        return suffixPath;
    }

    public void setSuffixPath(String suffixPath) {
        this.suffixPath = suffixPath;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}