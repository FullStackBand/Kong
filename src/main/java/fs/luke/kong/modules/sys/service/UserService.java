package fs.luke.kong.modules.sys.service;

import fs.luke.kong.core.Service.BaseService;
import fs.luke.kong.modules.sys.entity.User;
import fs.luke.kong.modules.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements BaseService<User> {
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
        return null;
    }

    /**
     * 根据entity具体条件查询
     *
     * @param entity
     * @return
     */
    @Override
    public User get(User entity) {
        return null;
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
    public List<User> find(User entity) {
        return null;
    }

    /**
     * 保存一条
     *
     * @param entity
     * @Param entity
     */
    @Override
    public int insert(User entity) {
        return 0;
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
    @Override
    public void update(User entity) {

    }
}
