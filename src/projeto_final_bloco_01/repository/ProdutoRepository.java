package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface ProdutoRepository {
	    void adicionarProduto(Produto produto);
	    void listarProdutos();
	    Produto consultarProdutoPorId(int id);
	    void atualizarProduto(Produto produto);
	    void removerProduto(int id);
	
}
