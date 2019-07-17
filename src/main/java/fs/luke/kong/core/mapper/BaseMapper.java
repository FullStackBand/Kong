package fs.luke.kong.core.mapper;

import fs.luke.kong.core.entity.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaseMapper<T> {

    /**
     * 根据ID查询
     *
     * @param id
     * @return T
     */
    T get(String id);

    /**
     * 根据entity 条件查询
     *
     * @param entity
     * @return T
     */
    T get(T entity);

    /**
     * 查找所有
     *
     * @param entity
     * @return
     */
    List<T> findAll(T entity);

    /**
     * 根据条件查询 分页
     *
     * @param entity
     * @return
     */
    List<T> find( T entity);

    /**
     * 保存一条
     *
     * @Param entity
     */
    int insert(T entity);

    /**
     * 删除
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 逻辑删除 即 del_flag = 0 ;
     *
     * @param entity
     */
    void deleteLogic(T entity);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);
}
