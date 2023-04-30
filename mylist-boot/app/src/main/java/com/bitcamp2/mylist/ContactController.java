package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  ArrayList contactList = new ArrayList();

  @GetMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @GetMapping("/contact/add")
  public int add(Contact contact) {
    contactList.add(contact);
    return contactList.size;
  }

  @GetMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList.list[index];
  }

  @GetMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return "";
    }
    return contactList.set(index,contact) == null ? 0 : 1;
  }

  @GetMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    return contactList.remove(index);
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size; i++) {
      if (((Contact)contactList.list[i]).email.equals(email)) {
        return i;
      }
    }
    return -1;
  }
}
