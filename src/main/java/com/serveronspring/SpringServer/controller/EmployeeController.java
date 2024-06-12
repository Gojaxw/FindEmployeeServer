package com.serveronspring.SpringServer.controller;

import com.serveronspring.SpringServer.model.employee.Employee;
import com.serveronspring.SpringServer.model.employee.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/employee/login")
    public Employee logInEmployee(@RequestBody String email,String password){
        List<Employee> employeeList=getAllEmployees();
        for(int i=0;i<employeeList.size();i++){
            if(employeeList.get(i).getMail().equals(email)&&employeeList.get(i).getPassword().equals(password)){
                return employeeList.get(i);
            }
        }
        Employee employee =new Employee();
        employee.setId(-1);
        return  employee;
    }
    @PostMapping("/employee/save")
    public Employee getAllEmployees(@RequestBody Employee employee){
        employee.setId(employeeDao.getCount()==0? 1:employeeDao.getCount()+1);
        return  employeeDao.save(employee);
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
