package me.ddaniyuk.controllers;

import me.ddaniyuk.models.Project;
import me.ddaniyuk.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/all")
    public List<Project> index(){
        return projectRepository.findAll();
    }


    @PostMapping("/add")
    public Project update(@RequestBody Map<String, String> body){

        String project_name = body.get("project_name");
        String project_description = body.get("project_description");
        Project project = new Project(project_name, project_description);

        return projectRepository.save(project);
    }

}
