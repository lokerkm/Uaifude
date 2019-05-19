package model;

import java.util.ArrayList;

public class Combo {

    private int id;
    private int idEstabelecimento;
    private String nome;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Combo setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Combo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Combo setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public Combo setIdEstabelecimento(int id) {
        this.idEstabelecimento = id;
        return this;
    }

    public float getPreco() {
        float preco = 0;
        for (Produto produto : produtos) {
            preco += produto.getPrecoPosPromocao();
        }
        return preco;
    }

    public String getDescricao() {
        String descricao = "";
        for (Produto produto : produtos) {
            descricao += " 1 " + produto.getNome() + "\n";
        }
        return descricao;
    }

}
