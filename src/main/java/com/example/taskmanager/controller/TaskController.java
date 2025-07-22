package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/test")
public class TaskController {
    private final Map<String, Task> tasks = new HashMap<>();

    @GetMapping
    public Collection<Task> getAllTasks() {
        return tasks.values();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        String id = UUID.randomUUID().toString();
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return "Task deleted successfully.";
        } else {
            return "Task not found.";
        }
    }
}
