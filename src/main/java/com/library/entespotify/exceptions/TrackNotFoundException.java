package com.library.entespotify.exceptions;

public class TrackNotFoundException extends RuntimeException {

        public TrackNotFoundException(Long id) {
            super("Could not find exceptions " + id);
        }
}
