package model.promocao;

public class PromocaoJantar implements Promocao {

    public int id;

    public PromocaoJantar() {
        this.id = 3;
    }

    @Override
    public String getNome() {
        return "Jantar";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public float getDesconto() {
        return 15;
    }

}
