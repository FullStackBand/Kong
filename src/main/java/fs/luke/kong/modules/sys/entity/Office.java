package fs.luke.kong.modules.sys.entity;

import fs.luke.kong.core.entity.DataEntity;

public class Office extends DataEntity<Office> {
    private String name;
    private String type;
    private String measter;
    private String parentId;
    private String parentIds;
    private String sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeaster() {
        return measter;
    }

    public void setMeaster(String measter) {
        this.measter = measter;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
