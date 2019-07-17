package fs.luke.kong.core.Service;

import fs.luke.kong.core.entity.BaseEntity;
import fs.luke.kong.core.entity.Page;
import fs.luke.kong.modules.sys.entity.DataRule;
import fs.luke.kong.modules.sys.entity.User;
import fs.luke.kong.modules.sys.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public abstract class BaseService<T> {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 数据范围过滤
     * <p>
     * <p>
     * 未写完
     *
     * @param entity 当前过滤的实体类
     */
    public static void dataRuleFilter(BaseEntity<?> entity) {
        // 获取当前登录用户

        entity.setCurrentUser(UserUtils.getUser());
        // 获取角色
        List<DataRule> dataRuleList = UserUtils.getDataRuleList();

        // 如果是超级管理员，则不过滤数据
        if (dataRuleList.size() == 0) {
            return;
        }

        // 数据范围
        StringBuilder sqlString = new StringBuilder();


        for (DataRule dataRule : dataRuleList) {
            // 获取数据权限的sql

        }

        entity.setDataScope(sqlString.toString());

    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public abstract T get(String id);

    /**
     * 根据entity具体条件查询
     *
     * @param entity
     * @return
     */
    public abstract User get(T entity);

    /**
     * 查找所有
     *
     * @param entity
     * @return
     */
    public abstract List<T> findAll(T entity);

    /**
     * 根据条件查询
     *
     * @param entity
     * @return
     */
    public abstract Page<T> find(Page<T> page, T entity);

    /**
     * 保存一条
     *
     * @param entity
     * @Param entity
     */
    public abstract void insert(User entity);

    /**
     * 删除
     *
     * @param entity
     */
    public abstract void delete(User entity);

    /**
     * 逻辑删除 即 del_flag = 0 ;
     *
     * @param entity
     */
    public abstract void deleteLogic(User entity);

    /**
     * 更新
     *
     * @param entity
     */
    public abstract void update(User entity);
}