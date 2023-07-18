package com.bitcamp2.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.mylist.domain.Book;
import com.bitcamp2.util.ArrayList;

@RestController
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.ser")));

      bookList = (ArrayList)in.readObject();
      in.close();
    } catch (Exception e) {
      System.out.println("데이턴 로딩 중 오류 발생");
    }
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
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.ser")));

    out.writeObject(bookList);
    out.close();
    return bookList.toArray().length;
  }
}
