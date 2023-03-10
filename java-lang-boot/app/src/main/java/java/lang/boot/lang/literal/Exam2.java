package java.lang.boot.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 리터럴 : 숫자를 표현하는 다양한 방법 - 진수법
@RestController
@RequestMapping("/lang/literal/exam2")
public class Exam2 {

  @GetMapping("/test1")
  public int test1() {return 100;}

  @GetMapping("/test2")
  public int test2() {return 0144;}

  @GetMapping("/test3")
  public int test3() {return 0b0110_0100;}

  @GetMapping("/test4")
  public int test4() {return 0x64;}
}
