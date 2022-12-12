package br.com.imagemfilmes.desafio.entity;

import java.math.BigDecimal;
import java.util.List;


public class Pedido {

	public PedidoItem pedidoItem;
	
	private Long id;

	private Pessoa pessoa;

	private List<PedidoItem> itens;
    
	private BigDecimal valorTotal;

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Pedido setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}

	public Long getId() {
		return id;
	}

	public Pedido setId(Long id) {
		this.id = id;
		return this;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Pedido setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public Pedido setItens(List<PedidoItem> itens) {
		this.itens = itens;
		return this;
	}

	@Override
	public String toString() {
		return "Pedido{" + "id=" + id + ", pessoa=" + pessoa + '}';
	}

	public void calcularValorTotal() {
		getItens().forEach(PedidoItem::calcularValorTotal);
		this.valorTotal = getItens().stream().map(item -> item.getValorTotal()).reduce(BigDecimal.ZERO,
				BigDecimal::add);

	}
}