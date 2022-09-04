package com.library.entespotify.configs;

import com.library.entespotify.models.Album;
import com.library.entespotify.models.Artist;
import com.library.entespotify.models.Track;
import com.library.entespotify.models.User;
import com.library.entespotify.repositories.AlbumRepository;
import com.library.entespotify.repositories.ArtistRepository;
import com.library.entespotify.repositories.TrackRepository;
import com.library.entespotify.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(TrackRepository trackRepository) {

        return args -> {
            log.info("Preloading " + trackRepository.save(new Track("track 1", null, "album 1")));
            log.info("Preloading " + trackRepository.save(new Track("track 2", null, "album 2")));
        };
    }

    @Bean
    CommandLineRunner initUserDatabase(UserRepository userRepository) {

        return args -> {
            log.info("Preloading " + userRepository.save(new User("admin", passwordEncoder.encode("admin"), true, "ADMIN")));
            log.info("Preloading " + userRepository.save(new User("ecom", passwordEncoder.encode("ec0m"), true, "USER")));
        };
    }

    @Bean
    CommandLineRunner initAlbumDatabase(AlbumRepository albumRepository) {

        return args -> {
            log.info("Preloading " + albumRepository.save(new Album("album 1", null)));
            log.info("Preloading " + albumRepository.save(new Album("album 2", null)));
        };
    }

    @Bean
    CommandLineRunner initArtistDatabase(ArtistRepository artistRepository) {

        return args -> {
            log.info("Preloading " + artistRepository.save(new Artist("artist 1", null, null)));
            log.info("Preloading " + artistRepository.save(new Artist("artist 2", null, null)));
        };
    }
}