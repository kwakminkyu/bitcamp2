package com.bitcamp2.mylist;

import java.sql.Date;

public class Board {
  String title;
  String content;
  int viewCount;
  Date createDate;

  @Override
  public String toString() {
    return "Board [title=" + title + ", content=" + content + ", viewCount=" + viewCount
        + ", createDate=" + createDate + "]";
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

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
}
