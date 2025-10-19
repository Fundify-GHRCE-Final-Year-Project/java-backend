package com.fundify.fundify.user.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
//    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
//    private final JdbcClient jdbcClient;
//    private final ObjectMapper objectMapper;
//
//    public UserRepository(JdbcClient jdbcClient, ObjectMapper objectMapper) {
//        this.jdbcClient = jdbcClient;
//        this.objectMapper = objectMapper;
//    }
//
//    public List<User> get() {
//        return jdbcClient.sql("SELECT JSON_OBJECT(\n" +
//                        "  'id' VALUE u.id,\n" +
//                        "  'wallet' VALUE u.wallet,\n" +
//                        "  'username' VALUE u.username,\n" +
//                        "  'country' VALUE u.country,\n" +
//                        "  'job' VALUE u.job,\n" +
//                        "  'phone' VALUE u.phone,\n" +
//                        "  'address' VALUE u.address,\n" +
//                        "  'linkedin' VALUE u.linkedin,\n" +
//                        "  'x' VALUE u.x,\n" +
//                        "  'github' VALUE u.github,\n" +
//                        "  'skills' VALUE COALESCE(s.skills, JSON_ARRAY()),\n" +
//                        "  'interests' VALUE COALESCE(i.interests, JSON_ARRAY()),\n" +
//                        "  'experiences' VALUE COALESCE(e.experiences, JSON_ARRAY())\n" +
//                        ") AS users_json\n" +
//                        "FROM USERS u\n" +
//                        "LEFT JOIN (\n" +
//                        "    SELECT s.id, JSON_ARRAYAGG(DISTINCT s.skill) AS skills\n" +
//                        "    FROM SKILLS s\n" +
//                        "    GROUP BY s.id\n" +
//                        ") s ON u.id = s.id\n" +
//                        "LEFT JOIN (\n" +
//                        "    SELECT i.id, JSON_ARRAYAGG(DISTINCT i.interest) AS interests\n" +
//                        "    FROM INTERESTS i\n" +
//                        "    GROUP BY i.id\n" +
//                        ") i ON u.id = i.id\n" +
//                        "LEFT JOIN (\n" +
//                        "    SELECT e.id, JSON_ARRAYAGG(\n" +
//                        "        JSON_OBJECT(\n" +
//                        "            'job' VALUE e.job,\n" +
//                        "            'company' VALUE e.company,\n" +
//                        "            'duration' VALUE e.duration\n" +
//                        "        )\n" +
//                        "    ) AS experiences\n" +
//                        "    FROM EXPERIENCES e\n" +
//                        "    GROUP BY e.id\n" +
//                        ") e ON u.id = e.id\n" +
//                        "GROUP BY u.id;\n")
//                .query((rs, rowNum) -> {
//                    String json = rs.getString("users_json");
//                    try {
//                        return objectMapper.readValue(json, User.class);
//                    } catch (Exception e) {
//                        throw new RuntimeException("Error parsing JSON: " + json, e);
//                    }
//                })
//                .list();
//    }
//
//    public Optional<User> get(String wallet) {
//        return jdbcClient.sql("SELECT JSON_OBJECT(\n" +
//                        "  'id' VALUE u.id,\n" +
//                        "  'wallet' VALUE u.wallet,\n" +
//                        "  'username' VALUE u.username,\n" +
//                        "  'country' VALUE u.country,\n" +
//                        "  'job' VALUE u.job,\n" +
//                        "  'phone' VALUE u.phone,\n" +
//                        "  'address' VALUE u.address,\n" +
//                        "  'linkedin' VALUE u.linkedin,\n" +
//                        "  'x' VALUE u.x,\n" +
//                        "  'github' VALUE u.github,\n" +
//                        "  'skills' VALUE COALESCE(s.skills, JSON_ARRAY()),\n" +
//                        "  'interests' VALUE COALESCE(i.interests, JSON_ARRAY()),\n" +
//                        "  'experiences' VALUE COALESCE(e.experiences, JSON_ARRAY())\n" +
//                        ") AS users_json\n" +
//                        "FROM USERS u\n" +
//                        "LEFT JOIN (\n" +
//                        "    SELECT s.id, JSON_ARRAYAGG(DISTINCT s.skill) AS skills\n" +
//                        "    FROM SKILLS s\n" +
//                        "    GROUP BY s.id\n" +
//                        ") s ON u.id = s.id\n" +
//                        "LEFT JOIN (\n" +
//                        "    SELECT i.id, JSON_ARRAYAGG(DISTINCT i.interest) AS interests\n" +
//                        "    FROM INTERESTS i\n" +
//                        "    GROUP BY i.id\n" +
//                        ") i ON u.id = i.id\n" +
//                        "LEFT JOIN (\n" +
//                        "    SELECT e.id, JSON_ARRAYAGG(\n" +
//                        "        JSON_OBJECT(\n" +
//                        "            'job' VALUE e.job,\n" +
//                        "            'company' VALUE e.company,\n" +
//                        "            'duration' VALUE e.duration\n" +
//                        "        )\n" +
//                        "    ) AS experiences\n" +
//                        "    FROM EXPERIENCES e\n" +
//                        "    GROUP BY e.id\n" +
//                        ") e ON u.id = e.id\n" +
//                        "WHERE u.wallet = :wallet;")
//                .param("wallet", wallet)
//                .query((rs, rowNum) -> {
//                    String json = rs.getString("users_json");
//                    try {
//                        return objectMapper.readValue(json, User.class);
//                    } catch (Exception e) {
//                        throw new RuntimeException("Error parsing JSON: " + json, e);
//                    }
//                })
//                .optional();
//    }
//
//    public void create(User user) {
//        jdbcClient.sql("INSERT INTO USERS (id, wallet, username, country, job, phone, address, linkedin, x, github)" +
//                        "VALUES (?,?,?,?,?,?,?,?,?,?)")
//                .params(List.of(user.id(), user.wallet(), user.username(),
//                        user.country(), user.job(), user.phone(),
//                        user.address(), user.linkedin(), user.x(), user.github())).update();
//        for (int i = 0; i < user.skills().size(); i++) {
//            jdbcClient.sql("INSERT INTO SKILLS (id, skill) VALUES (?, ?)")
//                    .params(List.of(user.id(), user.skills().get(i))).update();
//        }
//        for (int i = 0; i < user.experiences().size(); i++) {
//            jdbcClient.sql("INSERT INTO EXPERIENCES (id, job, company, duration) VALUES (?, ?, ?, ?)")
//                    .params(List.of(user.id(), user.experiences().get(i).job(), user.experiences().get(i).company(), user.experiences().get(i).duration())).update();
//        }
//        for (int i = 0; i < user.interests().size(); i++) {
//            jdbcClient.sql("INSERT INTO INTERESTS (id, interest) VALUES (?, ?)")
//                    .params(List.of(user.id(), user.interests().get(i).toString())).update();
//        }
//    }
//
//    public void update(User user, String wallet) {
//        jdbcClient.sql("UPDATE USERS SET id = ?, wallet = ?, username = ?, country = ?, " +
//                        "job = ?, phone = ?, address = ?, linkedin = ?, x = ?, github = ? WHERE wallet = ?")
//                .params(List.of(user.id(), user.wallet(), user.username(),
//                        user.country(), user.job(), user.phone(),
//                        user.address(), user.linkedin(), user.x(), user.github(), wallet)).update();
//        for (int i = 0; i < user.skills().size(); i++) {
//            jdbcClient.sql("UPDATE SKILLS SET id = ?, skill = ? WHERE id = ?")
//                    .params(List.of(user.id(), user.skills().get(i), user.id())).update();
//        }
//        for (int i = 0; i < user.experiences().size(); i++) {
//            jdbcClient.sql("UPDATE EXPERIENCES SET id = ?, job = ?, company = ?, duration = ? WHERE id = ?")
//                    .params(List.of(user.id(), user.experiences().get(i).job(),
//                            user.experiences().get(i).company(), user.experiences().get(i).duration(),
//                            user.id())).update();
//        }
//        for (int i = 0; i < user.interests().size(); i++) {
//            jdbcClient.sql("UPDATE INTERESTS SET id = ?, interest = ? WHERE id = ?")
//                    .params(List.of(user.id(), user.interests().get(i).toString(), user.id())).update();
//        }
//    }
//
//    public void delete(String wallet) {
//        jdbcClient.sql("DELETE FROM USERS WHERE wallet = ?")
//                .param(wallet).update();
//    }
}
