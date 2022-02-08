package escuelaing.edu.ieti.taller2.task.controller;

import escuelaing.edu.ieti.taller2.task.data.Task;
import escuelaing.edu.ieti.taller2.task.dto.TaskDto;
import escuelaing.edu.ieti.taller2.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TaskController {
    @RestController
    @RequestMapping( "/v1/task" )
    public class UserController {
        private final TaskService taskService;


        public UserController(@Autowired TaskService taskService) {
            this.taskService = taskService;
        }

        @GetMapping
        public ResponseEntity<List<Task>> getAll() {

            return new ResponseEntity<>(taskService.getAll(), HttpStatus.ACCEPTED);

        }

        @GetMapping("/{id}")
        public ResponseEntity<Task> findById(@PathVariable String id) {
            Task task = taskService.findById(id);
            if (task == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
            }
        }


        @PostMapping
        public ResponseEntity<Task> create(@RequestBody TaskDto taskDto) {
            Task task = taskService.create(taskDto);
            if (task == null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Task> update(@RequestBody TaskDto taskDto, @PathVariable String id) {
            Task task = taskService.update(taskDto, id);
            if (task == null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Boolean> delete(@PathVariable String id) {
            boolean state = taskService.deleteById(id);
            if (state == false) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
        }

    }
}
