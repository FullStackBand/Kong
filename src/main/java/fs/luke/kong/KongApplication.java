package fs.luke.kong;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KongApplication {

    public static void main(String[] args) {

        SpringApplication.run(KongApplication.class, args);
    }

}
