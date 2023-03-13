package com.bitcamp2.javaLangBoot.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  배열 : 같은 종류의 메모리를 여러 개 만드는 명령문
@RestController("lang.variable.exam2") // 동일 이름의 클래스 충돌 방지
@RequestMapping("/lang/variable/exam2")
public class Exam2 {

  //  테스트 URL:
  //  => http://localhost:8080/lang/variable/exam2/test

  //  여러 개의 값을 받는 방법 : 배열 사용 전
  @GetMapping("/test1")
  public String test1(String name1, String name2, String name3) {
    return " => " + name1 + "," + name2+ "," + name3;
  }

  //  여러 개의 값을 받는 방법 : 배열 사용 후
  @GetMapping("/test2")
  public String test2(String[] name) {
    return " => " + name[0] + "," + name[1]+ "," + name[2];
  }
}