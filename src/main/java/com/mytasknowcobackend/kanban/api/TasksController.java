package com.mytasknowcobackend.kanban.api;

import com.mytasknowcobackend.kanban.model.Tasks;
import com.mytasknowcobackend.kanban.service.TasksService;
import com.mytasknowcobackend.kanban.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mytasknow.azurewebsites.net")
@RequestMapping("api/v1/tasks")
@RestController
public class TasksController {
    
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public void addTask(@RequestBody Tasks tasks) {
        tasksService.addTask(tasks);
    }

    @GetMapping
    public List<Tasks> returnAllTasks(){
        return tasksService.returnAllTasks();
    }

    @GetMapping(path = "{taskId}")
    public  Tasks selectTasksbyId(@PathVariable ("taskId") String taskId) { return tasksService.selectTaskbyId(taskId); }

    @GetMapping(path = "user-"+"{userId}")
    public  List<Tasks> selectTasksbyCreator(@PathVariable ("userId") String userId) { return tasksService.selectTaskbyCreator(userId); }


    @DeleteMapping(path = "{taskId}")
    public void deleteTasksbyId(@PathVariable("taskId") String taskId){
        tasksService.deleteTaskbyId(taskId);
    }

    @PutMapping(path = "{taskId}")
    public  int  updateTaskbyId(@PathVariable("taskId") String taskId, @RequestBody Tasks updatedtask){
        return tasksService.updateTaskbyId(taskId,updatedtask);
    }
    
}
