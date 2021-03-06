package me.ddaniyuk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "deadline")
@JsonIgnoreProperties("project")
public class Deadline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deadlineId;

    private String deadlineName;

    private String deadlineDescription;

    // поля которые не храянться в БД
//    @Transient

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
//    @JsonManagedReference
    private Project project;

    public Deadline() {
    }

    public Deadline(String deadlineName, String deadlineDescription) {
        this.deadlineName = deadlineName;
        this.deadlineDescription = deadlineDescription;
    }

    public Deadline(String deadlineName, String deadlineDescription, Project project) {
        this.deadlineName = deadlineName;
        this.deadlineDescription = deadlineDescription;
        this.project = project;
    }

    public int getDeadlineId() {
        return deadlineId;
    }

    public void setDeadlineId(int deadlineId) {
        this.deadlineId = deadlineId;
    }

    public String getDeadlineName() {
        return deadlineName;
    }

    public void setDeadlineName(String deadlineName) {
        this.deadlineName = deadlineName;
    }

    public String getDeadlineDescription() {
        return deadlineDescription;
    }

    public void setDeadlineDescription(String deadlineDescription) {
        this.deadlineDescription = deadlineDescription;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
