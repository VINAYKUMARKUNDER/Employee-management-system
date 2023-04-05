package com.vinay.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Employee {
	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String firstName;

	    private String lastName;

	    
	    private LocalDate dateOfBirth;

	    
	    @Column(unique = true)
	    private String email;

	    private String phoneNumber;
	    
	    @JsonProperty(access = Access.WRITE_ONLY)
	    private String password;
	    
	    @Column(columnDefinition = "TEXT")
	    private String about;

	    @Embedded
	    private Address address;


}
