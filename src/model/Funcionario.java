package model;

public class Funcionario {
	
	private int idFuncionario , nivelPermissao;
    private String nomeCompleto , nomeUsuario , senha;
    
    public Funcionario(){
        super();
    }

    public Funcionario(int idFuncionario , String nomeCompleto , String nomeUsuario , String senha ,
                    int nivelPermissao){
        super();
        this.idFuncionario = idFuncionario;
        this.nomeCompleto = nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nivelPermissao = nivelPermissao;
    }

    public int getIdFuncionario(){
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario){
        this.idFuncionario = idFuncionario;
    }

    public String getNomeCompleto(){
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }

    public void setNomeDeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public int getNivelPermissao(){
        return nivelPermissao;
    }

    public void setNivelPermissao(int nivelPermissao){
        this.nivelPermissao = nivelPermissao;
    }

    @Override
    public String toString(){
        return "Funcionario [idFuncionario=" + idFuncionario + ", nomeCompleto=" + nomeCompleto + ", nomeUsuario="
               + nomeUsuario + ", Senha=" + senha + ", nivelPermissao=" + nivelPermissao + "]";
    }

}
