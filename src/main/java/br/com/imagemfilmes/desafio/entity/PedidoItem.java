package br.com.imagemfilmes.desafio.entity;

import java.math.BigDecimal;

public class PedidoItem {
	
    private Long id;
    
    private Produto produto;
    
    private int quantidade;
    
    private Pedido pedido;
    
    private BigDecimal ValorTotal;
    


	public BigDecimal getValorTotal() {
		return ValorTotal;
	}

	public PedidoItem setValorTotal(BigDecimal precoTotal) {
		this.ValorTotal = precoTotal;
		return this;
	}

	public long getId() {
        return id;
    }

    public PedidoItem setId(long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public PedidoItem setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public PedidoItem setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public PedidoItem setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    @Override
    public String toString() {
        return "PedidoItem{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", pedido=" + pedido +
                '}';
    }	
    
    public void calcularValorTotal() {
		BigDecimal precoUnitario = this.getProduto().getValorUnitario();
		Integer quantidade = this.getQuantidade();

		if (precoUnitario == null) {
			precoUnitario = BigDecimal.ZERO;
		}

		this.setValorTotal(precoUnitario.multiply(new BigDecimal(quantidade)));
	}
    
    
}