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
    if(ArrayList.contacts.length == ArrayList.size) {
      ArrayList.contacts = ArrayList.grow();
    }
    ArrayList.contacts[ArrayList.size++] = contact;
    return ArrayList.size;
  }

  @GetMapping("/contact/get")
  public Object get(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return "";
    }
    return ArrayList.contacts[index];
  }

  @GetMapping("/contact/update")
  public Object update(Contact contact) {
    int index = ArrayList.indexOf(contact.email);
    if (index == -1) {
      return "";
    }
    ArrayList.contacts[index] = contact;
    return ArrayList.contacts[index];
  }

  @GetMapping("/contact/delete")
  public Object delete(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return 0;
    }
    return ArrayList.remove(index);
  }
}
