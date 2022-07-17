package com.library.entespotify.track;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TrackRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Track("track 1", "artist 1", "album 1")));
            log.info("Preloading " + repository.save(new Track("track 2", "artist 2", "album 2")));
        };
    }
}