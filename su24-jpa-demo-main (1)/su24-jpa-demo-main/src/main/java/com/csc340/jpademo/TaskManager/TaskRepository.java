package com.csc340.jpademo.TaskManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository
        extends JpaRepository<Task, Integer> {
    @Query(value = "select t from Task t where t.getGoalId =?1", nativeQuery = true)
    List<Task> findByGoalId(int goalId);
}
