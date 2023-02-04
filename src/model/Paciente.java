package model;

public class Paciente {
	
	private String cpf, nomeCompleto, sexo, dataNascimento;
	private int idade, numero;
    private String logradouro , complemento , bairro , cidade , uf , cep;
    private String telefone , telefoneParente;
    
    public Paciente(String cpf, String nomeCompleto, String sexo, int idade, String dataNascimento, 
    		String logradouro ,int numero ,  String complemento , String bairro ,
            String cidade , String uf , String cep , String telefone , String telefoneParente){
		 super();
		 this.cpf = cpf;
		 this.nomeCompleto = nomeCompleto;
		 this.sexo = sexo;
		 this.idade = idade;
		 this.dataNascimento = dataNascimento;
		 this.logradouro = logradouro;
		 this.numero = numero;
		 this.complemento = complemento;
		 this.bairro = bairro;
		 this.cidade = cidade;
		 this.uf = uf;
		 this.cep = cep;
		 this.telefone = telefone;
		 this.telefoneParente = telefoneParente;
	}
    public Paciente(){
        super();
    }
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefoneParente() {
		return telefoneParente;
	}
	public void setTelefoneParente(String telefoneParente) {
		this.telefoneParente = telefoneParente;
	}
	
}
