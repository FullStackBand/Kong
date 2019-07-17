package fs.luke.kong.modules.sys.service;

import fs.luke.kong.core.Service.BaseService;
import fs.luke.kong.core.entity.Page;
import fs.luke.kong.modules.sys.entity.User;
import fs.luke.kong.modules.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;


    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public User get(String id) {
        return userMapper.get(id);
    }

    /**
     * 根据entity具体条件查询
     *
     * @param entity
     * @return
     */
    @Override
    public User get(User entity) {
        return userMapper.get(entity);
    }

    /**
     * 查找所有
     *
     * @param entity
     * @return
     */
    @Override
    public List<User> findAll(User entity) {
        List<User> userList = userMapper.findAll(entity);
        return userList;
    }

    /**
     * 根据条件查询
     *
     * @param entity
     * @return
     */
    @Override
    public Page<User> find(Page<User> page, User entity) {
        // 数据权限过滤器
        dataRuleFilter(entity);
        //设置分页参数
        entity.setPage(page);
        //执行分页查询
        page.setList(userMapper.find(entity));
        return page;
    }

    /**
     * 保存一条
     *
     * @param entity
     * @Param entity
     */
    @Override
    public void insert(User entity) {
    }

    /**
     * 删除
     *
     * @param entity
     */
    @Override
    public void delete(User entity) {

    }

    /**
     * 逻辑删除 即 del_flag = 0 ;
     *
     * @param entity
     */
    @Override
    public void deleteLogic(User entity) {

    }

    /**
     * 更新
     *
     * @param entity
     */
    public void update(User entity) {

    }
}
