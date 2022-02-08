package escuelaing.edu.ieti.taller2.task.service;

import escuelaing.edu.ieti.taller2.task.data.Task;
import escuelaing.edu.ieti.taller2.task.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private HashMap<String,Task> tasks = new HashMap<>();

    @Override
    public Task create(TaskDto taskDto) {
        Task task = new Task(Integer.toString(tasks.size()),taskDto.getName(),taskDto.getDescription(),taskDto.getStatus(),taskDto.getAssignedTo(),taskDto.getDueDate(), LocalDateTime.now().toString());
        tasks.put(task.getId(),task);
        return task;
    }

    @Override
    public Task findById(String id) {
        Task ans = tasks.get(id);
        return ans;
    }

    @Override
    public List<Task> getAll() {
        List<Task> allTasks = new ArrayList<Task>();
        for(Task t:tasks.values()){
            allTasks.add(t);
        }
        return allTasks;
    }

    @Override
    public boolean deleteById(String id) {
        boolean ans = false;
        if (tasks.containsKey(id)){
            tasks.remove(id);
            ans= true;
        }
        return ans;
    }

    @Override
    public Task update(TaskDto taskDto, String id) {
        Task ans=null;
        if (tasks.containsKey(id)){
            ans = tasks.get(id);
            ans.setName(taskDto.getName());
            ans.setStatus(taskDto.getStatus());
            ans.setAssignedTo(taskDto.getAssignedTo());
            ans.setDescription(taskDto.getDescription());
            ans.setDueDate(taskDto.getDueDate());

        }
        return ans;
    }
}
