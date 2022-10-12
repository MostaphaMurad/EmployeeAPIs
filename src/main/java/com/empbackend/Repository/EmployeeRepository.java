package com.empbackend.Repository;

import com.empbackend.Models.Employees;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employees,Integer> {
 /*   @Query("select  * from Employees")
    @Transactional
    Flux<Employees>findAllEmployees();
    @Modifying
    @Query(value = "insert into Employees (name,imageUrl,jobTitle,email) VALUES (:name,:imageUrl,:jobTitle,:email)")
    @Transactional
    Mono<Employees> saveEmployee(@Param("name") String name, @Param("imageUrl") String imageUrl,
                                @Param("jobTitle") String jobTitle, @Param("email") String email);

    @Query(value = "delete from  Employees where employees.id=:id ")
    Mono<Void> deleteEmployeeById(@Param("id") Integer id);
    @Query(value = "select * from Employees where Employees.id=:id")
    Mono<Employees> findEmployeeById(@Param("id") Integer id);*/
/*    @Modifying
    @Query(value = "update Employees  set Employees.name=$1," +
            "Employees.imageurl=$2," +
            "Employees.jobtitle=$3," +
            "Employees.email=$4 where Employees.id=$5")
    Mono<Employees> updateEmployee(@Param("name") String name,
                                  @Param("imageUrl") String imageUrl,
                                  @Param("jobTitle") String jobTitle,
                                  @Param("email") String email,
                                  @Param("id") Integer id);*/
}