package com.eb.demo.employee.repository;

import com.eb.demo.employee.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee add(Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
    }

    public List<Employee> findByOrganization(Long organizationId) {
        return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

    public String talk(@PathVariable String question) throws IOException {
        String info = URLEncoder.encode(question, "utf-8");
        String APIkey = "4fedeb6d58814f1f934821e33892151f";
        String getUrl = "http://www.tuling123.com/openapi/api?key="
                +APIkey+"&info="+info;
        URL url = new URL(getUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while((line = br.readLine()) != null){
            stringBuilder.append(line);
        }
        String result = stringBuilder.substring(stringBuilder.lastIndexOf(":"));
        System.out.print(result);
        return  result;
    }
}
