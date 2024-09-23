package unip.penha.patrick.todolist.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import unip.penha.patrick.todolist.create.AddTarefas;

public class ToDoList {

    private static List<AddTarefas> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weekDay;

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Adicionar tarefas");
            System.out.println("2 - Verificar tarefas não concluidas");
            System.out.println("3 - Verificar tarefas concluidas");
            System.out.println("4 - Editar Tarefas");
            System.out.println("5 - Excluir tarefas");
            System.out.println("6 - Sair");
            weekDay = scanner.nextInt();
            scanner.nextLine();

            switch (weekDay) {
                case 1:
                    System.out.println("Qual será o nome da tarefa?");
                    String nameTask = scanner.nextLine();

                    System.out.println("Qual será a descrição da tarefa?");
                    String descriptionTask = scanner.nextLine();

                    System.out.println("Qual será a data de conclusão da tarefa?");
                    String dateTask = scanner.nextLine();

                    AddTarefas newTask = new AddTarefas(nameTask, descriptionTask, dateTask);
                    tasks.add(newTask);
                    System.out.println(newTask);

                    System.out.print('\u000C');
                    break;
                case 2:
                    System.out.println("Lista de tarefas não concluídas:");
                    for (AddTarefas task : tasks) {
                        if (!task.isCompleted()) {
                            System.out.println(tasks);
                        }
                    }

                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.println("Lista de tarefas concluídas:");
                    for (AddTarefas task : tasks) {
                        if (task.isCompleted()) {
                            System.out.println(tasks);
                        }
                    }

                    System.out.print('\u000C');
                    break;
                case 4:
                    System.out.println("Editar Tarefas");
                    System.out.println("Lista de tarefas:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + " - " + tasks.get(i).getName() + " (Status: "
                                + (tasks.get(i).isCompleted() ? "Concluída" : "Não concluída") + ")");
                    }

                    System.out.println("Digite o número da tarefa que deseja editar:");
                    int taskIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        AddTarefas taskToEdit = tasks.get(taskIndex);

                        System.out.println("O que deseja editar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Descrição");
                        System.out.println("3 - Data de Conclusão");
                        System.out.println("4 - Status (Concluída ou Não Concluída)");
                        int editOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (editOption) {
                            case 1:
                                System.out.println("Digite o novo nome da tarefa:");
                                String newName = scanner.nextLine();
                                taskToEdit.setName(newName);
                                break;
                            case 2:
                                System.out.println("Digite a nova descrição da tarefa:");
                                String newDescription = scanner.nextLine();
                                taskToEdit.setDescription(newDescription);
                                break;
                            case 3:
                                System.out.println("Digite a nova data de conclusão da tarefa:");
                                String newDate = scanner.nextLine();
                                taskToEdit.setDate(newDate);
                                break;
                            case 4:
                                System.out.println("A tarefa está concluída? (sim/não):");
                                String statusInput = scanner.nextLine();
                                boolean newStatus = statusInput.equalsIgnoreCase("sim");
                                taskToEdit.setStatus(newStatus);
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }

                        System.out.println("Tarefa atualizada:");
                        System.out.println(taskToEdit);
                    } else {
                        System.out.println("Número de tarefa inválido.");
                    }

                    System.out.print('\u000C');
                    break;
                case 5:
                    System.out.println("Excluir tarefas");
                    System.out.println("Lista de tarefas:");

                    if (tasks.isEmpty()) {
                        System.out.println("Nenhuma tarefa para excluir.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + " - " + tasks.get(i).getName());
                        }

                        System.out.println("Digite o número da tarefa que deseja excluir:");
                        int taskIndexToDelete = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (taskIndexToDelete >= 0 && taskIndexToDelete < tasks.size()) {
                            AddTarefas removedTask = tasks.remove(taskIndexToDelete);
                            System.out.println("A tarefa '" + removedTask.getName() + "' foi excluída com sucesso.");
                        } else {
                            System.out.println("Número de tarefa inválido.");
                        }
                    }

                    System.out.print('\u000C');
                    break;
                case 6:
                    System.out.println("SAIU");
                    break;
                default:
                    System.out.println("Numero invalido, tente novamente");
                    System.out.print('\u000C');
            }

        } while (weekDay != 6);
        scanner.close();
    }
}
