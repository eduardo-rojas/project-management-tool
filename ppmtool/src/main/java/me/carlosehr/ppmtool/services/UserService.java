package me.carlosehr.ppmtool.services;

import me.carlosehr.ppmtool.domain.User;
import me.carlosehr.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        //Username has to be unique(Exception)

        //Make sure that password and confirmPassword match
        //We don't persist or show the confirmPassword
        return userRepository.save(newUser);
    }

}
