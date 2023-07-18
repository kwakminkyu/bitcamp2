package com.bitcamp2.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.mylist.domain.Todo;
import com.bitcamp2.util.ArrayList;

@RestController
public class TodoController {

  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception {
    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("todos.ser")));

    while(true) {
      try {
        Todo todo = (Todo)in.readObject();

        todoList.add(todo);
      } catch (Exception e) {
        break;
      }
    }
    in.close();
  }

  @GetMapping("/todo/list")
  public Object list() {
    return todoList.toArray(); 
  }

  @GetMapping("/todo/add")
  public int add(Todo todo) {
    todoList.add(todo);
    return todoList.size();
  }

  @GetMapping("/todo/update")
  public int update(int index, Todo todo) {
    if (index == -1) {
      return 0;
    }
    return todoList.set(index,todo) == null ? 0 : 1;
  }

  @GetMapping("/todo/check")
  public int check(int index, boolean done) {
    if (index == -1) {
      return 0;
    }
    ((Todo)todoList.get(index)).setDone(done);
    return 1;
  }

  @GetMapping("/todo/delete")
  public Object delete(int index) {
    if (index == -1) {
      return 0;
    }
    return todoList.remove(index);
  }

  @GetMapping("/todo/save")
  public Object save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("todos.ser")));

    for (Object obj : todoList.toArray()) {
      out.writeObject(obj);
    }
    out.close();
    return todoList.toArray().length;
  }
}
