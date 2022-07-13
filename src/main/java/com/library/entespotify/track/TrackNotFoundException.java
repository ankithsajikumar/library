package com.library.entespotify.track;

public class TrackNotFoundException extends RuntimeException {

        public TrackNotFoundException(Long id) {
            super("Could not find track " + id);
        }
}
