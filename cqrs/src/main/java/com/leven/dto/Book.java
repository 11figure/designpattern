package com.leven.dto;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:44 2018/8/21
 * @Modified By:
 */
public class Book {
    private String title;
    private double price;
    private Author author;

    public Book() {
    }

    public Book(String title, double price, Author author) {

        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
