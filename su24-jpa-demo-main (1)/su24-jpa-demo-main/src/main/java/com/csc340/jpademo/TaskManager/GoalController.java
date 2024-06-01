package com.csc340.jpademo.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/goals")
public class GoalController {
    // GS instance
    @Autowired
    private GoalService goalService;
    // get for all
    @GetMapping("/all")
    public String getAllGoals(Model model) {
        // Add all
        model.addAttribute("goalList", goalService.getAllGoals());
        // return name
        return "goal-list";
    }
    // get for goal by id
    @GetMapping("/{goalId}")
    public String getGoalByGoalId(@PathVariable int goalId, Model model) {
        // Add goal
        model.addAttribute("goal", goalService.getGoalByGoalId(goalId));
        // returen name
        return "goal-by-goalid";
    }
    // get for userid
    @GetMapping("/{userId}")
    public String getGoalByUserId(@PathVariable int userId, Model model) {
        // add goal by user
        model.addAttribute("goal", goalService.getGoalByUserId(userId));
        // return name
        return "goal-by-userid";
    }
    // post for new goal
    @PostMapping("/create")
    public String addNewGoal(Goal goal) {
        // new by goalservice
        goalService.createGoal(goal);
        // Redirect to list
        return "redirect:/TaskManager/goals/all";
    }
    // post for update
    @PostMapping("/update")
    public String updateGoal(Goal goal) {
        // Update by id
        goalService.updateGoal(goal.getGoalId(), goal);
        // Redirect to all list
        return "redirect:/TaskManager/goals/all";
    }
    // get for updatting
    @GetMapping("/update/{goalId}")
    public String updateGoalForm(@PathVariable int goalId, Model model) {
        // Add goal for update
        model.addAttribute("goal", goalService.getGoalByGoalId(goalId));
        // view name?
        return "goal-update";
    }
    // get for goal id
    @GetMapping("/delete/{goalId}")
    public String deleteGoalById(@PathVariable int goalId) {
        // goalid delete
        goalService.deleteGoalById(goalId);
        // direction after deleted
        return "redirect:/TaskManager/goals/all";
    }
    // Web request!!
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
