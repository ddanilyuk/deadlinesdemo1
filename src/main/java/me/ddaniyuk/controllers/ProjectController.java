package me.ddaniyuk.controllers;

import me.ddaniyuk.models.Deadline;
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
    public List<Project> index() {
        return projectRepository.findAll();
    }


    @GetMapping("/{id}")
    public Project one(@PathVariable String id) {
        int projectId = Integer.parseInt(id);
        return projectRepository.findByProjectId(projectId);
    }


    @PostMapping("/add/newProject")
    public Project newProject(@RequestBody Map<String, String> body) {

        String project_name = body.get("project_name");
        String project_description = body.get("project_description");
        Project project = new Project(project_name, project_description);
        return projectRepository.save(project);
    }


    @PostMapping("/add/{id}/deadline")
    public Project deadlineToProject(@PathVariable String id, @RequestBody Map<String, String> body) {
        Project project = projectRepository.findByProjectId(Integer.parseInt(id));

        String project_name = body.get("deadline_name");
        String project_description = body.get("deadline_description");
        Deadline deadline = new Deadline(project_name, project_description);
        deadline.setProject(project);

        project.getDeadlines().add(deadline);

        return projectRepository.save(project);
    }


}
