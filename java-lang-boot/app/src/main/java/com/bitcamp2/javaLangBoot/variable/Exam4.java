package com.bitcamp2.javaLangBoot.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  배열 : 같은 종류의 메모리를 여러 개 만드는 명령문
@RestController("lang.variable.exam4") // 동일 이름의 클래스 충돌 방지
@RequestMapping("/lang/variable/exam4")
public class Exam4 {

  @GetMapping("/test1")
  public String test1(int v1, int v2, String op) {
    int result = 0;
    switch (op) {
      case "+": result =v1 + v2; break;
      case "-": result =v1 - v2; break;
      case "*": result =v1 * v2; break;
      case "/": result =v1 / v2; break;
      case "%": result =v1 % v2; break;
      default: return "해당 연산을 수행 할 수 없습니다";
    }
    return "=>" + result;
  }
}