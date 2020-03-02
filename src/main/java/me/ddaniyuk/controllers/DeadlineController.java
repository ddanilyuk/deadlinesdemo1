package me.ddaniyuk.controllers;

import me.ddaniyuk.models.Deadline;
import me.ddaniyuk.models.Project;
import me.ddaniyuk.repositories.DeadlineRepository;
import me.ddaniyuk.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/deadlines")
public class DeadlineController {

    private final DeadlineRepository deadlineRepository;

    private final ProjectRepository projectRepository;

    public DeadlineController(DeadlineRepository deadlineRepository, ProjectRepository projectRepository) {
        this.deadlineRepository = deadlineRepository;
        this.projectRepository = projectRepository;
    }

//    @GetMapping("/all")
//    public List<Deadline> index(){
//        return deadlineRepository.findAll();
//    }


//    @PostMapping("/add/{id}")
//    public Project update(@PathVariable String id, @RequestBody Map<String, String> body){
//        int projectId = Integer.parseInt(id);
//        Project project = projectRepository.findByProjectId(projectId);
//
//        String project_name = body.get("project_name");
//        String project_description = body.get("project_description");
//        Deadline deadline = new Deadline(project_name, project_description);
//        deadline.setProject(project);
//
//        project.getDeadlines().add(deadline);
//
//
//        return projectRepository.save(project);
//    }
}
