package Dados;

public class Pessoa3
{
    private String descricao;
    private String quantidade;
    private String estoque;
    private String preco;
    
    

    public Pessoa3() 
    {
        this.descricao=null;
        this.quantidade=null;
        this.estoque=null;
        this.preco=null;        
    }

    public Pessoa3(String descricao, String quantidade, String estoque, String preco)
    {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.estoque = estoque;
        this.preco = preco;        
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	
   
    
}
