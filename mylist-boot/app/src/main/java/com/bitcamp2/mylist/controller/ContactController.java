package com.bitcamp2.mylist.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.mylist.domain.Contact;
import com.bitcamp2.util.ArrayList;

@RestController
public class ContactController {

  ArrayList contactList = new ArrayList();

  public ContactController() throws Exception {
    BufferedReader in = new BufferedReader(new FileReader("contacts.csv"));

    String line;
    while((line = in.readLine()) != null) {
      contactList.add(Contact.valueOf(line));
    }
    in.close();
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
    PrintWriter out = new PrintWriter(new FileWriter("contacts.csv"));

    for (Object obj : contactList.toArray()) {
      Contact contact = (Contact)obj;
      out.println(contact.toCsvString());
    }
    out.close();
    return 0;
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
