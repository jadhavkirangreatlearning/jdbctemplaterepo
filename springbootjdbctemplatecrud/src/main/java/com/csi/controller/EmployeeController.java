package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee) {
        log.info("@@@@@@@@Trying for SignUp Employee: " + employee.getEmpName());
        employeeService.signUp(employee);
        return ResponseEntity.ok("SignUp Done Successfully");

    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        return ResponseEntity.ok(employeeService.signIn(empEmailId, empPassword));
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Employee> findById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeService.findById(empId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee) {
        employeeService.updateData(empId, employee);
        return ResponseEntity.ok("Data Updated Successfully");
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId) {
        employeeService.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll() {
        employeeService.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        return ResponseEntity.ok(employeeService.findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).toList());
    }
}
