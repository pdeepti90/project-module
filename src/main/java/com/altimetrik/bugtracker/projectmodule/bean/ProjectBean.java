package com.altimetrik.bugtracker.projectmodule.bean;

import java.util.List;

public class ProjectBean {
    private Long projectId;
    private String projectDesc;
    private Long managerId;
    private String managerName;

    public ProjectBean(Long projectId, String projectDesc, Long managerId, String managerName) {
        this.projectId = projectId;
        this.projectDesc = projectDesc;
        this.managerId = managerId;
        this.managerName = managerName;
    }
    public ProjectBean() {

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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
