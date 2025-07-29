package com.tlefort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What's your name ?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        User user = new User(name);
        System.out.println("Hello, " + user.getFirstName());

        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task_"+i, "TEST", false, user);
            tasks.add(task);
        }

        for (Task t : tasks) {
            System.out.println(t);
        }

        input.close();

    }
}
