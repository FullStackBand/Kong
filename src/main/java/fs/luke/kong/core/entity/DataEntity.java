package fs.luke.kong.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import fs.luke.kong.common.utils.IdGen;
import fs.luke.kong.modules.sys.entity.User;
import fs.luke.kong.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class DataEntity<T> extends BaseEntity {
    /**
     * 最后 更新人
     */
    private User updateBy;
    /**
     * 最后更新时间
     * 数据库自动维护
     */
    private Date updateDate;
    /**
     * 创建人
     */
    private User createBy;
    /**
     * 创建时间
     * 数据库自动维护
     */
    private Date createDate;

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    /**
     * 插入之前执行方法，子类实现
     */
    @Override
    public void preInsert() {

        if (!this.isNewRecord) {
            setId(IdGen.uuid());//生成主键
        }
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())) {
            this.updateBy = user;
            this.createBy = user;
        }

    }

    /**
     * 更新之前执行方法，子类实现
     */
    @Override
    public void preUpdate() {
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())) {
            this.updateBy = user;
        }


    }
}
