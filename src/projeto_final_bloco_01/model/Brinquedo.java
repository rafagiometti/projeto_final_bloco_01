package projeto_final_bloco_01.model;

public class Brinquedo  extends Produto{
	
	private String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Brinquedo(int id, String nome, double preco, int estoque, String material) {
		super(id, nome, preco, estoque);
		this.material = material;
	}

	@Override
	  public void visualizar() {
		  super.visualizar();
	        System.out.println("Material do Brinquedo: " + this.material);
	        System.out.println("*****************************************************");
	  }
}
