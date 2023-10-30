package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll(){
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        for (int i = 0; i < mapList.size(); i++){
            Map<String, Object> map = mapList.get(i);
            System.out.println(map);
            User user = new User();
                user.setId(((int)map.get("id")));
                user.setPassword(((String)map.get("password")));
                user.setName(((String)map.get("name")));
                user.setRole(((String)map.get("role")));
                user.setDivision_id(((int)map.get("division_id")));
            list.add(user);
        }
        return list;
    }

    public void update(User user){
        int id = user.getId();
        String password = user.getPassword();
        String name = user.getName();
        String role = user.getRole();
        int division_id = user.getDivision_id();

        String sql = "UPDATE users SET (id, password, name, role, division_id) = (" + id + ", " + password + ", " + name + ", " + role + ", " + division_id + ") WHERE = id == " + id;
        //sql文 確認用のLog
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    public void insert(User user){
        int id = user.getId();
        String password = user.getPassword();
        String name = user.getName();
        String role = user.getRole();
        int division_id = user.getDivision_id();

        String sql = "INSERT INTO users (id, password, name, role, division_id) VALUES ((SELECT count(*) + 1 FROM users), '" + password + "', '" + name + "', '" + role + "', " + division_id + ")";
        //sql文 確認用のLog
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    public void delete(User user){
        int id = user.getId();
        String password = user.getPassword();
        String name = user.getName();
        String role = user.getRole();
        int division_id = user.getDivision_id();

        String sql = "DELETE FROM users WHERE id = " + id;
        //sql文 確認用のLog
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    public User findById(int id){
        String sql = "SELECT id = " + id + "FROM users";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        Map<String, Object> map = result.get(0);
        User user = new User();
        user.setId(((int)map.get("id")));
        user.setPassword(((String)map.get("password")));
        user.setName(((String)map.get("name")));
        user.setRole(((String)map.get("role")));
        user.setDivision_id(((int)map.get("division_id")));

        return user;
    }


}
