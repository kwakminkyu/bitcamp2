package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  @GetMapping("/contact/list")
  public Object list() {
    return ArrayList.toArray(); 
  }

  @GetMapping("/contact/add")
  public int add(Contact contact) {
    ArrayList.add(contact);
    return ArrayList.size;
  }

  @GetMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return ArrayList.list[index];
  }

  @GetMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return "";
    }
    return ArrayList.set(index,contact) == null ? 0 : 1;
  }

  @GetMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    return ArrayList.remove(index);
  }

  static int indexOf(String email) {
    for (int i = 0; i < ArrayList.size; i++) {
      if (((Contact)ArrayList.list[i]).email.equals(email)) {
        return i;
      }
    }
    return -1;
  }
}
