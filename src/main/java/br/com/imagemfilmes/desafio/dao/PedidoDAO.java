package br.com.imagemfilmes.desafio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.imagemfilmes.desafio.entity.Pedido;
import br.com.imagemfilmes.desafio.entity.PedidoItem;
import br.com.imagemfilmes.desafio.entity.Pessoa;
import br.com.imagemfilmes.desafio.entity.Produto;

public class PedidoDAO extends DAO {

	public PedidoDAO(final Connection connection) {
		super(connection);
	}


	public List<Pedido> findAll() throws SQLException {

		try (PreparedStatement psmt = getConnection().prepareStatement("SELECT pedido_tb.*, pessoa_tb.*, pedido_item_tb.*,produto_tb.*"
				+ " FROM pedido_tb INNER JOIN pessoa_tb ON pedido_tb.ID_Pessoa = pessoa_tb.ID_Pessoa\r\n"
				+ "INNER JOIN pedido_item_tb ON pedido_item_tb.ID_Pedido_Item = pedido_tb.ID_Pedido INNER JOIN produto_tb ON  pedido_item_tb.ID_Produto = produto_tb.ID_Produto;")) {
			try (ResultSet rs = psmt.executeQuery()) {
				final List<Pedido> pedidos = buildPedido(rs);
				return pedidos;
			}
		}
	}

	
	
	public List<Pedido> findPedidosOrderByValor() throws SQLException {

		try (PreparedStatement psmt = getConnection().prepareStatement("SELECT pedido_tb.*, pessoa_tb.*, pedido_item_tb.*,produto_tb.* FROM pedido_tb INNER JOIN pessoa_tb ON pedido_tb.ID_Pessoa  = pessoa_tb.ID_Pessoa \r\n"
				+ "INNER JOIN pedido_item_tb ON pedido_item_tb.ID_Pedido_Item = pedido_tb.ID_Pedido INNER JOIN produto_tb ON  pedido_item_tb.ID_Produto = produto_tb.ID_Produto order by valor_total;")) {
			try (ResultSet rs = psmt.executeQuery()) {
				final List<Pedido> pedidos = buildPedido(rs);
				return pedidos;
			}
		}
	}

	public List<Pedido> findPedidosbyClienteId(Long ClienteId) throws SQLException {
		try (PreparedStatement psmt = getConnection().prepareStatement("SELECT pedido.*, pessoa.*, pedido_item.*,produto.* FROM pedido_tb INNER JOIN pessoa_tb ON pedido_tb.ID_Pessoa = pessoa_tb.ID_Pessoa \r\n"
				+ "INNER JOIN pedido_item_tb ON pedido_tb.ID_Pedido_Item = pedido_tb.ID_Pedido  INNER JOIN produto_tb ON  pedido_item_tb.ID_Produto = produto_tb.ID_Produto WHERE ID_Pessoa = ?;")) {
			psmt.setLong(1, ClienteId);
			try (ResultSet rs = psmt.executeQuery()) {
				final List<Pedido> pedidos = buildPedido(rs);
				return pedidos;
			}

		}
	}

	private List<Pedido> buildPedido(ResultSet rs) throws SQLException {
		final List<Pedido> pedidos = new ArrayList<>();

		while (rs.next()) {
			final List<PedidoItem> pedidoitens = new ArrayList<>();
			
			final Produto produto = new Produto()
					.setRegistro(rs.getInt("ID_Produto"))
					.setDescricao(rs.getString("descricao"))
					.setValorUnitario(rs.getBigDecimal("valor_unitario"));
			
			

			
			final PedidoItem pedidoItem = new PedidoItem()
					//.setId(rs.getLong("ID_Pedido_Item"))
					.setQuantidade(rs.getInt("quantidade"))
					.setValorTotal(rs.getBigDecimal("valor_total"))
					.setProduto(produto);

			
			pedidoitens.add(pedidoItem);

			final Pessoa pessoa = new Pessoa()
					.setId(rs.getLong("ID_Pessoa"))
					.setCpf(rs.getString("cpf"))
					.setNome(rs.getString("nome"));
					
			

			final Pedido pedido = new Pedido()
					.setId(rs.getLong("ID_Pedido"))
					.setPessoa(pessoa)
					.setValorTotal(rs.getBigDecimal("valor_total"));

			pedidos.add(pedido);
		}
		return pedidos;
	}

}
