package com.javaplayground.jdbc.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * JDBC CRUD Example using Spring's JdbcTemplate
 * 
 * This class demonstrates basic CRUD operations:
 * - CREATE (INSERT)
 * - READ (SELECT)
 * - UPDATE
 * - DELETE
 * 
 * Package: com.javaplayground.jdbc.crud
 * 
 * Database Schema:
 * CREATE TABLE users (
 *     id BIGSERIAL PRIMARY KEY,
 *     first_name VARCHAR(100) NOT NULL,
 *     last_name VARCHAR(100) NOT NULL,
 *     email VARCHAR(255) UNIQUE NOT NULL,
 *     phone_number VARCHAR(20)
 * );
 */
@Service
public class UserCrudExample {

    private static final Logger logger = LoggerFactory.getLogger(UserCrudExample.class);

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    private static final String TABLE_NAME = "users";

    /**
     * RowMapper for mapping ResultSet rows to User objects
     */
    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setPhoneNumber(rs.getString("phone_number"));
            return user;
        }
    };

    /**
     * CREATE - Insert a new user into the database
     */
    public int createUser(User user) {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return 0;
        }

        String sql = "INSERT INTO " + TABLE_NAME + " (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)";
        try {
            return jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber());
        } catch (Exception e) {
            logger.error("Error creating user: " + e.getMessage());
            return 0;
        }
    }

    /**
     * READ - Get a user by ID
     */
    public Optional<User> getUserById(Long id) {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return Optional.empty();
        }

        String sql = "SELECT id, first_name, last_name, email, phone_number FROM " + TABLE_NAME + " WHERE id = ?";
        try {
            List<User> users = jdbcTemplate.query(sql, new Object[]{id}, userRowMapper);
            return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
        } catch (Exception e) {
            logger.error("Error retrieving user by ID: " + e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * READ - Get all users from the database
     */
    public List<User> getAllUsers() {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return List.of();
        }

        String sql = "SELECT id, first_name, last_name, email, phone_number FROM " + TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, userRowMapper);
        } catch (Exception e) {
            logger.error("Error retrieving all users: " + e.getMessage());
            return List.of();
        }
    }

    /**
     * READ - Get user by email
     */
    public Optional<User> getUserByEmail(String email) {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return Optional.empty();
        }

        String sql = "SELECT id, first_name, last_name, email, phone_number FROM " + TABLE_NAME + " WHERE email = ?";
        try {
            List<User> users = jdbcTemplate.query(sql, new Object[]{email}, userRowMapper);
            return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
        } catch (Exception e) {
            logger.error("Error retrieving user by email: " + e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * UPDATE - Update an existing user
     */
    public int updateUser(User user) {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return 0;
        }

        String sql = "UPDATE " + TABLE_NAME + " SET first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE id = ?";
        try {
            return jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getId());
        } catch (Exception e) {
            logger.error("Error updating user: " + e.getMessage());
            return 0;
        }
    }

    /**
     * DELETE - Delete a user by ID
     */
    public int deleteUserById(Long id) {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return 0;
        }

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try {
            return jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            logger.error("Error deleting user: " + e.getMessage());
            return 0;
        }
    }

    /**
     * DELETE - Delete all users
     */
    public int deleteAllUsers() {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return 0;
        }

        String sql = "DELETE FROM " + TABLE_NAME;
        try {
            return jdbcTemplate.update(sql);
        } catch (Exception e) {
            logger.error("Error deleting all users: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Get total count of users
     */
    public long getUserCount() {
        if (jdbcTemplate == null) {
            logger.warn("JdbcTemplate is not available. Database connection may not be configured.");
            return 0;
        }

        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME;
        try {
            Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
            return count != null ? count : 0;
        } catch (Exception e) {
            logger.error("Error getting user count: " + e.getMessage());
            return 0;
        }
    }
}
