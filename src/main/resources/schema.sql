DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    id   SERIAL PRIMARY KEY,
    userName VARCHAR(128),
    password VARCHAR(128),
    active BOOLEAN,
    roles VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS tracks (
    id   INTEGER      NOT NULL,
    title VARCHAR(128),
    album VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS refreshtoken (
    id   INTEGER      NOT NULL,
    user_id INTEGER,
    token VARCHAR(128),
    expiry_date TIMESTAMP,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS artists (
    id   INTEGER      NOT NULL,
    name VARCHAR(128),
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
    id   INTEGER      NOT NULL,
    title VARCHAR(128),
    PRIMARY KEY (id)
);