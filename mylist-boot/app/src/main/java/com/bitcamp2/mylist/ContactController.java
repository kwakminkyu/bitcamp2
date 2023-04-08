package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  String[] contactList = new String[5];
  int count = 0;

  @GetMapping("/contact/list")
  public Object list() {
    String[] arr = new String[count];
    for (int i = 0; i < count; i++) {
      arr[i] = contactList[i];
    }
    return arr;
  }

  @GetMapping("/contact/add")
  public int add(String name, String email, String tel, String company) {
    if (count == 5) {
      return 0;
    }
    contactList[count++] = createCSV(name, email, tel, company);
    return count;
  }

  @GetMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList[index];
  }

  @GetMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    contactList[index] = createCSV(name, email, tel, company);
    return contactList[index];
  }

  @GetMapping("/contact/delete")
  public int delete(String email) {
    for (int i = 0; i < count; i++) {
      if (contactList[i].split(",")[1].equals(email)) {
        for (int j = i + 1; j < count; j++) {
          contactList[j - 1] = contactList[j];
        }
        count--;
        return 1;
      }
    }
    return 0;
  }

  public String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }

  public int indexOf(String email) {
    for (int i = 0; i < count; i++) {
      if (contactList[i].split(",")[1].equals(email)) {
        return i;
      }
    }
    return -1;
  }
}
