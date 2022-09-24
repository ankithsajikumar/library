DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tracks;
DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS albums;
DROP TABLE IF EXISTS refreshtoken;
DROP TABLE IF EXISTS track;

CREATE TABLE IF NOT EXISTS users (
    id   SERIAL PRIMARY KEY,
    userName VARCHAR(128),
    password VARCHAR(128),
    active BOOLEAN,
    roles VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS tracks (
    id   SERIAL PRIMARY KEY,
    title VARCHAR(128),
    album VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS refreshtoken (
    id   SERIAL PRIMARY KEY,
    user_id INTEGER,
    token VARCHAR(128),
    expiry_date TIMESTAMP
);
CREATE TABLE IF NOT EXISTS artists (
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128)
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
    id   SERIAL PRIMARY KEY,
    title VARCHAR(128)
);