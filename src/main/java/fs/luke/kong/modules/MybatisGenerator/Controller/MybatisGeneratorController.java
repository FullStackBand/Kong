package fs.luke.kong.modules.MybatisGenerator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@RequestMapping("generator")
public class MybatisGeneratorController {
    //@Autowired
    //DataSourceProperties dataSourceProperties;

    @Autowired
    ApplicationContext applicationContext;

    //@Resource(name = "myDataSource")
    //private DataSource myDataSource;

    @RequestMapping("gen")
    public String gen() {
        //DataSource bean = applicationContext.getBean(DataSource.class);
        return "";
    }
}
