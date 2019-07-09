package fs.luke.kong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("hello")
    public String Hello() {
        return "Hello Spring Boot ...";
    }
}
