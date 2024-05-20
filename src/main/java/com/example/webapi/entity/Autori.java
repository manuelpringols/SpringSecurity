package com.example.webapi.entity;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Autori")
public class Autori {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Integer id;

	private String nome;
	@Basic(optional = false)
	private String nazione;

	private String sesso;

	@Basic(optional = false)
	private Integer età;

	/*
	 * In questo caso per evitare di incombere in un errore, evitiamo di aggiungere
	 * la @JsonManagadeReference su entrambe le relazioni OneToMany
	 */

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "autore", orphanRemoval = true)
	private List<Libri> libri = new ArrayList<Libri>();// Indichiamo una relazione uno a molti con tipo di caricamento
														// delle
	// entita(fetch) di tipo lazy ovvero verranno caricate le entità nel momento
	// della chiamata del metodo con questa annotazione

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "autore", orphanRemoval = true)

	private List<Recensioni> recensioni = new ArrayList<Recensioni>();

}
