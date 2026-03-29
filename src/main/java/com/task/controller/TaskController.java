package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.entity.Task;
import com.task.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService service;

    // Show all tasks
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("tasks", service.getTasks());

        return "home";
    }

    // Open Add Task page
    @GetMapping("/add")
    public String addPage(Model model) {

        model.addAttribute("task", new Task());

        return "addTask";
    }

    // Save or Update task
    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {

        service.saveTask(task);

        return "redirect:/";
    }

    // Delete task
    @GetMapping("/delete")
    public String deleteTask(@RequestParam("id") int id) {

        service.deleteTask(id);

        return "redirect:/";
    }

    // Edit task
    @GetMapping("/edit")
    public String editTask(@RequestParam("id") int id, Model model) {

        Task task = service.getTaskById(id);

        model.addAttribute("task", task);

        return "addTask";
    }

    // Mark task completed
    @GetMapping("/complete")
    public String markComplete(@RequestParam int id) {

        service.markComplete(id);

        return "redirect:/";
    }

    // Show pending tasks
    @GetMapping("/pending")
    public String pendingTasks(Model model) {

        model.addAttribute("tasks", service.getPendingTasks());

        return "home";
    }

    // ✅ Show completed tasks
    @GetMapping("/completed")
    public String completedTasks(Model model) {

        model.addAttribute("tasks", service.getCompletedTasks());

        return "home";
    }
}