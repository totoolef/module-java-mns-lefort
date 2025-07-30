package com.tlefort;

import com.tlefort.services.DatabaseAccess;
import com.tlefort.services.DatabaseSeeder;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    static DatabaseAccess databaseAccess = DatabaseAccess.getInstance();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What's your name ?");
        String name = input.nextLine();
        User user = new User(name);
        databaseAccess.addUser(user);
        System.out.println("Hello, " + user.getFirstName());

        new DatabaseSeeder().seed(user);
        listTasks();

        boolean loop = true;
        while (loop) {
            System.out.println("\nSouhaitez-vous ajouter ou supprimer une tâche ? \n 1) Ajouter \n 2) Supprimer \n 3) Quitter)");
            String action = input.nextLine().trim().toLowerCase();

            switch (action) {
                case "1":
                    System.out.print("Titre de la tâche: ");
                    String title = input.nextLine();
                    System.out.print("Description: ");
                    String description = input.nextLine();

                    Task newTask = new Task(title, description, false, user);
                    databaseAccess.addTask(newTask);
                    System.out.println("Tâche ajoutée.");
                    listTasks();
                    break;

                case "2":
                    System.out.print("Position ?");
                    String uuidStr = input.nextLine();
                    try {
                        UUID id = UUID.fromString(uuidStr);
                        boolean removed = databaseAccess.removeTaskById(id);
                        if (removed) {
                            System.out.println("Tâche supprimée.");
                        } else {
                            System.out.println("Aucune tâche trouvée avec cet UUID.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Format d'UUID invalide.");
                    }
                    listTasks();
                    break;

                case "3":
                    loop = false;
                    System.out.println("Ciao !");
                    break;

                default:
                    System.out.println("Veuillez taper 'ajouter', 'supprimer' ou 'quit'.");
            }
        }

        input.close();
    }

    private static void listTasks() {
        System.out.println("\nListe des tâches : \n");
        if (databaseAccess.getTasks().isEmpty()) {
            System.out.println("Aucune tâche");
        } else {
            for (Task task : databaseAccess.getTasks()) {
                System.out.println(task);
            }
        }
    }
}
