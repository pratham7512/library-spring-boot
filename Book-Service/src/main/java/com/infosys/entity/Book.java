package com.infosys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

	@Id
	@NotNull(message = "id should not be null")
	private Integer id;
	@NotNull(message = "name should not be null")
	private String name;
	@NotNull(message = "author should not be null")
	private String author;
	@NotNull(message = "publicationYear should not be null")
	private Long publicationYear;
}
