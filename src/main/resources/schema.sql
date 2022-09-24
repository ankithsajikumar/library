CREATE TABLE users (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    userName VARCHAR(128),
    password VARCHAR(128),
    active BOOLEAN,
    roles VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE tracks (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    title VARCHAR(128),
    album VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE refreshtoken (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    user_id INTEGER,
    token VARCHAR(128),
    expiry_date DATETIME,
    PRIMARY KEY (id)
);
CREATE TABLE artists (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE artist_albums (
    artist_id   INTEGER,
    album_id   INTEGER,
    PRIMARY KEY (artist_id)
);

CREATE TABLE artist_tracks (
    artist_id   INTEGER,
    track_id   INTEGER,
    PRIMARY KEY (artist_id)
);
CREATE TABLE albums (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    title VARCHAR(128),
    PRIMARY KEY (id)
);