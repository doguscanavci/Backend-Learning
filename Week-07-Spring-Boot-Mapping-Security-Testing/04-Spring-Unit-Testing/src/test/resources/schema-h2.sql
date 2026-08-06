CREATE TABLE IF NOT EXISTS actor (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     first_name VARCHAR(255),
    last_name VARCHAR(255),
    gender VARCHAR(50),
    birth_date DATE
    );

CREATE TABLE IF NOT EXISTS movie (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255),
    director_name VARCHAR(255),
    rating INTEGER,
    release_date DATE
    );

CREATE TABLE IF NOT EXISTS movie_actor (
                                           movie_id BIGINT,
                                           actor_id BIGINT
);