package fs.luke.kong.modules.sys.entity;

import fs.luke.kong.core.entity.DataEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

public class User extends DataEntity<User> {
    /**
     * 所在机构
     */
    private Office office;
    /**
     * 所在用户组
     */
    private UserGroup userGroup;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 登陆名称
     */
    private String loginName;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱号
     */
    private String eMail;

    public Office getOfficeId() {
        return office;
    }

    public void setOfficeId(Office officeId) {
        this.office = office;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }
}