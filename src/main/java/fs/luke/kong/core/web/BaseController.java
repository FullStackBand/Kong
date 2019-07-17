/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package fs.luke.kong.core.web;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;

import fs.luke.kong.modules.sys.entity.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 控制器支持类
 *
 * @author jeeplus
 * @version 2016-3-23
 */
public abstract class BaseController<T> {

    public final String PAGE_ADD = "add"; // 新增
    public final String PAGE_EDIT = "edit"; // 编辑
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 根据ID查询 , 每次请求必进
     *
     * @param id
     * @return T
     */
    public abstract T get(@RequestParam(required = false) String id);
}
