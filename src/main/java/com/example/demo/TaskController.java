package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TaskController<taskList> {
    private final List<Task> taskList;
    private AtomicInteger taskId = new AtomicInteger(0);
    public TaskController() {
        taskList = new ArrayList<>();
        taskList.add(new Task(taskId.incrementAndGet(),"task1", "description1", new Date()));
        taskList.add(new Task(taskId.incrementAndGet(),"task2", "description2", new Date()));
        taskList.add(new Task(taskId.incrementAndGet(),"task3", "description3", new Date()));
        taskList.add(new Task(taskId.incrementAndGet(),"task4", "description4", new Date()));
    }
    @GetMapping("/tasks")
    public List<Task> getTask(){
        return taskList;
    }
    @PostMapping("/tasks")
    Task createTask(@RequestBody Task task){
        var newTask = new Task(taskId.incrementAndGet(), task.getTitle(), task.getDescription(), task.getDueDate());
        taskList.add(newTask);
        return newTask;
    }

    @GetMapping("/tasks/{id}")
    Task getTask(@PathVariable("id") Integer id){
        for (int i = 0; i <taskList.size(); i++) {
            if(taskList.get(i).id ==id){
                return taskList.get(i);
            }
        }

        return null;
    }

    @DeleteMapping("/tasks/{id}")
    Task deleteTask(@PathVariable("id") Integer id){
       Task task1 = null;
        for (int i = 0; i <taskList.size(); i++) {
            if (taskList.get(i).id == id) {
                task1 = taskList.get(i);
                taskList.remove(i);
            }
        }
        return task1;
    }
}
