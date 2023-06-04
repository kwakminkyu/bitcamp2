package com.bitcamp2.mylist.domain;

import java.sql.Date;

public class Book {
  String title;
  String author;
  String press;
  int page;
  int price;
  String feed;
  Date readDate;

  public Book() {}

  public Book(String csvStr) {
    String[] values = csvStr.split(",");
    this.setTitle(values[0]);
    this.setAuthor(values[1]);
    this.setPress(values[2]);
    this.setPage(Integer.valueOf(values[3]));
    this.setPrice(Integer.valueOf(values[4]));
    this.setFeed(values[5]);
    this.setReadDate(Date.valueOf(values[6]));
  }

  public static Book valueOf(String csvStr) {
    String[] values = csvStr.split(",");

    Book book = new Book();
    book.setTitle(values[0]);
    book.setAuthor(values[1]);
    book.setPress(values[2]);
    book.setPage(Integer.valueOf(values[3]));
    book.setPrice(Integer.valueOf(values[4]));
    book.setFeed(values[5]);
    book.setReadDate(Date.valueOf(values[6]));

    return book;
  }

  public String toCsvString() throws Exception {
    return String.format("%s,%s,%s,%s,%s,%s,%s",
        this.getTitle(),
        this.getAuthor(),
        this.getPress(),
        this.getPage(),
        this.getPrice(),
        this.getFeed(),
        this.getReadDate());
  }

  @Override
  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", press=" + press + ", page=" + page
        + ", price=" + price + ", feed=" + feed + ", readDate=" + readDate + "]";
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getFeed() {
    return feed;
  }

  public void setFeed(String feed) {
    this.feed = feed;
  }

  public Date getReadDate() {
    return readDate;
  }

  public void setReadDate(Date readDate) {
    this.readDate = readDate;
  }
}
