package com.bitcamp2.mylist;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.domain.Todo;
import com.bitcamp2.util.ArrayList;

@RestController
public class TodoController {

  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception {
    todoList = new ArrayList();
    FileReader in = new FileReader("todos.csv");
    StringBuilder buf = new StringBuilder();

    int c;
    while(true) {
      c = in.read();

      if (c == -1) {
        break;
      }

      if (c == '\n') {
        todoList.add(Todo.valueOf(buf.toString()));
        buf.setLength(0);
      } else {
        buf.append((char)c);
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
    FileWriter out = new FileWriter("todos.csv");
    for (Object obj : todoList.toArray()) {
      Todo todo = (Todo)obj;
      out.write(todo.toCsvString() + "\n");
    }
    out.close();
    return 0;
  }
}
