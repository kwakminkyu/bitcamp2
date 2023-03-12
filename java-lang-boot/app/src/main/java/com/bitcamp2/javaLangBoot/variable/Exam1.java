package com.bitcamp2.javaLangBoot.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam1") // 동일 이름의 클래스 충돌 방지
@RequestMapping("/lang/variable/exam1")
public class Exam1 {

  @GetMapping("/test")
  public String test1(String v1) {
    return "클라이언트에서 받은 값 = " + v1;
  }
}