package com.bitcamp2.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  @GetMapping("/contact/list")
  public Object list() {
    String[] arr = {"aaa", "aaa@test.com", "010-1111-2222", "aaaCompany"};
    return arr;
  }

  //  @GetMapping("/contact/add")
  //  public Object add() {
  //
  //  }
}
