package com.csc340.jpademo.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GoalService {
    @Autowired
    GoalRepository goalRepository;
    // get all goals
    public Object getAllGoals() {
        return goalRepository.findAll();
    }
    // get by id
    public Goal getGoalByGoalId(int goalId) {
        // get by id, null if not
        return goalRepository.findById(goalId).orElse(null);
    }
    // goals by user
    public Object getGoalByUserId(int userId) {
        return goalRepository.findByUserId(userId);
    }
    // Delete by id
    public void deleteGoalById(int goalId) {
        // Remove
        goalRepository.deleteById(goalId);
    }
    // Create new goal
    public void createGoal(Goal goal) {
        // Save to repo
        goalRepository.save(goal);
    }
    // Update existing by id
    public void updateGoal(int goalId, Goal goal) {
        // get the existing
        Goal goalToUpdate = goalRepository.getReferenceById(goalId);
        // Update
        goalToUpdate.replaceGoal(goal);
    }
}

