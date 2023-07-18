package com.bitcamp2.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.mylist.domain.Contact;
import com.bitcamp2.util.ArrayList;

@RestController
public class ContactController {

  ArrayList contactList = new ArrayList();

  public ContactController() throws Exception {
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("contacts.ser")));

      contactList = (ArrayList)in.readObject();
      in.close();
    } catch (Exception e) {
      System.out.println("데이턴 로딩 중 오류 발생");
    }
  }

  @GetMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @GetMapping("/contact/add")
  public int add(Contact contact) {
    contactList.add(contact);
    return contactList.size();
  }

  @GetMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList.get(index);
  }

  @GetMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
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

  @GetMapping("/contact/save")
  public Object save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("contacts.ser")));

    out.writeObject(contactList);
    out.close();
    return contactList.toArray().length;
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      if (((Contact)contactList.get(i)).getEmail().equals(email)) {
        return i;
      }
    }
    return -1;
  }
}
