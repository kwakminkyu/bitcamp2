package com.bitcamp2.mylist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.io.FileReader2;
import com.bitcamp2.io.FileWriter2;
import com.bitcamp2.mylist.domain.Todo;
import com.bitcamp2.util.ArrayList;

@RestController
public class TodoController {

  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception {
    todoList = new ArrayList();
    FileReader2 in = new FileReader2("todos.csv");

    String line;
    while((line = in.readLine()).length() != 0) {
      todoList.add(Todo.valueOf(line));
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
    FileWriter2 out = new FileWriter2("todos.csv");
    for (Object obj : todoList.toArray()) {
      Todo todo = (Todo)obj;
      out.println(todo.toCsvString());
    }
    out.close();
    return 0;
  }
}
