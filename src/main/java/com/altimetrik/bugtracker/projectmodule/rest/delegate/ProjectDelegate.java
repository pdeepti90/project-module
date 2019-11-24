package com.altimetrik.bugtracker.projectmodule.rest.delegate;

import com.altimetrik.bugtracker.projectmodule.bean.EmployeeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("Employee")
public interface ProjectDelegate {
    @GetMapping(path = "/api/employees")
    EmployeeBean fetchEmployee(@RequestParam(name="employeeId") Long employeeId);
}
