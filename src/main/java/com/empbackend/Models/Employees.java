package com.empbackend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@AllArgsConstructor@NoArgsConstructor
public class Employees {
    @Id
    private Integer id;
    private String name;
    private String imageurl;
    private String jobtitle;
    private String email;
}
