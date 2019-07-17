package fs.luke.kong.modules.sys.entity;

import fs.luke.kong.core.entity.DataEntity;

public class UserGroup extends DataEntity<UserGroup> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
