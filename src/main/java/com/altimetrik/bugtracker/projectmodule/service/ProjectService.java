package com.altimetrik.bugtracker.projectmodule.service;

import com.altimetrik.bugtracker.projectmodule.bean.ProjectBean;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    public ProjectBean save(ProjectBean projectBean);
    public ProjectBean fetchById(Long projectId);



}
