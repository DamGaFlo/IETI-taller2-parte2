package escuelaing.edu.ieti.taller2.task.service;

import escuelaing.edu.ieti.taller2.task.data.Task;
import escuelaing.edu.ieti.taller2.task.dto.TaskDto;

import java.util.List;

public interface TaskService {
    Task create(TaskDto taskDto );

    Task findById( String id );

    List<Task> getAll();

    boolean deleteById( String id );

    Task update(TaskDto taskDto, String id );
}
