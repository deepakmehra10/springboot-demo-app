package com.deepak.repository;

import com.deepak.User;
import com.deepak.constants.QueryConstants;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {
    
    @Query(QueryConstants.GET_USER_BY_ID)
    User findById(int id);
    
    @Query(QueryConstants.GET_USERS)
    List<User> findAll();
    
    @Query(QueryConstants.DELETE_USER)
    Void delete(int id);
    
    //:TODO Currently not working with @Query annotation.
     //@Query("INSERT INTO user (id,address,name,salary) values (?user.id,?user.address,?user.name,?user.salary)")
    User insert(User user);
}
