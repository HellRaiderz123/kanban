package com.mytasknowcobackend.kanban.api;
import com.mytasknowcobackend.kanban.model.Projects;
import com.mytasknowcobackend.kanban.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/projects")
@RestController
public class ProjectsController {

    private final ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @PostMapping
    public void addProjects(@RequestBody Projects projects) {
        projectsService.addProject(projects);
    }

    @GetMapping
    public List<Projects> returnAllProjects(){
        return projectsService.returnAllProjects();
    }

    @GetMapping(path = "{projectId}")
    public  Projects selectProjectsbyId(@PathVariable ("projectId") String projectId) { return projectsService.selectProjectbyId(projectId); }

    @DeleteMapping(path = "{projectId}")
    public void deleteProjectsbyId(@PathVariable("projectId") String projectId){
        projectsService.deleteProjectbyId(projectId);
    }

    @PutMapping(path = "{projectId}")
    public  int  updateProjectbyId(@PathVariable("projectId") String projectId, @RequestBody Projects updatedProject){
        return projectsService.updateProjectbyId(projectId,updatedProject);
    }
}
