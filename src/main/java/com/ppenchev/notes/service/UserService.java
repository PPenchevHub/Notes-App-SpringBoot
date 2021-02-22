package com.ppenchev.notes.service;

import com.ppenchev.notes.exceptions.RessourceNotFoundException;
import com.ppenchev.notes.model.User;
import com.ppenchev.notes.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public HttpStatus addUser(User user){
        if(user != null)  {
            userRepository.save(user);
        return HttpStatus.CREATED;
        }
        else return HttpStatus.NO_CONTENT;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->
                new RessourceNotFoundException("No user found with id: " +id));
    }
    public User updateUser (Long id, User user){
        User temp = this.getUserById(id);
        temp.setName(user.getName());
        temp.setPassword(user.getPassword());
        temp.setRole(user.getRole());
        return temp;
    }
    public HttpStatus deleteUser(Long id){
            userRepository.delete(this.getUserById(id));
        return HttpStatus.OK;
    }


}
