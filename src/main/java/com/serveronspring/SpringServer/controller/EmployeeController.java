package com.serveronspring.SpringServer.controller;

import com.serveronspring.SpringServer.model.employee.Employee;
import com.serveronspring.SpringServer.model.employee.EmployeeDao;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

   @Autowired
  private EmployeeDao employeeDao;


    @GetMapping("/employee/get-all")
    public List<Employee> getAllEmployees() {

        return employeeDao.getAllEmployees();
    }
    @PostMapping("/employee/getAll")
    public List<Employee> getAllEmployeesEmployee(@RequestBody Employee employee) {
       
        Integer id=employee.getId();
        employeeDao.deleteById(id);
        employeeDao.save(employee);
        return employeeDao.getAllEmployees();
    }
    @PostMapping("employee/save-new-coordinate")
    public Employee saveNewCoordinate(@RequestBody Employee employee ){
        Integer id=employee.getId();
        employeeDao.deleteById(employee.getId());
        employeeDao.save(employee);
        return employeeDao.getById(employee.getId()).get();
    }
    @PostMapping("/employee/save")
    public Employee signUp(@RequestBody Employee employee){

        Integer id=employee.getId();
        if(id<1){
            employee.setId(employeeDao.getCount()+1);
        }
        return  employeeDao.save(employee);
    }
    @PostMapping("/employee/getEmployee/{userId}")
    public Employee getEmployee(@PathVariable Integer userId){
        return employeeDao.getById(userId).get();
    }
    @PostMapping("/employee/login")
    public Employee logInEmployee(@RequestBody Employee employee){
        String password=employee.getPassword(),
                email=employee.getMail();
        List<Employee> employeeList=getAllEmployees();
        for(int i=0;i<employeeList.size();i++){
            String mailE=employeeList.get(i).getMail();
            String passwordP=employeeList.get(i).getPassword();
            if(mailE.equals(email)&&passwordP.equals(password)){
                return employeeList.get(i);
            }
        }
        Employee employeeTemp =new Employee();
        employee.setId(-1);
        employee.setPassword(password);
        employee.setMail(email);
        return  employee;
    }

    @DeleteMapping("/employee/delete/{userId}")
    public String getAllEmployees(@PathVariable Integer userId){
        employeeDao.deleteById(userId);
        return "Success";
    }
    @DeleteMapping("/employee/delete-all")
    public String deleteAllEmployees(){
        employeeDao.deleteAll();
        return "Success";
    }


}
