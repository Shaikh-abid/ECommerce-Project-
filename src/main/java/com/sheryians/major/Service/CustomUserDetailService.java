package com.sheryians.major.Service;

import com.sheryians.major.Repository.UserRepository;
import com.sheryians.major.model.CustomUserDetail;
import com.sheryians.major.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);

        optionalUser.orElseThrow(() ->
                new UsernameNotFoundException("User Not Found!!!"));

        return optionalUser.map(CustomUserDetail :: new ).get();
    }
}
