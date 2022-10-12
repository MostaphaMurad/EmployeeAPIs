package com.empbackend.Services;

import com.empbackend.Models.Employees;
import org.springframework.data.repository.NoRepositoryBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@NoRepositoryBean
public interface EmployeeServices {
    Mono<Employees>saveEmployee(Employees employee);
    Flux<Employees> getEmployees();
    Mono<Employees>findEmployeeById(Integer id);
    Mono<Void>deleteEmployeeById(Integer id);
    Mono<Employees>updateEmployee(Employees employee);
}
