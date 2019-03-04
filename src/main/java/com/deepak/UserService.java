package com.deepak;

import com.deepak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public User createUser(User user) {
        return userRepository.insert(user);
    }
    
    public User getUserById(int id) {
        return userRepository.findById(id);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Void deleteUser(int id) {
        return userRepository.delete(id);
    }
}
