package fs.luke.kong.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.io.Serializable;
import java.util.Properties;

/**
 * 分页拦截器
 *
 * @author luke
 * @version v0.1
 * @date 2019年7月17日
 * (@Intercepts) 注解 完成插件签名
 * 插件的指定在什么地方使用;
 * 具体到方法
 */
@Intercepts({@Signature(type=Executor.class,method = "query",args = {MappedStatement.class,Object.class,ResultHandler.class})})
public class PageInterceptor implements Interceptor, Serializable {
    /**
     * intercept 拦截:
     * 拦截目标对象的目标方法
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        // 执行
        Object proceed = invocation.proceed();
        return proceed;
    }

    /**
     * plugin:
     * 包装目标对象的
     * 为目标对象创建一个代理对象
     *
     * @param targer
     * @return
     */
    @Override
    public Object plugin(Object targer) {
        Object wrap = Plugin.wrap(targer, this);
        return wrap;
    }

    /**
     * 将插件注册时的 properties设置进来
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        // 可以拿到插件配置的信息
    }
}
