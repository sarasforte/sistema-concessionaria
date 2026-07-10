package model;

public class Automovel {

    private int idAutomovel;
    private int idMarca;
    private double preco;
    private int ano;
    private String modelo;
    private String cor;
    private String statusAutomovel;
    private String dataCadastro;
    private String horaCadastro;
    
	public int getIdAutomovel() {
		return idAutomovel;
	}
	public void setIdAutomovel(int idAutomovel) {
		this.idAutomovel = idAutomovel;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getStatusAutomovel() {
		return statusAutomovel;
	}
	public void setStatusAutomovel(String statusAutomovel) {
		this.statusAutomovel = statusAutomovel;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(String horaCadastro) {
		this.horaCadastro = horaCadastro;
	}

}