package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Date;
import com.example.demo;
@RestController
public class TaskController {
    private List<Task> taskList;

    public TaskController() {
        taskList = List.of(
          new Task(1,"task1", "description1", new Date()),
                new Task(1,"task1", "description1", new Date()),
                new Task(2,"task2", "description2", new Date())
                );
    }
}
