package fs.luke.kong.core.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaseService<T> {
    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 根据entity具体条件查询
     *
     * @param entity
     * @return
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
     * 根据条件查询
     *
     * @param entity
     * @return
     */
    List<T> find(T entity);

    /**
     * 保存一条
     *
     * @Param entity
     */
    @Transactional(readOnly = false)
    int insert(T entity);

    /**
     * 删除
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    void delete(T entity);

    /**
     * 逻辑删除 即 del_flag = 0 ;
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    void deleteLogic(T entity);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);
}
