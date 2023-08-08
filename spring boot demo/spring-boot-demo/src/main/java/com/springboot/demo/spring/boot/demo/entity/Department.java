package com.springboot.demo.spring.boot.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "please add department name")
    @Length(max = 5, min = 1)
    @Size(max = 10, min = 1)
    // we can use the appropriate validation annotation based on the field
  /*  @Email
    @Positive
    @Future
    @Past*/
    private String name;
    private String address;
    private String code;
}
