package model;

public class Leito {
	private int idLeito;
	private boolean disponibilidade;
	private String tipoDeCovid;
	    
    public Leito(){
        super();
    }
    public Leito(int idLeito , boolean disponibilidade , String tipoDeCovid){
        super();
        this.idLeito = idLeito;
        this.disponibilidade = disponibilidade;
        this.tipoDeCovid = tipoDeCovid;
    }
	public int getIdLeito() {
		return idLeito;
	}
	public void setIdLeito(int idLeito) {
		this.idLeito = idLeito;
	}
	public boolean isDisponivel() {
		return disponibilidade;
	}
	public void setDisponivel(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public String getTipoDeCovid() {
		return tipoDeCovid;
	}
	public void setTipoDeCovid(String tipoDeCovid) {
		this.tipoDeCovid = tipoDeCovid;
	}
    


}
