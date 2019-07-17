package fs.luke.kong.core.mapper;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.io.Serializable;
import java.util.Properties;

/**
 * 分页拦截器
 *
 * @author luke
 * @version v0.1
 * @date 2019年7月17日
 */
public class PageInterceptor implements Interceptor, Serializable {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
