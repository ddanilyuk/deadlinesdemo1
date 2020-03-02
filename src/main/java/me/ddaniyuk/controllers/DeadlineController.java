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

    @Autowired
    DeadlineRepository deadlineRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/all")
    public List<Deadline> index(){
        return deadlineRepository.findAll();
    }


    @PostMapping("/add/{id}")
    public Project update(@PathVariable String id, @RequestBody Map<String, String> body){
        int projectId = Integer.parseInt(id);
        Project project = projectRepository.findByProjectId(projectId);

        String project_name = body.get("project_name");
        String project_description = body.get("project_description");
        Deadline deadline = new Deadline(project_name, project_description);
        deadline.setProject(project);

        project.getDeadlines().add(deadline);

//        Project project = projectRepository.findById(projectId);
//        project.getDeadlines().add(deadline);
//
//        System.out.println(project);


//        Deadline deadline = new Deadline(project_name, project_description);

//        project.setDeadlines();

        return projectRepository.save(project);
    }
}
