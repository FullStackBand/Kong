/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package fs.luke.kong.core.mapper.persistence.interceptor;


import fs.luke.kong.core.mapper.persistence.Page;
import fs.luke.kong.core.mapper.persistence.dialect.Dialect;
import fs.luke.kong.core.mapper.persistence.dialect.db.*;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;


import java.io.Serializable;
import java.util.Properties;

/**
 * Mybatis分页拦截器基类
 *
 * @author luke
 * @version v0.1
 * @date 2019-7-7 09:53:28
 */
public abstract class BaseInterceptor implements Interceptor, Serializable {

}
