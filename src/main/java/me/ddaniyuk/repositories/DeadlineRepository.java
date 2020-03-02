package me.ddaniyuk.repositories;

import me.ddaniyuk.models.Deadline;
import me.ddaniyuk.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeadlineRepository extends JpaRepository<Deadline, Integer> {

//    List<Deadline> findByProject(int id);

}
