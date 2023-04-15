package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  Contact[] contactList = new Contact[5];
  int count = 0;

  @GetMapping("/contact/list")
  public Object list() {
    Contact[] arr = new Contact[count];
    for (int i = 0; i < count; i++) {
      arr[i] = contactList[i];
    }
    return arr;
  }

  @GetMapping("/contact/add")
  public int add(Contact contact) {
    if(contactList.length == count) {
      contactList = grow();
    }
    contactList[count++] = contact;
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
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return "";
    }
    contactList[index] = contact;
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

  int indexOf(String email) {
    for (int i = 0; i < count; i++) {
      if (contactList[i].email.equals(email)) {
        return i;
      }
    }
    return -1;
  }

  Contact remove(int index) {
    Contact old = contactList[index];
    for (int i = index + 1; i < count; i++) {
      contactList[i - 1] = contactList[i];
    }
    count--;
    return old;
  }

  Contact[] grow() {
    Contact[] arr = new Contact[newlength()];
    copy(contactList, arr);
    return arr;
  }

  int newlength() {
    return contactList.length + (contactList.length >> 1);
  }

  void copy(Contact[] source, Contact[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }
}
