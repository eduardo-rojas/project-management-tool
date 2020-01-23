package me.carlosehr.ppmtool.services;

import me.carlosehr.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

}
