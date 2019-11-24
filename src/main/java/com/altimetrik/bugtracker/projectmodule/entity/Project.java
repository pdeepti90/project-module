package com.altimetrik.bugtracker.projectmodule.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="Project")
public class Project  implements Serializable {
    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @Column(name="project_desc")
    private String projectDesc;

    @Column(name="manager_id")
    private Long managerId;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="updated_by")
    private String updatedBy;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;


    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectDesc='" + projectDesc + '\'' +
                ", managerId=" + managerId +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Long getProjectId() {
        return projectId;
    }


    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public Project(Long projectId, String projectDesc, Long managerId) {
        this.projectId = projectId;
        this.projectDesc = projectDesc;
        this.managerId = managerId;
    }
}
