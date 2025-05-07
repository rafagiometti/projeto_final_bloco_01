package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void adicionarEstoque(int quantidade) {
        this.estoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (quantidade <= estoque) {
            this.estoque -= quantidade;
        }
    }
    
   
    public void visualizar() {
        NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

        System.out.println("*****************************************************");
        System.out.println("                 DADOS DO PRODUTO                    ");
        System.out.println("-----------------------------------------------------");
        System.out.println("ID do Produto: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + nfMoeda.format(getPreco()));
        System.out.println("Estoque: " + getEstoque() + " unidades");
        System.out.println("*****************************************************");
    }


}
