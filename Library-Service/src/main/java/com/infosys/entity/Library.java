package com.infosys.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "library")
public class Library {
	
	@Id
	@NotNull(message = "id is not null")
	private Integer id;
	@NotNull(message = "name is not null")
	private String name;
	@NotNull(message = "city is not null")
	private String city;
	@NotNull(message = "bookid is not null")
	private Integer bookid;
	@NotNull(message = "BookStatus is not null")
	private String BookStatus;
}
