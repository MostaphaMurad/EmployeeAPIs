package com.empbackend.Controllers;

import com.empbackend.EmpServicesImp.EmployeeServicesImp;
import com.empbackend.Models.Employees;
import com.empbackend.Models.Employees;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.*;

@RestController
@AllArgsConstructor
@RequestMapping("/emp/v1/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class EmployeeController {
    private final EmployeeServicesImp employeeServicesImp;
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping(value = "/emps",produces = APPLICATION_STREAM_JSON_VALUE )
    @ResponseStatus(OK)
    public Flux<Employees>getEmployees(){
        return employeeServicesImp.getEmployees();
    }
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Mono<Employees>>> saveEmployee(@RequestBody Employees employee){
        return Mono.just(new ResponseEntity<>(employeeServicesImp.saveEmployee(employee),CREATED));
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void>deleteEmployee(@PathVariable("id")Integer id){
        return employeeServicesImp.deleteEmployeeById(id);
    }
    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employees>updateEmployee(@RequestBody Employees employee){
        return  employeeServicesImp.updateEmployee(employee);
    }
    @GetMapping("/find/{id}")
    public Mono<Employees>findEmployee(@PathVariable("id")Integer id){
        return employeeServicesImp.findEmployeeById(id);
    }

}
