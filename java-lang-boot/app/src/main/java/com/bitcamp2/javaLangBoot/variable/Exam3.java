package com.bitcamp2.javaLangBoot.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  배열 : 같은 종류의 메모리를 여러 개 만드는 명령문
@RestController("lang.variable.exam3") // 동일 이름의 클래스 충돌 방지
@RequestMapping("/lang/variable/exam3")
public class Exam3 {

  //  테스트 URL:
  //  => http://localhost:8080/lang/variable/exam3/test

  //  100 => byte
  @GetMapping("/test1")
  public String test1(byte value) {
    return " => " + value;
  }

  //  32767 => short
  @GetMapping("/test2")
  public String test2(short value) {
    return " => " + value;
  }

  //  456789 => int
  @GetMapping("/test3")
  public String test3(int value) {
    return " => " + value;
  }

  //  2244445555 => long
  @GetMapping("/test4")
  public String test4(long value) {
    return " => " + value;
  }

  //  3.14 => float
  @GetMapping("/test5")
  public String test5(float value) {
    return " => " + value;
  }

  //  3456.7898 => double
  @GetMapping("/test6")
  public String test6(double value) {
    return " => " + value;
  }

  //  true => boolean
  //  true, 1, TRUE => true
  //  false, 0, FALSE => false
  @GetMapping("/test7")
  public String test7(boolean value) {
    return " => " + value;
  }

  //  "가" => char
  @GetMapping("/test8")
  public String test8(char value) {
    return " => " + value;
  }
}