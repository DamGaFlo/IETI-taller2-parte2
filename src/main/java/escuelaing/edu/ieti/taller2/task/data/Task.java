package escuelaing.edu.ieti.taller2.task.data;

import escuelaing.edu.ieti.taller2.task.dto.Status;

public class Task {
    private String id;
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;
    private String created;

    public Task(String id, String name, String description, Status status, String assignedTo, String dueDate, String created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }

    public String getId() {
        return id;
    }

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

    public String getCreated() {
        return created;
    }
}
