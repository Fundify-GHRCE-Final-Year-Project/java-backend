-- ---------------------------
-- Users (9 rows)
-- ---------------------------
INSERT INTO USERS (id, wallet, username, country, job, phone, address, linkedin, x, github)
VALUES ('u1', '0xAAA1', 'alice', 'India', 'Developer', '+91-9000010001', 'Mumbai, India',
        'https://linkedin.com/in/alice', '@alice', 'alice-gh'),
       ('u2', '0xAAA2', 'bob', 'USA', 'Researcher', '+1-202-555-0102', 'Washington, USA', 'https://linkedin.com/in/bob',
        '@bob', 'bob-gh'),
       ('u3', '0xAAA3', 'carol', 'UK', 'Designer', '+44-7700-900003', 'London, UK', 'https://linkedin.com/in/carol',
        '@carol', 'carol-gh');

-- ---------------------------
-- Skill (9 rows) — each row links to a user id
-- ---------------------------
INSERT INTO SKILLS (id, skill)
VALUES ('u1', 'Java'),
       ('u1', 'Python'),
       ('u1', 'UI/UX Design'),
       ('u2', 'Clinical Practice'),
       ('u2', 'AgriTech'),
       ('u2', 'Tactics'),
       ('u3', 'Teaching'),
       ('u3', 'Data Science'),
       ('u3', 'Guitar');

-- ---------------------------
-- Experience (9 rows)
-- ---------------------------
INSERT INTO EXPERIENCES (id, job, company, duration)
VALUES ('u1', 'Senior Developer', 'TechLabs', '3 years'),
       ('u1', 'Research Associate', 'UniLab', '2 years'),
       ('u1', 'Lead Designer', 'CreateStudio', '4 years'),
       ('u2', 'Resident Doctor', 'City Hospital', '5 years'),
       ('u2', 'Farm Manager', 'GreenFarms', '6 years'),
       ('u2', 'Platoon Commander', 'National Defence', '7 years'),
       ('u3', 'Primary Teacher', 'BrightSchool', '4 years'),
       ('u3', 'Research Scientist', 'BioWorks', '3 years'),
       ('u3', 'Session Musician', 'Freelance', '8 years');

-- ---------------------------
-- Interests (9 rows) — using Category enum values
-- ---------------------------
INSERT INTO INTERESTS (id, interest)
VALUES ('u1', 'Coding'),
       ('u1', 'Science'),
       ('u1', 'ArtsAndCulture'),
       ('u2', 'Medical'),
       ('u2', 'Farming'),
       ('u2', 'Defence'),
       ('u3', 'Education'),
       ('u3', 'Technology'),
       ('u3', 'Music');

-- ---------------------------
-- Project (9 rows)
-- Note: owner references User(wallet) as per your schema
-- milestones must be > 1 AND <= 5 — using 2.00 - 5.00 to satisfy CHECK
-- ---------------------------
INSERT INTO PROJECTS (id, title, description, category, owner, project_index, goal, milestones, funded, released,
                      eth_timestamp)
VALUES ('p1', 'Alpha Build', 'Open-source alpha project', 'Coding', '0xAAA1', 0, 5000.00, 2.00, 0.00, 0.00, 1700000001),
       ('p2', 'HealthNow', 'Medical care platform', 'Medical', '0xAAA1', 1, 15000.00, 3.00, 1000.00, 0.00, 1700000102),
       ('p3', 'DesignHub', 'Design tools for creators', 'ArtsAndCulture', '0xAAA1', 2, 8000.00, 2.00, 500.00, 0.00,
        1700000203),
       ('p4', 'CareClinic', 'Community clinic rollout', 'Pharmacy', '0xAAA2', 0, 20000.00, 4.00, 2000.00, 0.00,
        1700000304),
       ('p5', 'AgriBoost', 'Small farm automation', 'Farming', '0xAAA2', 1, 12000.00, 3.00, 750.00, 0.00, 1700000405),
       ('p6', 'DefendTech', 'Defense logistics tool', 'Defence', '0xAAA2', 2, 30000.00, 5.00, 5000.00, 0.00,
        1700000506),
       ('p7', 'TeachStream', 'Remote teaching platform', 'Education', '0xAAA3', 0, 7000.00, 2.00, 250.00, 0.00,
        1700000607),
       ('p8', 'BioLab', 'Research collaboration hub', 'Science', '0xAAA3', 1, 25000.00, 3.00, 1200.00, 0.00,
        1700000708),
       ('p9', 'MusicWave', 'Independent artists support', 'Music', '0xAAA3', 2, 4000.00, 2.00, 100.00, 0.00,
        1700000809);

-- ---------------------------
-- Member (9 rows) — each entry references a project id
-- ---------------------------
INSERT INTO MEMBERS (id, member_name)
VALUES ('p1', 'bob'),
       ('p1', 'carol'),
       ('p1', 'alice'),
       ('p2', 'eve'),
       ('p2', 'frank'),
       ('p2', 'grace'),
       ('p3', 'heidi'),
       ('p3', 'ivan'),
       ('p3', 'dave');

-- ---------------------------
-- Investment (9 rows)
-- funder and project_owner reference User(wallet)
-- ---------------------------
INSERT INTO INVESTMENTS (id, funder, investment_index, project_id, project_owner, project_index, amount, eth_timestamp)
VALUES ('inv1', '0xAAA2', 0, 'p1', '0xAAA1', 0, 150.00, 1700001001),
       ('inv2', '0xAAA3', 0, 'p2', '0xAAA1', 1, 500.00, 1700001102),
       ('inv3', '0xAAA2', 1, 'p3', '0xAAA1', 2, 200.00, 1700001203),
       ('inv4', '0xAAA3', 1, 'p4', '0xAAA2', 0, 1000.00, 1700001304),
       ('inv5', '0xAAA1', 0, 'p5', '0xAAA2', 1, 300.00, 1700001405),
       ('inv6', '0xAAA1', 1, 'p6', '0xAAA2', 2, 1200.00, 1700001506),
       ('inv7', '0xAAA1', 2, 'p7', '0xAAA3', 0, 75.00, 1700001607),
       ('inv8', '0xAAA2', 2, 'p8', '0xAAA3', 1, 600.00, 1700001708),
       ('inv9', '0xAAA2', 3, 'p9', '0xAAA3', 2, 50.00, 1700001809);
