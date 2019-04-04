package model.promocao;

public class PromocaoAniversario implements Promocao {

    public int id;

    public PromocaoAniversario() {
        this.id = 2;
    }

    @Override
    public String getNome() {
        return "Aniversario";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public float getDesconto() {
        return 20;
    }
}
