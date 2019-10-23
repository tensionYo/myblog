package com.tension.myblog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blog {
    private Integer id;

    private String title;

    private String content;

    private String firstpicture;

    private String flag;

    private Integer views;

    private Boolean appreciation;

    private Boolean sharestatement;

    private Boolean commentables;

    private Boolean published;

    private Boolean recomend;

    private Date createtime;

    private Date updatetime;

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
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstpicture() {
        return firstpicture;
    }

    public void setFirstpicture(String firstpicture) {
        this.firstpicture = firstpicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    public Boolean getSharestatement() {
        return sharestatement;
    }

    public void setSharestatement(Boolean sharestatement) {
        this.sharestatement = sharestatement;
    }

    public Boolean getCommentables() {
        return commentables;
    }

    public void setCommentables(Boolean commentables) {
        this.commentables = commentables;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getRecomend() {
        return recomend;
    }

    public void setRecomend(Boolean recomend) {
        this.recomend = recomend;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }


    private Type type;

    private List<Tag> tags = new ArrayList<>();

    private User user;

    private List<Comment> comments = new ArrayList<>();


    public Blog() {

    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstpicture='" + firstpicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", sharestatement=" + sharestatement +
                ", commentables=" + commentables +
                ", published=" + published +
                ", recomend=" + recomend +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}