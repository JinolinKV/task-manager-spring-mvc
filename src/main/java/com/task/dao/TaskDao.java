package com.task.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.task.entity.Task;

@Repository
public class TaskDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 🔹 Get all tasks
    public List<Task> getAllTasks() {

        String sql = "SELECT * FROM task";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Task.class));
    }

    // 🔹 Save or Update Task
    public void saveTask(Task task) {

        if (task.getId() == 0) {

            // INSERT
            String sql = "INSERT INTO task(title, description, status) VALUES(?,?,?)";

            jdbcTemplate.update(sql,
                    task.getTitle(),
                    task.getDescription(),
                    task.getStatus());

        } else {

            // UPDATE
            String sql = "UPDATE task SET title=?, description=?, status=? WHERE id=?";

            jdbcTemplate.update(sql,
                    task.getTitle(),
                    task.getDescription(),
                    task.getStatus(),
                    task.getId());
        }
    }

    // 🔹 Delete Task
    public void deleteTask(int id) {

        String sql = "DELETE FROM task WHERE id=?";

        jdbcTemplate.update(sql, id);
    }

    // 🔹 Get Task By ID
    public Task getTaskById(int id) {

        String sql = "SELECT * FROM task WHERE id=?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Task.class),
                id);
    }

    // 🔹 Mark task as completed
    public void markComplete(int id) {

        String sql = "UPDATE task SET status='Completed' WHERE id=?";

        jdbcTemplate.update(sql, id);
    }

    // 🔹 Get only pending tasks
    public List<Task> getPendingTasks() {

        String sql = "SELECT * FROM task WHERE status='Pending'";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Task.class));
    }

    // 🔹 Get completed tasks
    public List<Task> getCompletedTasks() {

        String sql = "SELECT * FROM task WHERE status='Completed'";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Task.class));
    }
}