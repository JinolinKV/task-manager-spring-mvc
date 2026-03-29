package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.TaskDao;
import com.task.entity.Task;

@Service
public class TaskService {

    @Autowired
    private TaskDao dao;

    // Get all tasks
    public List<Task> getTasks() {
        return dao.getAllTasks();
    }

    // Save or update task
    public void saveTask(Task task) {
        dao.saveTask(task);
    }

    // Delete task
    public void deleteTask(int id) {
        dao.deleteTask(id);
    }

    // Get task by id (for edit)
    public Task getTaskById(int id) {
        return dao.getTaskById(id);
    }

    // Mark task completed
    public void markComplete(int id) {
        dao.markComplete(id);
    }

    // Get pending tasks
    public List<Task> getPendingTasks() {
        return dao.getPendingTasks();
    }

    // Get completed tasks
    public List<Task> getCompletedTasks() {
        return dao.getCompletedTasks();
    }
}