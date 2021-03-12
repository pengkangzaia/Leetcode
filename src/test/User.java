package test;

import java.io.Serializable;

/**
 * @FileName: User.java
 * @Description: User.java类说明
 * @Author: camille
 * @Date: 2020/12/28 20:32
 */
public class User implements Serializable {

    private static final long serialVersionUID = 3186269806360071055L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
