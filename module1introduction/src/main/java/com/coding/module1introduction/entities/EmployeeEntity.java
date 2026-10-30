package com.coding.module1introduction.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name = "employees")
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String age;
    private String email;
    private boolean isActive;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoining;

}
