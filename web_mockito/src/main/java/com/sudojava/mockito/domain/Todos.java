package com.sudojava.mockito.domain;

public class Todos {
    private int id;
    private String description;
    private String title;
    private int version;

    @Override
    public String toString() {
        return "Todos{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", version=" + version +
                '}';
    }

    public Todos() {
    }

    public Todos(int id, String description, String title, int version) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
