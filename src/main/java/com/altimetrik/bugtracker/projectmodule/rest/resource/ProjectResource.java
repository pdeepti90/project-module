package com.altimetrik.bugtracker.projectmodule.rest.resource;

import com.altimetrik.bugtracker.projectmodule.bean.EmployeeBean;
import com.altimetrik.bugtracker.projectmodule.bean.ProjectBean;
import com.altimetrik.bugtracker.projectmodule.exceptions.BadRequestAlertException;
import com.altimetrik.bugtracker.projectmodule.rest.delegate.ProjectDelegate;
import com.altimetrik.bugtracker.projectmodule.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectResource {
    private final static String ENTITY_NAME = "ProjectResource";
    @Autowired
    private ProjectService projectService;
    @Autowired
    ProjectDelegate projectDelegate;

    @PostMapping("/projects")
    public ResponseEntity<ProjectBean> createProject(@Valid @RequestBody ProjectBean projectBean) throws Exception {
        if (projectBean.getProjectId() != null) {
            throw new BadRequestAlertException("A new Bug can not have already existing ID : " + ENTITY_NAME);
        }
        projectBean = this.projectService.save(projectBean);
        EmployeeBean employee = this.projectDelegate.fetchEmployee(projectBean.getManagerId());
        projectBean.setManagerName(employee.getName());
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(projectBean.getProjectId()).toUri();
        return ResponseEntity.created(location).body(projectBean);
    }

   /* @PostMapping (path="/projects/search")
    public ResponseEntity<List<ProjectBean>> searchBugs(@RequestBody ProjectBean projectBean){
        return null;
    }*/

    @GetMapping(path = "/projects/{projectId}")
    public ResponseEntity<ProjectBean> fetchProject(@PathVariable Long projectId) {
        ProjectBean projectBean = this.projectService.fetchById(projectId);
        EmployeeBean employee = this.projectDelegate.fetchEmployee(projectBean.getManagerId());
        projectBean.setManagerName(employee.getName());
        return ResponseEntity.ok().body(projectBean);
    }

    @GetMapping(path = "/projects")
    public ResponseEntity<List<ProjectBean>> fetchAllProjects() {
        return null;
    }



}

