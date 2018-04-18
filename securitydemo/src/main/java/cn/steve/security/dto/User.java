package cn.steve.security.dto;

import com.fasterxml.jackson.annotation.JsonView;
import cn.steve.security.validator.MyConstraint;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created By SteveWoo
 */
public class User {
    public interface UserSimpleView {
    }

    ;

    public interface UserDeatailView extends UserSimpleView {
    }

    ;

    private String username;
    @MyConstraint(message = "密码不能为空")
    private String password;
    private int id;
    @Past(message = "生日日期一定要为过去")
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDeatailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
