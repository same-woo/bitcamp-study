// 세션 다루기 - 세션의 값을 무효화시키는 방법
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/c03_4")

// 세션에 보관된 값 중에서 현재 페이지 컨트롤러에서 사용할 값을 지정한다.
// 또한 세션에 보관할 값이기도 하다.
@SessionAttributes({"name", "age", "tel"})
public class Controller03_4 {

  // 테스트:
  // http://.../app2/c03_4/setp1?name=hong
  @GetMapping(value = "step1", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String step1(String name, Model model) {
    model.addAttribute("name", name);
      return "이름 저장했음";
  }

  // 테스트2:
  // http://.../app2/c03_4/setp2?age=20
  @GetMapping(value = "step2", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String step2(int age, Model model) {
    model.addAttribute("age", age);
    return "나이 저장했음";
  }

  // 테스트3:
  // http://.../app2/c03_4/setp3?tel=1111
  @GetMapping(value = "step3", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String step3(String tel, Model model) {
    model.addAttribute("tel", tel);
    return "전화번호 저장했음";
  }


  // 테스트3:
  // http://.../app2/c03_4/setp4
  @GetMapping(value = "step4", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String step4(
          @ModelAttribute("name") String name,
          @ModelAttribute("age") int age,
          @ModelAttribute("tel") String tel,
          SessionStatus status) {

    // 이 페이지 컨트롤러가 작업을 하는 동안 세션에 임시 보관했던 값들은
    // 예를 들어, DB에 저장한 후 세션에서 제거한다.
    status.setComplete();

    return String.format("name=%s, age=%s, tel=%s 를 DB에 저장했음!\n",
            name, age, tel);
  }

}


