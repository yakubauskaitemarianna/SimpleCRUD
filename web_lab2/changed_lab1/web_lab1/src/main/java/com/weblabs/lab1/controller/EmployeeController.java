package com.weblabs.lab1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.weblabs.lab1.model.EmployeeDAO;
import com.weblabs.lab1.model.Employee;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// {"empNo":"E11","empName":"New Employee","position":"Clerk"}

@RestController
public class EmployeeController {
	@Autowired
    private EmployeeDAO employeeDAO = new EmployeeDAO();
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to 1st WEB lab.";
    }
 
    // URL:
    // http://localhost:8080/employees
    // http://localhost:8080/employees.xml
    // http://localhost:8080/employees.json
    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        logger.trace("GET: getEmployees");
        if (!list.isEmpty())
        	return ResponseEntity.ok(list);
        return ResponseEntity.notFound().build();
    }
 
    // URL:
    // http://localhost:8080/employee/{empNo}
    // http://localhost:8080/employee/{empNo}.xml
    // http://localhost:8080/employee/{empNo}.json
    @RequestMapping(value = "/employee/{empNo}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Employee> getEmployee(@PathVariable("empNo") String empNo) {
    	logger.trace("GET: getEmployee");
    	if (employeeDAO.getEmployee(empNo) instanceof Employee)
    		return ResponseEntity.ok(employeeDAO.getEmployee(empNo));
        return ResponseEntity.notFound().build();
    }
 
    // URL:
    // http://localhost:8080/employee
    // http://localhost:8080/employee.xml
    // http://localhost:8080/employee.json
 
    @RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {
    	logger.trace("POST: addEmployee");
        System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());
 
        return employeeDAO.addEmployee(emp);
    }
 
    // URL:
    // http://localhost:8080/employee
    // http://localhost:8080/employee.xml
    // http://localhost:8080/employee.json
    @RequestMapping(value = "/employee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) throws URISyntaxException {
    	logger.trace("PUT: updateEmployee");
        System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
        
        return ResponseEntity.created(new URI("/" + emp.getEmpNo())).body(employeeDAO.updateEmployee(emp));
    }
 
    // URL:
    // http://localhost:8080/employee/{empNo}
    @RequestMapping(value = "/employee/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("empNo") String empNo) {
    	logger.trace("DELETE: deleteEmployee");
        System.out.println("(Service Side) Deleting employee: " + empNo);
 
        employeeDAO.deleteEmployee(empNo);
        
        if (!(employeeDAO.getEmployee(empNo) instanceof Employee))
        	return ResponseEntity.ok(employeeDAO.getEmployee(empNo));
        
        return ResponseEntity.notFound().build();
    }
 
}

