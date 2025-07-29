package com.tlefort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What's your name ?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hello, " + name);

        String[] tasks2 = new String[]{"test2", "test3","test4", "test5"};

        for (String task : tasks2) {
            System.out.println(task);
        }

        String[] tasks3 = new String[tasks2.length+1];
        System.arraycopy(tasks2, 0, tasks3, 0, tasks2.length);
        System.out.println("Ajouter une tache");
        String task = input.nextLine();
        input.close();

        tasks3[tasks3.length-1] = task;

        for (String t: tasks3) {
            System.out.println(t);
        }

    }
}
