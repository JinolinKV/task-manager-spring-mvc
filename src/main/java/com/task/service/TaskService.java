package com.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.task.entity.Task;

@Service
public class TaskService {

    // In-memory list
    private List<Task> list = new ArrayList<>();

    private int idCounter = 1;

    // Get all tasks
    public List<Task> getTasks() {
        return list;
    }

    // Save or Update
    public void saveTask(Task task) {

        // ADD
        if (task.getId() == 0) {
            task.setId(idCounter++);
            task.setStatus("Pending");
            list.add(task);
        } 
        
        // UPDATE
        else {
            for (Task t : list) {
                if (t.getId() == task.getId()) {
                    t.setTitle(task.getTitle());
                    t.setDescription(task.getDescription());
                }
            }
        }
    }

    // Delete
    public void deleteTask(int id) {
        list.removeIf(t -> t.getId() == id);
    }

    // Get by ID
    public Task getTaskById(int id) {
        return list.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Mark complete
    public void markComplete(int id) {
        for (Task t : list) {
            if (t.getId() == id) {
                t.setStatus("Completed");
            }
        }
    }

    // Pending tasks
    public List<Task> getPendingTasks() {
        List<Task> result = new ArrayList<>();

        for (Task t : list) {
            if ("Pending".equals(t.getStatus())) {
                result.add(t);
            }
        }

        return result;
    }

    // Completed tasks
    public List<Task> getCompletedTasks() {
        List<Task> result = new ArrayList<>();

        for (Task t : list) {
            if ("Completed".equals(t.getStatus())) {
                result.add(t);
            }
        }

        return result;
    }
}