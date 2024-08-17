CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

INSERT INTO users (id, login, password, role) VALUES ('u001', 'alice', 'password123', 'admin');
INSERT INTO users (id, login, password, role) VALUES ('u002', 'bob', 'password456', 'user');
INSERT INTO users (id, login, password, role) VALUES ('u003', 'carol', 'password789', 'moderator');
