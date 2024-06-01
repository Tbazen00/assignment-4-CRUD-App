package com.csc340.jpademo.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("//TaskManager/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
    // get for all T
    @GetMapping("/all")
    public String getAllTasks(Model model) {
        // Add all T
        model.addAttribute("taskList", taskService.getAllTasks());
        // Return name
        return "task-list";
    }
    // Get t by id
    @GetMapping("/{goalId}")
    public String getTaskByGoalId(@PathVariable int goalId, Model model) {
        // Add T by id to model
        model.addAttribute("task", taskService.getTaskByGoalId(goalId));
        // Return nawe
        return "task-by-goalid";
    }
    // post for new T
    @PostMapping("/create")
    public String addNewTask(Task task) {
        // Create new by service
        taskService.createTask(task);
        // Redirect
        return "redirect:/TaskManager/tasks/all";
    }
    // post to update existing
    @PostMapping("/update")
    public String updateTask(Task task) {
        // Update by Tid
        taskService.updateTask(task.getTaskId(), task);
        // Redirect
        return "redirect:/TaskManager/tasks/all";
    }
    // get for update form
    @GetMapping("/update/{taskId}")
    public String updateTaskForm(@PathVariable int taskId, Model model) {
        // Add task to update
        model.addAttribute("task", taskService.getTaskByTaskId(taskId));
        // return name
        return "task-update";
    }
    // get to delete T by id
    @GetMapping("/delete/{taskId}")
    public String deleteTaskById(@PathVariable int taskId) {
        // Delete by id
        taskService.deleteTaskById(taskId);
        // Redirect
        return "redirect:/TaskManager/tasks/all";
    }
}