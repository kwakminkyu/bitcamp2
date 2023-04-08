package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  String[] contactList;
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
    if(contactList.length == count) {
      contactList = grow();
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
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    return remove(index);
  }

  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }

  int indexOf(String email) {
    for (int i = 0; i < count; i++) {
      if (contactList[i].split(",")[1].equals(email)) {
        return i;
      }
    }
    return -1;
  }

  String remove(int index) {
    String old = contactList[index];
    for (int i = index + 1; i < count; i++) {
      contactList[i - 1] = contactList[i];
    }
    count--;
    return old;
  }

  String[] grow() {
    String[] arr = new String[newlength()];
    copy(contactList, arr);
    return arr;
  }

  int newlength() {
    return contactList.length + (contactList.length >> 1);
  }

  void copy(String[] source, String[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }
}
