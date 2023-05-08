package kz.bitlab.javaee.final_project.model;


import java.sql.Timestamp;

public class Comments {
    Long id;
    String comment;
    Timestamp postDate;
    Users users;
    News news;

    public Comments() {
    }

    public Comments(Long id, String comment, Timestamp postDate, Users users, News news) {
        this.id = id;
        this.comment = comment;
        this.postDate = postDate;
        this.users = users;
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
