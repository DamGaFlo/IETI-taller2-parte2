package escuelaing.edu.ieti.taller2.task.dto;

public class TaskDto {
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }
}
