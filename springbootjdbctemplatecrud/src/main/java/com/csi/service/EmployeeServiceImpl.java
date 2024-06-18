package com.csi.service;

import com.csi.dao.IEmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    public void signUp(Employee employee) {

        employeeDao.signUp(employee);

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDao.signIn(empEmailId, empPassword);
    }

    @Override
    public Employee findById(int empId) {
        return employeeDao.findById(empId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void updateData(int empId, Employee employee) {
        employeeDao.updateData(empId, employee);
    }

    @Override
    public void deleteById(int empId) {
        employeeDao.deleteById(empId);
    }

    @Override
    public void deleteAll() {
        employeeDao.deleteAll();
    }
}
