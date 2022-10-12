package com.empbackend.EmpServicesImp;

import com.empbackend.Models.Employees;
import com.empbackend.Repository.EmployeeRepository;
import com.empbackend.Services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service@AllArgsConstructor
public class EmployeeServicesImp implements EmployeeServices {
    private final EmployeeRepository employeeRepository;
    @Override
    public Mono<Employees> saveEmployee(Employees employee) {
        return employeeRepository.save(employee)
                .switchIfEmpty(Mono.error(new Exception("Cant save employee")));
    }

    @Override
    public Flux<Employees> getEmployees() {
        return employeeRepository.findAll().delayElements(Duration.ofSeconds(1))
                .switchIfEmpty(Mono.error(new Exception("No Employees Found")));
    }
    @Override
    public Mono<Employees> findEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("wrong id for employee")));
    }
    @Override
    public Mono<Void> deleteEmployeeById(Integer id) {
       return employeeRepository.deleteById(id);
    }
    @Override
    @Transactional
    public Mono<Employees> updateEmployee(Employees employee) {
        return employeeRepository.findById(employee.getId())
                .map(old->{
                    if(employee.getName()!=null)old.setName(employee.getName());
                    if(employee.getJobtitle()!=null)old.setJobtitle(employee.getJobtitle());
                    if(employee.getEmail()!=null)old.setEmail(employee.getEmail());
                    if(employee.getImageurl()!=null)old.setImageurl(employee.getImageurl());
                    return old;
                })
                .switchIfEmpty(Mono.error(new Exception("cant update employee")))
                .flatMap(employeeRepository::save);
    }
}
