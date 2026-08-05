CREATE SCHEMA IF NOT EXISTS bank;

CREATE TABLE IF NOT EXISTS bank.role (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         authority VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS bank.member (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           email VARCHAR(255),
    password VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS bank.member_role (
                                                member_id BIGINT,
                                                role_id BIGINT
);

CREATE TABLE IF NOT EXISTS bank.account (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255)
    );