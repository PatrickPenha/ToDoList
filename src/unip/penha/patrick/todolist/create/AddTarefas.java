package unip.penha.patrick.todolist.create;

public class AddTarefas {
    private String name;
    private String description;
    private String date;
    private boolean status;

    public AddTarefas(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public boolean isCompleted() {
        return status;
    }

    public void setStatus(boolean completed) {
        this.status = completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tarefa: " + name +
                ", Descrição: " + description +
                ", Data de Conclusão: " + date +
                ", Status: " + (status ? "Concluída" : "Não concluída");
    }
}
