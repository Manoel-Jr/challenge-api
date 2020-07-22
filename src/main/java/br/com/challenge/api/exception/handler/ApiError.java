package br.com.challenge.api.exception.handler;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError implements Serializable{
	 
	private static final long serialVersionUID = -4230309835147465491L;
	
	private Integer code;
	private String message;
	private Date data;
}
