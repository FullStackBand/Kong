package fs.luke.kong.modules.sys.mapper;


import java.lang.annotation.*;
import java.util.List;
import java.util.Map;

import fs.luke.kong.core.mapper.BaseMapper;
import fs.luke.kong.core.mapper.annotation.MyBatisMapper;
import fs.luke.kong.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Mapper
@MyBatisMapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    @Override
    User get(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    @Override
    User get(User entity);

    /**
     * 根据实体名称和字段名称和字段值获取唯一记录
     *
     * @param propertyName
     * @param value
     * @return
     */
    @Override
    User findUniqueByProperty(String propertyName, Object value);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     *
     * @param entity
     * @return
     */
    @Override
    List<User> findList(User entity);

    /**
     * 查询所有数据列表
     *
     * @param entity
     * @return
     */
    @Override
    List<User> findAllList(User entity);

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    @Override
    int insert(User entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    @Override
    int update(User entity);

    /**
     * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
     *
     * @param entity
     * @return int
     * @see public int delete(T entity)
     */
    @Override
    int deleteByLogic(User entity);

    @Override
    List<Map<String, Object>> execSelectSql(String sql);

    @Override
    void execUpdateSql(String sql);

    @Override
    void execInsertSql(String sql);

    @Override
    void execDeleteSql(String sql);
}