package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.domain.UserDetailsImpl;
import com.misicode.eggnews.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("El usuario con correo " + email + " no existe"));

        return UserDetailsImpl.build(user);
    }
}
