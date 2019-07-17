package fs.luke.kong.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Entity支持类
 *
 * @author luke
 * @version v0.2
 * @date 2019年7月17日
 */
public abstract class BaseEntity<T> implements Serializable {

    /**
     * 删除标记（正常）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    /**
     * 删除标记（删除）
     */
    public static final String DEL_FLAG_DELETE = "1";
    /**
     * 删除标记（审核）
     */
    public static final String DEL_FLAG_AUDIT = "2";
    /**
     * 逐渐策略 UUID
     */
    public static final String IDTYPE_UUID = "UUID";
    /**
     * 逐渐策略 AUTO
     */
    public static final String IDTYPE_AUTO = "AUTO";
    private static final long serialVersionUID = 1L;
    /**
     * 实体编号（唯一标识）
     */
    protected String id;
    /**
     * 自定义SQL（SQL标识，SQL内容）
     */
    protected String dataScope;
    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;
    /**
     * 主键策略（默认：UUID）
     */
    protected String IdType = IDTYPE_UUID;
    /**
     * 当前实体分页对象
     */
    protected Page<T> page;
    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    private String delFlag;

    public BaseEntity() {

    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    @JsonIgnore
    public static String getDelFlagNormal() {
        return DEL_FLAG_NORMAL;
    }

    @JsonIgnore
    public static String getDelFlagDelete() {
        return DEL_FLAG_DELETE;
    }

    @JsonIgnore
    public static String getDelFlagAudit() {
        return DEL_FLAG_AUDIT;
    }

    @JsonIgnore
    public static String getIdtypeUuid() {
        return IDTYPE_UUID;
    }

    @JsonIgnore
    public static String getIdtypeAuto() {
        return IDTYPE_AUTO;
    }

    @JsonIgnore
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();

    @JsonIgnore
    @Length(min = 1, max = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    @JsonIgnore
    @XmlTransient
    public Page<T> getPage() {
        if (page == null) {
            page = new Page<T>();
        }
        return page;
    }

    public Page<T> setPage(Page<T> page) {
        this.page = page;
        return page;
    }

    @JsonIgnore
    public boolean isNewRecord() {
        return isNewRecord;
    }

    public void setNewRecord(boolean newRecord) {
        isNewRecord = newRecord;
    }
    @JsonIgnore
    public String getIdType() {
        return IdType;
    }

    public void setIdType(String idType) {
        IdType = idType;
    }
}
