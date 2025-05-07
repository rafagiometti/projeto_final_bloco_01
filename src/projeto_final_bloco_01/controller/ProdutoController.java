package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	private int id = 0;


    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    @Override
    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("\nProduto adicionado com sucesso!");
    }

    @Override
    public void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
            return;
        }

        for (Produto p : listaProdutos) {
            p.visualizar();
        }
    }

    @Override
    public Produto consultarProdutoPorId(int id) {
        Optional<Produto> produto = listaProdutos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (produto.isPresent()) {
            return produto.get();
        } else {
            System.out.println("\nProduto com ID " + id + " não encontrado.");
            return null;
        }
    }

    @Override
    public void atualizarProduto(Produto produtoAtualizado) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto p = listaProdutos.get(i);
            if (p.getId() == produtoAtualizado.getId()) {
                listaProdutos.set(i, produtoAtualizado);
                System.out.println("\nProduto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("\nProduto com ID " + produtoAtualizado.getId() + " não encontrado.");
    }

    @Override
    public void removerProduto(int id) {
        Produto produto = consultarProdutoPorId(id);
        if (produto != null) {
            listaProdutos.remove(produto);
            System.out.println("\nProduto removido com sucesso!");
        }
    }
    public int gerarId() {
        return ++id;
    }

    public Optional<Produto> buscarNaCollection(int id) {
        return listaProdutos.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }
}
