package fs.luke.kong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("fs.luke.kong.modules.sys.mapper")
public class KongApplication {

    public static void main(String[] args) {

        SpringApplication.run(KongApplication.class, args);
    }

}
