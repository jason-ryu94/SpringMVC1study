package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age = {}", username, age);

        response.getWriter().write("ok");
    }


    // /request-param-v2?username=kjef&age=12   와 같은 형태로 온다.
    @ResponseBody   // @RestController와 같은 효과로 반환된 문자를 그냥 전달
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    /**
     * 파라미터 이름과 변수명이 같으면 @RequestParam 생략 가능하다.
     * @RequestParam(required=true) 면 꼭 들어와야하는 변수, 기본값이 true이다.
     * int 는 Null 이 불가능, Integer는 Null 이 가능하다.
     * @ReqeustParam(defaultValue = "") 안들어왔을 때 기본값 지정
     * @RequestParam 을 다 받고 싶으면 Map 으로 받으면된다.
     *
     */
}
