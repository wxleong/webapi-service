-- This schema is based on the sample data taken from db.json

CREATE TABLE IF NOT EXISTS genre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS movie (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_year VARCHAR(4),
    runtime INT,
    director VARCHAR(255),
    actors TEXT,
    plot TEXT,
    poster_url TEXT
);

CREATE TABLE IF NOT EXISTS movie_genres (
    movie_id INT,
    genre_id INT,
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (genre_id) REFERENCES genre(id)
);
