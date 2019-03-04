package com.deepak.constants;

public class QueryConstants {
    
    public static final String GET_USER_BY_ID = "SELECT * FROM user where id = ?0";
    
    public static final String GET_USERS = "SELECT * FROM user";
    
    public static final String DELETE_USER = "DELETE FROM user where id = ?0";
    
    //:TODO Currently not working
    //public static final String CREATE_USER = "INSERT INTO user.user (id,name,address,salary) values (?,?,?,?)";
}
