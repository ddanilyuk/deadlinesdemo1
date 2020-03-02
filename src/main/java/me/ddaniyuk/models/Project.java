package me.ddaniyuk.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    private String projectName;

    private String projectDescription;


    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Deadline> deadlines = new ArrayList<>();


    public Project() {
    }

    public Project(String projectName, String projectDescription) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public Project(String projectName, String projectDescription, List<Deadline> deadlines) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.deadlines = deadlines;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<Deadline> getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(List<Deadline> deadlines) {
        this.deadlines = deadlines;
    }

//    @Override
//    public String toString() {
//        return "Project{" +
//                "id=" + projectId +
//                ", project_name='" + projectName + '\'' +
//                ", project_description='" + projectDescription + '\'' +
//                ", deadlines=" + deadlines +
//                '}';
//    }
}
