CREATE TABLE profiles (
                          id SERIAL PRIMARY KEY,
                          login VARCHAR(50) UNIQUE NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          subscribers INT NOT NULL DEFAULT 0
);

CREATE TABLE posts (
                       id SERIAL PRIMARY KEY,
                       author_id INT NOT NULL REFERENCES profiles(id) ON DELETE CASCADE,
                       text TEXT NOT NULL,
                       likes INT NOT NULL DEFAULT 0
);
