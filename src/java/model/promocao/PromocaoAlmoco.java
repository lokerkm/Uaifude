package model.promocao;

public class PromocaoAlmoco implements Promocao {

    public int id;

    public PromocaoAlmoco() {
        this.id = 1;
    }

    @Override
    public String getNome() {
        return "Almoco";
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public float getDesconto() {
        return 10;
    }

}
