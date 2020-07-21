package br.com.challenge.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	
	private static final long serialVersionUID = 3294651597776960578L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String nome;
	
	@Column(length = 11)
	private String cpf;
	
	@Column(length = 7)
	private String rg;
	
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNascimento;
	
	@Email
	
	private String email;
	
	@Column(length = 11)
	private String telefone;
	
	@Column(length = 8)
	private String cep;
	
	
	private String endereco;
	
	
	private Integer numero;
	
	
	private String bairro;
	
	
	private String cidade;
	
	
	private String uf;
	
	
	private String pais;
	
}	