package com.example.springboot.pojo;

/**
 * @author Jackasher
 * @version 1.0
 * @className Reviews
 * @since 1.0
 **/
public class Reviews {

    private String author;
    private String title;
    private String category;
    private String content;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
