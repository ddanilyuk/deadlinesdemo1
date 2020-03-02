package me.ddaniyuk.repositories;

import me.ddaniyuk.models.Deadline;
import me.ddaniyuk.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Project findByProjectId(int id);

}
