package com.xingxue.plugin.redis.cache;

import com.xingxue.plugin.redis.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public class TestCache extends CacheOperator {

    public void putUser(User user){
        super.putEntity("User."+user.getId(),user);
    }

    public void putUsers(List<User> users){
        super.putEntities("GroupUser."+users.get(0).getGroup(),users);
    }

    public User getUser(User user){
        User entity = super.getEntity("User." + user.getId(), User.class);
        System.out.println(entity);
        return entity;
    }

    public List<User> getUsers(User user){
        List<User> entities = super.getEntities("GroupUser." + user.getGroup(), User.class);
        return entities;
    }

    public void delUser(User user){
        super.delete("User."+user.getId());
    }

    public List<User> getUsersByPrefix(String prefix){
        List<User> entitiesByKeyPrefix = super.getEntitiesByKeyPrefix(prefix + "*", User.class);
        return entitiesByKeyPrefix;
    }

    public static void main(String[] args) {
        User user = new User(1,"1","1");
        User user1 = new User(2,"2","2");
        User user2 = new User(3,"3","3");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        TestCache tc = new TestCache();
        tc.putUser(user);
        tc.putUser(user1);
        tc.putUser(user2);
        User user3 = tc.getUser(user);
        System.out.println(user3);

        tc.putUsers(users);
        List<User> users1 = tc.getUsers(user);
        for(User u:users1){
            System.out.print(u);
        }

        tc.delUser(user);
        User user4 = tc.getUser(user);
        System.out.println(user4);

        List<User> usersByPrefix = tc.getUsersByPrefix("User.");
        for(User u:usersByPrefix){
            System.out.print(u);
        }

    }
}
