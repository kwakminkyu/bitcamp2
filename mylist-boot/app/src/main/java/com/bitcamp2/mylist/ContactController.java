package com.bitcamp2.mylist;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.domain.Contact;
import com.bitcamp2.util.ArrayList;

@RestController
public class ContactController {

  ArrayList contactList;

  public ContactController() throws Exception {
    contactList = new ArrayList();
    FileReader in = new FileReader("contacts.csv");
    StringBuilder buf = new StringBuilder();

    int c;
    while(true) {
      c = in.read();

      if (c == -1) {
        break;
      }

      if (c == '\n') {
        contactList.add(Contact.valueOf(buf.toString()));
        buf.setLength(0);
      } else {
        buf.append((char)c);
      }
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
    FileWriter out = new FileWriter("contacts.csv");
    for (Object obj : contactList.toArray()) {
      Contact contact = (Contact)obj;
      out.write(contact.toCsvString() + "\n");
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
