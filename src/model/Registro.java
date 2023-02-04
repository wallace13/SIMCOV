package model;

import java.sql.Time;
import java.util.Date;

public class Registro {
	private int idRegistro;
	private Date dataEntrada , dataSaida;
	private Time horaEntrada , horaSaida;
	private Paciente paciente;
	private Leito leito;
	
	public Registro() {
		super();
	}
	public Registro(int idRegistro , Date dataEntrada , Date dataSaida , Time horaEntrada ,
            Time horaSaida , Paciente paciente , Leito leito){
		super();
		this.idRegistro = idRegistro;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.paciente = paciente;
		this.leito = leito;
	}
	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Time getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Time getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Time horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Leito getLeito() {
		return leito;
	}

	public void setLeito(Leito leito) {
		this.leito = leito;
	}
	
	
	
	
	
	
	 

}
