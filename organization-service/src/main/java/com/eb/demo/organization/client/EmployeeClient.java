package com.eb.demo.organization.client;

import com.eb.demo.organization.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/organization/{organizationId}")
    List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId);

}
