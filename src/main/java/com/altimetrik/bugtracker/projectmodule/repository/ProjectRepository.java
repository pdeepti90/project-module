package com.altimetrik.bugtracker.projectmodule.repository;

import com.altimetrik.bugtracker.projectmodule.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    Project findByProjectId(Long projectId);
}
