package com.bitcamp2.mylist.domain;

public class Todo {
  String title;
  boolean done;

  public Todo() {}

  public Todo(String csvStr) {
    String[] values = csvStr.split(",");
    this.setTitle(values[0]);
    this.setDone(Boolean.valueOf(values[1]));
  }

  public static Todo valueOf(String csvStr) {
    String[] values = csvStr.split(",");

    Todo todo = new Todo();
    todo.setTitle(values[0]);
    todo.setDone(Boolean.valueOf(values[1]));

    return todo;
  }

  public String toCsvString() throws Exception {
    return String.format("%s,%s",
        this.getTitle(),
        this.isDone());
  }

  @Override
  public String toString() {
    return "Todo [title=" + title + ", done=" + done + "]";
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done) {
    this.done = done;
  }

}
