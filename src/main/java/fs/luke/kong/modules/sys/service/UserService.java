package fs.luke.kong.modules.sys.service;

import fs.luke.kong.core.mapper.persistence.Page;
import fs.luke.kong.core.service.BaseService;
import fs.luke.kong.core.service.CrudService;
import fs.luke.kong.modules.sys.entity.User;
import fs.luke.kong.modules.sys.mapper.UserMapper;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends CrudService<UserMapper, User> implements InitializingBean {
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    @Override
    public User get(String id) {
        return super.get(id);
    }

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    @Override
    public User get(User entity) {
        return super.get(entity);
    }

    /**
     * 查询列表数据
     *
     * @param entity
     * @return
     */
    @Override
    public List<User> findList(User entity) {
        return super.findList(entity);
    }

    /**
     * 查询所有列表数据
     *
     * @param entity
     * @return
     */
    @Override
    public List<User> findAllList(User entity) {
        return super.findAllList(entity);
    }

    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    @Override
    public Page<User> findPage(Page<User> page, User entity) {
        return super.findPage(page, entity);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param entity
     */
    @Override
    public void save(User entity) {
        super.save(entity);
    }

    /**
     * 删除全部数据
     *
     * @param entitys
     */
    @Override
    public void deleteAllByLogic(Collection<User> entitys) {
        super.deleteAllByLogic(entitys);
    }

    /**
     * 获取单条数据
     *
     * @param propertyName
     * @param value
     * @return
     */
    @Override
    public User findUniqueByProperty(String propertyName, Object value) {
        return super.findUniqueByProperty(propertyName, value);
    }

    /**
     * 动态sql
     *
     * @param sql
     */
    @Override
    public List<Map<String, Object>> executeSelectSql(String sql) {
        return super.executeSelectSql(sql);
    }

    @Override
    public void executeInsertSql(String sql) {
        super.executeInsertSql(sql);
    }

    @Override
    public void executeUpdateSql(String sql) {
        super.executeUpdateSql(sql);
    }

    @Override
    public void executeDeleteSql(String sql) {
        super.executeDeleteSql(sql);
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
