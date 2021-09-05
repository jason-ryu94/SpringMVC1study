package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        log.debug("debug log = {}" + name);
        // 위와 같이 써도 되지만 위는 연산이 먼저 일어나기 때문에 의미없는 메모리나 속도에서 비효율적이다.

        // 위를 설정하면 아래의 모든 정보들이 같이 표시된다 .
        // 프로퍼티에 logging.level.hello.springmvc=.. 으로 클래스 레벨을 설정할 수 있다.
        // 개발서버는 debug, 운영서버는 info 출력을 한다.
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log = {}", name);

        return "ok";
    }
}
