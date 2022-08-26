package com.library.entespotify.configs;

import com.library.entespotify.models.User;
import com.library.entespotify.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
class LoadUserDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadUserDatabase.class);

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initUserDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("admin", passwordEncoder.encode("admin"), true, "ADMIN")));
            log.info("Preloading " + repository.save(new User("ecom",  passwordEncoder.encode("ec0m"), true, "USER")));
        };
    }
}