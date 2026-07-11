package model;

public class Vendedor {

    private String cpfVendedor;
    private String nome;
    private String telefone;
    private double comissao;
    private String dataCadastro;
    private String horaCadastro;
	
    public String getCpfVendedor() {
		return cpfVendedor;
	}
	public void setCpfVendedor(String cpfVendedor) {
		this.cpfVendedor = cpfVendedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
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