package com.bitcamp2.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.domain.Book;
import com.bitcamp2.util.ArrayList;

@RestController
public class BookController {

  ArrayList bookList = new ArrayList();

  @GetMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @GetMapping("/book/add")
  public int add(Book book) {
    book.setReadDate(new Date(System.currentTimeMillis()));
    bookList.add(book);
    return bookList.size();
  }

  @GetMapping("/book/get")
  public Object get(int index) {
    if (index == -1) {
      return "";
    }
    return bookList.get(index);
  }

  @GetMapping("/book/update")
  public int update(int index, Book book) {
    if (index == -1) {
      return 0;
    }
    Book old = (Book)bookList.get(index);
    book.setReadDate(old.getReadDate());
    return bookList.set(index,book) == null ? 0 : 1;
  }

  @GetMapping("/book/delete")
  public Object delete(int index) {
    return bookList.remove(index) == null ? 0 : 1;
  }
}
