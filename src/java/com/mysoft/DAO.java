/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysoft;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author sveretilo
 */
public class DAO {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "666666a");
    }
    
    static List<Post> posts;
    static {
        posts = new ArrayList<Post>();
        posts.add(new Post(1, "hello"));
        posts.add(new Post(2, "hello2"));
        posts.add(new Post(2, "people"));
        posts.add(new Post(2, "people"));
    }
    
    public static List<Post> getPosts() throws SQLException, ClassNotFoundException {
        try(
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("select * from java.post");
            ResultSet resultSet = ps.executeQuery();
        ) {
        
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String txt = resultSet.getString(2);

                posts.add(new Post(id, txt));
            }
            return posts;
        }     
        
    }
    
    public static void deletePost(int id) {
        Post d = null;
        for (Post p: posts) {
            if (p.id == id) {
                d = p;
            }
        }
        if (d != null) {
            posts.remove(d);
        }
    }
    
    public static void addPost(String txt) {
        posts.add(new Post(posts.size(), txt));
    }
    
    
}
