package com.serveronspring.SpringServer.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDao {

    @Autowired
    private EmployeeRepository repository;
    public Employee save(Employee employee){
      return   repository.save(employee);

    }

    public  void delete(Employee employee){
        repository.delete(employee);
    }
    public List<Employee> getAllEmployees(){
    List<Employee> employees=new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(employees::add);
    return  employees;
    }
    public void  deleteAll(){
        repository.deleteAll();
    }
    public Optional<Employee> getById(Integer id){
        return repository.findById(id);

    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Integer getCount(){
       return (int)repository.count();
    }
}
