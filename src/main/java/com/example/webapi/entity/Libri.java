package com.example.webapi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//Annotazione utilizzata per evitare l'errore nelle richieste crud di tipo json.
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Libri")
public class Libri {

	


	@Id 
	@Column(name = "ISBN")
	
	private String isbn;

	@Basic(optional = false)//Rende il valore unullable
	private String titolo;

	@Basic(optional = false)
	private int pagine;

	@Basic(optional = false)
	@ManyToOne(fetch = FetchType.EAGER)// Indichiamo una relazione uno a molti con tipo di caricamento delle
	// entita(fetch) di tipo lazy ovvero verranno caricate le entità nel momento
	// della chiamata del metodo con questa annotazione
	@JoinColumn(name = "IDAUTORE")
	// annotazione per specificare punto di endpoint
	@EqualsAndHashCode.Exclude
	@JsonBackReference(value = "autore")
	private Autori autore;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "libro", orphanRemoval = true)
	@JsonIgnoreProperties
	private List<Recensioni> recensioni = new ArrayList<Recensioni>();

}
