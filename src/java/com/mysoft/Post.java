/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysoft;

/**
 *
 * @author sveretilo
 */
public class Post {
    int id;
    String txt;
    
    public Post(int i, String hello) {
        id = i;
        txt = hello;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTxt() {
        return txt;
    }
    
    public void setString(String txt) {
        this.txt = txt;
    }
}
