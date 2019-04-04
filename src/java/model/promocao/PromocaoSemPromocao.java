package model.promocao;

public class PromocaoSemPromocao implements Promocao {

    public int id;

    public PromocaoSemPromocao() {
        this.id = 4;
    }

    @Override
    public String getNome() {
        return "Sem Promoçao";
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public float getDesconto() {
        return 0;
    }

}
