package Dados;

public class Pessoa4
{
    private String executante;
    private String servico;
    private String quantidade;
    private String preco;
    
    

    public Pessoa4() 
    {
        this.executante=null;
        this.servico=null;
        this.quantidade=null;
        this.preco=null;        
    }

    public Pessoa4(String executante, String servico, String quantidade, String preco)
    {
        this.executante = executante;
        this.servico = servico;
        this.quantidade = quantidade;
        this.preco = preco;        
    }

	public String getExecutante() {
		return executante;
	}

	public void setExecutante(String executante) {
		this.executante = executante;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	
    
}
