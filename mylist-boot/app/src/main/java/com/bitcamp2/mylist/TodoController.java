package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  @GetMapping("/todo/list")
  public Object list() {
    return ArrayList2.toArray(); 
  }

  @GetMapping("/todo/add")
  public int add(Todo todo) {
    ArrayList2.add(todo);
    return ArrayList2.size;
  }

  @GetMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index == -1) {
      return "";
    }
    return ArrayList2.set(index,todo) == null ? 0 : 1;
  }

  @GetMapping("/todo/delete")
  public Object delete(int index) {
    if (index == -1) {
      return 0;
    }
    return ArrayList2.remove(index);
  }
}
