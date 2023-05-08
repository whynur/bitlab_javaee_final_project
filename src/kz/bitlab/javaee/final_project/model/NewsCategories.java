package kz.bitlab.javaee.final_project.model;

public class NewsCategories {
    Long id;
    String name;

    public NewsCategories() {
    }

    public NewsCategories(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
