package com.xingxue.plugin.redis.entity;

/**
 * Created by Administrator on 2017/9/21.
 */
public class User {

    private int id;
    private String username;
    private String group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public User() {
    }

    public User(int id, String username, String group) {
        this.id = id;
        this.username = username;
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
