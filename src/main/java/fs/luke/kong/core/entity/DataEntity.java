package fs.luke.kong.core.entity;

import fs.luke.kong.common.utils.IdGen;
import fs.luke.kong.core.mapper.persistence.Page;
import fs.luke.kong.modules.sys.entity.User;
import fs.luke.kong.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Date;

public class DataEntity<T> extends BaseEntity<T> {
    private static final long serialVersionUID = 1L;

    protected String remarks;    // 备注
    protected User createBy;    // 创建者
    protected Date createDate;    // 创建日期
    protected User updateBy;    // 更新者
    protected Date updateDate;    // 更新日期
    protected String delFlag;    // 删除标记（0：正常；1：删除；2：审核）

    public DataEntity() {

    }

    /**
     * 插入之前执行方法，子类实现
     */
    @Override
    public void preInsert() {
        if(ObjectUtils.allNotNull(id) && id.length()!=0){
            id = IdGen.getUUID();
        }
        updateBy = UserUtils.getUser();
        createBy = UserUtils.getUser();
    }


    /**
     * 更新之前执行方法，子类实现
     */
    @Override
    public void preUpdate() {
        updateBy = UserUtils.getUser();
    }
}
