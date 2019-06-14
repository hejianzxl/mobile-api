package com.hejian.mobile.client.model.domain;

import java.io.Serializable;
import java.util.Date;

public class GroupDO implements Serializable {
    private Long id;

    private String groupName;

    private String minCode;

    private String maxCode;

    private String owner;

    private Integer isDeleted;

    private String creator;

    private String modifier;

    private Date gmtCreated;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMinCode() {
        return minCode;
    }

    public void setMinCode(String minCode) {
        this.minCode = minCode;
    }

    public String getMaxCode() {
        return maxCode;
    }

    public void setMaxCode(String maxCode) {
        this.maxCode = maxCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}