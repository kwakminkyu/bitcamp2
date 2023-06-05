package com.bitcamp2.mylist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.io.FileReader2;
import com.bitcamp2.io.FileWriter2;
import com.bitcamp2.mylist.domain.Book;
import com.bitcamp2.util.ArrayList;

@RestController
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    bookList = new ArrayList();
    FileReader2 in = new FileReader2("books.csv");

    String line;
    while((line = in.readLine()).length() != 0) {
      bookList.add(Book.valueOf(line));
    }
    in.close();
  }

  @GetMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @GetMapping("/book/add")
  public int add(Book book) {
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
    return bookList.set(index,book) == null ? 0 : 1;
  }

  @GetMapping("/book/delete")
  public Object delete(int index) {
    return bookList.remove(index) == null ? 0 : 1;
  }

  @GetMapping("/book/save")
  public Object save() throws Exception {
    FileWriter2 out = new FileWriter2("books.csv");
    for (Object obj : bookList.toArray()) {
      Book book = (Book)obj;
      out.println(book.toCsvString());
    }
    out.close();
    return 0;
  }
}
