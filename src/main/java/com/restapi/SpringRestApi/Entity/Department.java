package com.restapi.SpringRestApi.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

//Lombok
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depatmentId;
    //Validation
    @NotBlank(message = "Name Required")
//    @Length(min = 10,max = 100)
//    @Size(max = 10,min = 5)
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @Past
//    @FutureOrPresent
//    @PastOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;






}
