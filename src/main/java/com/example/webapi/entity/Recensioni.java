package com.example.webapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Recensioni")
public class Recensioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Specifichiamo che la chiave primaria sia di un valore che si autoincrementa. 
	@Column(name = "ID")
	@Basic(optional = false)
	private Integer id;

	private int voto;
	@Column(name = "RECENSIONE")
	private String recensione;

	
	@OneToOne(fetch = FetchType.LAZY)// Indichiamo una relazione molti a uno con tipo di caricamento delle
	// entita(fetch) di tipo lazy ovvero verranno caricate le entità nel momento
	// della chiamata del metodo con questa annotazione
	@JoinColumn(name = "IDAutore")
	@Basic(optional = false)
	@JsonBackReference(value = "autore")// annotazione per specificare punto di endpoint
	@EqualsAndHashCode.Exclude// annotazione per negare il conflitto con Lombok
	private Autori autore;

	@Basic(optional = false)
	@OneToOne(fetch = FetchType.LAZY) // Indichiamo una relazione molti a uno con tipo di caricamento delle
										// entita(fetch) di tipo lazy ovvero verranno caricate le entità nel momento									// della chiamata del metodo con questa annotazione
	@JoinColumn(name = "Isbn")
	@JsonBackReference(value = "libro") // annotazione per specificare punto di endpoint
	@EqualsAndHashCode.Exclude // annotazione per negare il conflitto con Lombok
	private Libri libro;
}
