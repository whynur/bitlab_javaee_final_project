package kz.bitlab.javaee.final_project.model;

import java.sql.Timestamp;

public class News {
    Long id;
    Timestamp postDate;
    int categoryId;
    String title;
    String content;

    public News() {
    }

    public News(Long id, Timestamp postDate, int categoryId, String title, String content) {
        this.id = id;
        this.postDate = postDate;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
}
