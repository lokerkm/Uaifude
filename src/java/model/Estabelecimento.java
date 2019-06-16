package model;

import java.util.ArrayList;

public class Estabelecimento extends Usuario {

    private int id;
    private String nome;
    private String cnpj;
    private String descricao;
    private String linkImagem;
    private Categoria categoria;
    private ArrayList<Produto> produtos = new ArrayList<>();


    public int getEstabelecimentoId() {
        return id;
    }

    public Estabelecimento setEstabelecimentoId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estabelecimento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Estabelecimento setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Estabelecimento setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Estabelecimento setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public Estabelecimento setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
        return this;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Estabelecimento setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

}
