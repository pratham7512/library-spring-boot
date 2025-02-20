package com.infosys.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryResponse {

	private Integer id;
	private String name;
	private String city;
	private String BookStatus;
	
	private BookResponse book;
}
