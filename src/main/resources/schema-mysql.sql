CREATE TABLE IF NOT EXISTS users (
    id int NOT NULL AUTO_INCREMENT,
    userName VARCHAR(128),
    password VARCHAR(128),
    active BOOLEAN,
    roles VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tracks (
    id   INTEGER  AUTO_INCREMENT    NOT NULL,
    title VARCHAR(128),
    album_id INTEGER,
    genre VARCHAR(128),
    created_at DATETIME,
    created_by VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS refreshtoken (
    id   INTEGER AUTO_INCREMENT     NOT NULL,
    user_id INTEGER,
    token VARCHAR(128),
    expiry_date DATETIME,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS artists (
    id   INTEGER AUTO_INCREMENT NOT NULL,
    name VARCHAR(128),
    display_picture VARCHAR(255),
    created_at DATETIME,
    created_by VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS artist_albums (
    artist_id   INTEGER,
    album_id   INTEGER,
    PRIMARY KEY (artist_id)
);

CREATE TABLE IF NOT EXISTS artist_tracks (
    artist_id   INTEGER,
    track_id   INTEGER,
    PRIMARY KEY (artist_id)
);
CREATE TABLE IF NOT EXISTS albums (
    id   INT  AUTO_INCREMENT    NOT NULL,
    title VARCHAR(128),
    album_art VARCHAR(255),
    created_at DATETIME,
    created_by VARCHAR(128),
    PRIMARY KEY (id)
);