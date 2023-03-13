package com.bitcamp2.javaLangBoot.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  변수 선언 -> 값을 저장할 메모리를 준비시키는 명령문
@RestController("lang.variable.exam1") // 동일 이름의 클래스 충돌 방지
@RequestMapping("/lang/variable/exam1")
public class Exam1 {

  //  테스트 URL:
  //  => http://localhost:8080/lang/variable/exam1/test

  //  문자열 변수 선언과 값의 범위
  @GetMapping("/test1")
  public String test1(String v1) {
    return "클라이언트에서 받은 값 = " + v1;
  }

  //  정수 변수 선언과 값의 범위
  @GetMapping("/test2")
  public String test2(byte b, short s, int i, long l) {
    return "클라이언트에서 받은 값 = " + b + "," + s + "," + i + "," + l;
  }

  //  부동소수점 변수 선언과 값의 범위
  @GetMapping("/test3")
  public String test3(float f, double d) {
    return "클라이언트에서 받은 값 = " + f + "," + d;
  }

  //  문자 변수 선언과 값의 범위
  @GetMapping("/test4")
  public String test4(char c) {
    return "클라이언트에서 받은 값 = " + c + "," + (int)c;
  }

  //  논리 변수 선언과 값의 범위
  @GetMapping("/test5")
  public String test5(boolean b) {
    return "클라이언트에서 받은 값 = " + b;
  }
}