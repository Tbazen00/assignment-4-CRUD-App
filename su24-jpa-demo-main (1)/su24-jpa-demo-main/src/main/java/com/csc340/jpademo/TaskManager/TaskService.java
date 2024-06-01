package com.csc340.jpademo.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    // Retrieve all tasks
    public Object getAllTasks() {
        return taskRepository.findAll();
    }
    // Retrieve by taskId
    public Task getTaskByTaskId(int taskId) {
        // Find id, null if not
        return taskRepository.findById(taskId).orElse(null);
    }
    // Retrieve by goalId
    public Object getTaskByGoalId(int goalId) {
        return taskRepository.findByGoalId(goalId);
    }
    // Delete by taskId
    public void deleteTaskById(int taskId) {
        // Remove by ID
        taskRepository.deleteById(taskId);
    }
    // new task
    public void createTask(Task task) {
        // Save to repo
        taskRepository.save(task);
    }
    // Update by id
    public void updateTask(int taskId, Task task) {
        // Retrieve
        Task taskToUpdate = taskRepository.getReferenceById(taskId);
        // Update
        taskToUpdate.replaceTask(task);
    }
}