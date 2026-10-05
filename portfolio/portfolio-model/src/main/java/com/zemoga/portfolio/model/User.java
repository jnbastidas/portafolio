package com.zemoga.portfolio.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "user";

	public static final String ID = "iduser";
	public static final String USER_NAME = "user_name";
	public static final String EMAIL = "email";
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";

	@EqualsAndHashCode.Include
	private Long id;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
}
