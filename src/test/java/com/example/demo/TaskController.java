package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Date;

@RestController
public class TaskController<taskList> {
    private final List<Task> taskList;

    public TaskController() {
        taskList = List.of(
          new Task(1,"task1", "description1", new Date()),
                new Task(1,"task1", "description1", new Date()),
                new Task(2,"task2", "description2", new Date()),
                new Task(3,"task2", "description3", new Date())
        );
    }

    @GetMapping("/tasks")
    public List<Task> getTask(){


        return taskList;
    }
}
