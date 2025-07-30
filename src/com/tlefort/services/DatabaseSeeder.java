package com.tlefort.services;

import com.tlefort.Task;
import com.tlefort.User;

public class DatabaseSeeder {
    private final DatabaseAccess databaseAccess = DatabaseAccess.getInstance();

    public void seed(User user) {
        for (int i = 0; i < 5; i++){
            Task task = new Task("Task_" + i, "TEST", false, user);
            databaseAccess.addTask(task);
        }
    }
}
