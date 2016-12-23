package com.mypkg.DataLayer;

/**
 * Created by Ujjwal on 12/22/2016.
 */
import com.mypkg.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeUserDaoImpl implements UserDao {

    private static Map<Integer, User> users;

    static {

        users = new HashMap<Integer, User>(){

            {
                put(1, new User(1, "Sayed Hassan", "Computer Administrator"));
                put(2, new User(2, "Alan Fox", "Finance"));
                put(3, new User(3, "Gregg Bolun", "Marketing"));
            }
        };
    }

    @Override
    public Collection<User> getAllUsers(){
        return this.users.values();
    }

    @Override
    public User getUserById(int id){
        return this.users.get(id);
    }

    @Override
    public void removeUserById(int id) {
        this.users.remove(id);
    }

    @Override
    public void updateUser(User user){
        User s = users.get(user.getId());
        s.setUserType(user.getUserType());
        s.setName(user.getName());
        users.put(user.getId(), user);
    }

    @Override
    public void insertUserToDb(User user) {
        this.users.put(user.getId(), user);
    }
}
