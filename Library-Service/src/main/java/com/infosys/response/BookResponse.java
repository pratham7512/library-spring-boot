package com.infosys.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

	private Integer id;
	private String name;
	private String author;
	private Long publicationYear;
}
