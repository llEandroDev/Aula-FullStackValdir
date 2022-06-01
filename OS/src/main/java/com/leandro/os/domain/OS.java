package com.leandro.os.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leandro.os.enuns.Prioridade;
import com.leandro.os.enuns.Status;

@Entity(name = "TAB_OS")
public class OS {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime DataAbertura;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime DataFechamento;
	private Integer prioridade;
	private String observaoca;
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "Tecnico_Id")
	private Tecnico tecnico;

	@ManyToOne
	@JoinColumn(name = "Cliente_Id")
	private Cliente cliente;

	public OS() {
		super();
		this.setDataAbertura(LocalDateTime.now());
		this.setPrioridade(Prioridade.Baixa);
		this.setStatus(Status.Aberto);
	}

	public OS(Integer id, Prioridade prioridade, String observaoca, Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.setDataAbertura(LocalDateTime.now());
		this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
		this.observaoca = observaoca;
		this.status = (status == null) ? 0 : status.getCod();
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return DataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		DataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return DataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		DataFechamento = dataFechamento;
	}

	public Prioridade getPrioridade() {
		return Prioridade.toEnum(this.prioridade);
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade.getCod();
	}

	public String getObservaoca() {
		return observaoca;
	}

	public void setObservaoca(String observaoca) {
		this.observaoca = observaoca;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		return Objects.equals(id, other.id);
	}

}
