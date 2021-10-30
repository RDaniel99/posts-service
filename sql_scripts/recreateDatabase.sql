-- Delete current database
-- MAKE SURE YOU DON'T DELETE SOMETHING YOU NEED
DROP DATABASE lostandfound;

-- Create database
CREATE DATABASE lostandfound;

-- Select database
USE lostandfound;

-- Create posts table
CREATE TABLE posts(
	id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT(6) NOT NULL,
    status ENUM("PENDING_LOST", "ACTIVE_LOST", "PENDING_FOUND", "ACTIVE_FOUND", "SOLVED", "CLOSED"),
    has_form BOOLEAN NOT NULL DEFAULT 0
);

-- Create postsdetails table

CREATE TABLE postsdetails(
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    post_id INT(6) UNSIGNED NOT NULL,
    title VARCHAR(50) NOT NULL,
    category ENUM("WALLET"),
    description VARCHAR(10000),
    created_at timestamp default current_timestamp,
    FOREIGN KEY(post_id) REFERENCES posts(id)
);