package com.bitcamp2.mylist;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.domain.Book;
import com.bitcamp2.util.ArrayList;

@RestController
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    bookList = new ArrayList();
    FileReader in = new FileReader("books.csv");
    StringBuilder buf = new StringBuilder();

    int c;
    while(true) {
      c = in.read();

      if (c == -1) {
        break;
      }

      if (c == '\n') {
        bookList.add(Book.valueOf(buf.toString()));
        buf.setLength(0);
      } else {
        buf.append((char)c);
      }
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
    FileWriter out = new FileWriter("books.csv");
    for (Object obj : bookList.toArray()) {
      Book book = (Book)obj;
      out.write(book.toCsvString() + "\n");
    }
    out.close();
    return 0;
  }
}
