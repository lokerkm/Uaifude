package model;

public class Estabelecimento extends Usuario {

    private int id;
    private String nome;
    private String cnpj;
    private String descricao;
    private Categoria categoria;
 

    public Estabelecimento(int id, String nome, String cnpj, String descricao,  int usuarioId, String login, String senha, String email, String tipo, String telefone, String celular) {
        super(usuarioId, login, senha, email, tipo, telefone, celular);
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
       
    }

    public int getEstabelecimentoId() {
        return id;
    }

    public void setEstabelecimentoId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    

}
