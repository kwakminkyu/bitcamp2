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

    //    이렇게 서버에서 웹브라우저가 출력할 화면을
    //    HTML을 만들어 보내는 것을
    //    "서버측 렌더링(server-side-rendering)" 이라 부른다

    //    String html = "<!DOCTYPE html>"
    //    + "<html>"
    //    + "<head>"
    //    + "<meta charset=\"UTF-8\">"
    //    + "<title>변수 활용</title>"
    //    + "</head>"
    //    + "<body>"
    //    + "<h1>계산 결과</h1>"
    //    + "<p>" + v1 + " " + op + " " + v2 + " " + result + "</p>"
    //    + "</body>"
    //    + "</html>";
    //    
    //    return html;
  }
}