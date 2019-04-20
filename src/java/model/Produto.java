package model;

import java.sql.SQLException;
import model.promocao.Promocao;
import persistence.EstabelecimentoDAO;

public class Produto {

    private int id;
    private Promocao promocao;
    private String nome;
    private float preco;
    private boolean disponivel;
    private String descricao;
    private String linkImagem;
    private int idEstabelecimento;

//    public Produto(int id, String nome, float preco, boolean disponivel, String descricao, String linkImagem) {
//        this.id = id;
//        this.nome = nome;
//        this.preco = preco;
//        this.disponivel = disponivel;
//        this.descricao = descricao;
//        this.linkImagem = linkImagem;
//    }
//    
//    public Produto(int id, String nome, float preco, boolean disponivel, String descricao, String linkImagem, Promocao promocao) {
//        this.id = id;
//        this.nome = nome;
//        this.preco = preco;
//        this.disponivel = disponivel;
//        this.descricao = descricao;
//        this.linkImagem = linkImagem;
//        this.promocao = promocao;
//    }
//    
//    public Produto(String nome, float preco, boolean disponivel, String descricao, String linkImagem) {
//        
//        this.nome = nome;
//        this.preco = preco;
//        this.disponivel = disponivel;
//        this.descricao = descricao;
//        this.linkImagem = linkImagem;
//    }
    public int getId() {
        return id;
    }

    public Produto setId(int id) {
        this.id = id;
        return this;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public Produto setPromocao(Promocao promocao) {
        this.promocao = promocao;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public float getPreco() {
        return preco;
    }

    public float getPrecoPosPromocao() {
        return preco - preco * promocao.getDesconto() / 100;
    }

    public Produto setPreco(float preco) {
        this.preco = preco;
        return this;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Produto setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public Produto setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
        return this;
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public Produto setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
        return this;
    }

    public Estabelecimento getEstabelecimento() throws SQLException, ClassNotFoundException {
        return EstabelecimentoDAO.getInstance().getEstabelecimento(idEstabelecimento);
    }
}
