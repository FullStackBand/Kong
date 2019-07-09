package fs.luke.kong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fs.luke.kong.**.mapper")
public class KongApplication {

    public static void main(String[] args) {
        SpringApplication.run(KongApplication.class, args);
    }

}
