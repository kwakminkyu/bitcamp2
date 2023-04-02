package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  Object[] contactList = new Object[5];
  int count = 0;

  @GetMapping("/contact/list")
  public Object list() {
    return contactList;
  }

  @GetMapping("/contact/add")
  public int add(String name, String email, String tel, String company) {
    String[] arr = {name, email, tel, company};
    if (count == 5) {
      return 0;
    }
    contactList[count] = arr;
    count++;
    return count;
  }

  @GetMapping("/contact/get")
  public Object get(int no) {
    if (contactList[no] == null) {
      return 0;
    }
    return contactList[no];
  }

  @GetMapping("/contact/update")
  public int update(int no, String name, String email, String tel, String company) {
    if (contactList[no] == null) {
      return 0;
    }
    String[] arr = {name, email, tel, company};
    contactList[no] = arr;
    return 1;
  }

  @GetMapping("/contact/delete")
  public int delete(int no) {
    if (contactList[no] == null) {
      return 0;
    }
    for (int i = no; i < count; i++) {
      for (int j = i + 1; j < count; j++) {
        contactList[j - 1] = contactList[j];
      }
      count--;
      return 1;
    }
    return 0;
  }
}
