package model;


public class Sintoma{
	
	private int idSintoma;
	private String dataDeInicio;
	private String tipoDeSintoma;
	private Paciente paciente;
	
	public Sintoma() {
		super();

	}
	public Sintoma(int idSintoma , String dataDeInicio , String tipoDeSintoma, Paciente paciente){
        super();
        this.idSintoma = idSintoma;
        this.dataDeInicio = dataDeInicio;
        this.tipoDeSintoma = tipoDeSintoma;
        this.paciente = paciente;
	}
	
	
	public int getIdSintoma() {
		return idSintoma;
	}
	public void setIdSintoma(int idSintoma) {
		this.idSintoma = idSintoma;
	}
	public String getDataDeInicio() {
		return dataDeInicio;
	}
	public void setDataDeInicio(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}
	public String getTipoDeSintoma() {
		return tipoDeSintoma;
	}
	public void setTipoDeSintoma(String tipoDeSintoma) {
		this.tipoDeSintoma = tipoDeSintoma;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
