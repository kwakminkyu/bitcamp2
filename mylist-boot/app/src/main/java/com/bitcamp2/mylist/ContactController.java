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
    return 1;
  }
}
