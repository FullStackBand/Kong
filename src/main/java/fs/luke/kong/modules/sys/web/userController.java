package fs.luke.kong.modules.sys.web;

import fs.luke.kong.core.entity.Page;
import fs.luke.kong.modules.sys.entity.User;
import fs.luke.kong.modules.sys.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("user")
public class userController {
    @Autowired
    UserService userService;

    @ModelAttribute
    public User get(@RequestParam(required = false) String id) {
        User entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = userService.get(id);
        }
        if (entity == null) {
            entity = new User();
        }
        return entity;
    }

    @ResponseBody
    @RequestMapping("list")
    public Page<User> getList(HttpServletRequest request, HttpServletResponse response, User user) {
        userService.find(new Page<User>(request,response), user);
        return null;
    }
}
