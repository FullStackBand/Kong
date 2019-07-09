/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package fs.luke.kong.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * DAO支持类实现
 *
 * @param <T>
 * @author jeeplus
 * @version 2017-05-16
 */
public interface BaseMapper<T> {

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public T get(T entity);

    /**
     * 根据实体名称和字段名称和字段值获取唯一记录
     *
     * @param propertyName
     * @param value
     * @return
     */
    public T findUniqueByProperty(@Param(value = "propertyName") String propertyName, @Param(value = "value") Object value);


    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity);

    /**
     * 查询所有数据列表
     *
     * @param entity
     * @return
     */
    public List<T> findAllList(T entity);


    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(T entity);


    /**
     * 删除数据（逻辑删除，更新del_flag字段为1,在表包含字段del_flag时，可以调用此方法，将数据隐藏）
     *
     * @param entity
     * @return int
     * @see public int delete(T entity)
     */
    public int deleteByLogic(T entity);

    @Select("${sql}")
    public List<Map<String, Object>> execSelectSql(@Param(value = "sql") String sql);

    @Update("${sql}")
    public void execUpdateSql(@Param(value = "sql") String sql);

    @Insert("${sql}")
    public void execInsertSql(@Param(value = "sql") String sql);

    @Delete("${sql}")
    public void execDeleteSql(@Param(value = "sql") String sql);

}