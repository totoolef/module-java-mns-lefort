package com.tlefort.services;

import com.tlefort.Task;
import com.tlefort.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseAccess {

    private static DatabaseAccess instance;

    public static DatabaseAccess getInstance() {
        if (instance == null) {
            instance = new DatabaseAccess();
        }
        return instance;
    }

    private DatabaseAccess() {}

    List<User> users = new ArrayList<>();
    List<Task> tasks = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task findTaskById(UUID id) {
        Task task = null;
        for (Task task1 : tasks) {
            if (task1.getId().equals(id)) {
                task = task1;
            }
        }
        return task;
    }

    public User findUserById(UUID id) {
        User user = null;
        for (User user1 : users) {
            if (user1.getId().equals(id)) {
                user = user1;
            }
        }
        return user;
    }

    public boolean removeTaskById(UUID id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }

}
