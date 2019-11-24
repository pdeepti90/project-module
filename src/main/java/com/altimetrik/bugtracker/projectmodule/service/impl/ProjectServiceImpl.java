package com.altimetrik.bugtracker.projectmodule.service.impl;

import com.altimetrik.bugtracker.projectmodule.bean.ProjectBean;
import com.altimetrik.bugtracker.projectmodule.entity.Project;
import com.altimetrik.bugtracker.projectmodule.repository.ProjectRepository;
import com.altimetrik.bugtracker.projectmodule.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl  implements ProjectService {
@Autowired
    ProjectRepository projectRepository;

    @Override
    public ProjectBean save(ProjectBean projectBean) {
        Project project =  new Project();
        BeanUtils.copyProperties(projectBean,project);
        projectBean.setProjectId(this.projectRepository.save(project).getProjectId());
        return projectBean;
    }

    @Override
    public ProjectBean fetchById(Long projectId) {
      Project  project =  projectRepository.findByProjectId(projectId);
        ProjectBean projectBean =  new ProjectBean();
        //projectBean.setProjectId(project.get().getProjectId());
       // projectBean.setProjectId(this.projectRepository.save(project).getProjectId());

        BeanUtils.copyProperties(project,projectBean);
        //Get the manager Details from the Project Id using User Service.

        return projectBean;
    }
}
