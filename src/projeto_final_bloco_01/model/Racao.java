package projeto_final_bloco_01.model;

public class Racao extends Produto {
    private String tipoAnimal;

    public Racao(int id, String nome, double preco, int estoque, String tipoAnimal) {
        super(id, nome, preco, estoque);
        this.tipoAnimal = tipoAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    @Override
    public void visualizar() {
        super.visualizar();

        System.out.println("Tipo de Animal (Ração): " + this.tipoAnimal);
        System.out.println("*****************************************************");
    }
}

