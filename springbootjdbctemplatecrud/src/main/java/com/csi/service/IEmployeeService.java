package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface IEmployeeService {
    void signUp(Employee employee);

    boolean signIn(String empEmailId, String empPassword);

    Employee findById(int empId);

    List<Employee> findAll();

    void updateData(int empId, Employee employee);

    void deleteById(int empId);

    void deleteAll();

}
