package com.example.siamtest.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponse findUserById(int id){
        Optional<TableUser> result = userRepository.findById(id);
        UserResponse userResponse = new UserResponse(result.get().getId(), result.get().getName(), result.get().getEmail());
        return userResponse;
    }
}
