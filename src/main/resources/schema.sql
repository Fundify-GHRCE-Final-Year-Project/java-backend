CREATE TYPE Category AS ENUM (
    'Coding',
    'Medical',
    'Technology',
    'Pharmacy',
    'Army',
    'Defence',
    'Farming',
    'Finance',
    'Education',
    'Environment',
    'Sports',
    'ArtsAndCulture',
    'Travel',
    'SocialWork',
    'Music',
    'Business',
    'Science'
    );

CREATE TABLE IF NOT EXISTS "user"
(
    id       VARCHAR(255) PRIMARY KEY,
    wallet   VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL,
    country  VARCHAR(255) NOT NULL,
    job      VARCHAR(255) NOT NULL,
    phone    VARCHAR(255),
    address  VARCHAR(255) NOT NULL,
    linkedin VARCHAR(255) NOT NULL,
    x        VARCHAR(255),
    github   VARCHAR(255),
    version  INT
);

CREATE TABLE IF NOT EXISTS Skills
(
    id    VARCHAR(255) NOT NULL,
    skill VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES "user" (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Experiences
(
    id       VARCHAR(255) NOT NULL,
    job      VARCHAR(255) NOT NULL,
    company  VARCHAR(255) NOT NULL,
    duration VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES "user" (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Interests
(
    id       VARCHAR(255) NOT NULL,
    interest Category     NOT NULL,
    FOREIGN KEY (id) REFERENCES "user" (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Projects
(
    id            VARCHAR(255)                                              NOT NULL PRIMARY KEY,
    title         VARCHAR(255)                                              NOT NULL,
    description   VARCHAR(255)                                              NOT NULL,
    category      Category                                                  NOT NULL,
    owner         VARCHAR(255)                                              NOT NULL,
    project_index INT                                                       NOT NULL CHECK (project_index >= 0) NOT NULL,
    goal          DECIMAL(14, 2) CHECK (goal > 0)                           NOT NULL,
    milestones    DECIMAL(14, 2) CHECK (milestones > 1 AND milestones <= 5) NOT NULL,
    funded        DECIMAL(14, 2) CHECK (funded >= 0)                        NOT NULL,
    released      DECIMAL(14, 2) CHECK (released >= 0)                      NOT NULL,
    eth_timestamp INT                                                       NOT NULL CHECK (eth_timestamp > 0) NOT NULL,
    FOREIGN KEY (owner) REFERENCES "user" (wallet) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Members
(
    id          VARCHAR(255) NOT NULL,
    member_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES Projects (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Investments
(
    id               VARCHAR(255) PRIMARY KEY,
    funder           VARCHAR(255)   NOT NULL,
    investment_index INT            NOT NULL CHECK (investment_index >= 0),
    project_id       VARCHAR(255)   NOT NULL,
    project_owner    VARCHAR(255)   NOT NULL,
    project_index    INT            NOT NULL CHECK (project_index >= 0),
    amount           DECIMAL(14, 2) NOT NULL CHECK (amount > 0),
    eth_timestamp    INT            NOT NULL CHECK (eth_timestamp > 0),
    FOREIGN KEY (project_id) REFERENCES Projects (id) ON DELETE CASCADE,
    FOREIGN KEY (funder) REFERENCES "user" (wallet) ON DELETE CASCADE,
    FOREIGN KEY (project_owner) REFERENCES "user" (wallet) ON DELETE CASCADE
);