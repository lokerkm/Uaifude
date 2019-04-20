package model;

public class Endereco {

    private int id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

//    public Endereco(String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
//
//        this.cep = cep;
//        this.logradouro = logradouro;
//        this.numero = numero;
//        this.complemento = complemento;
//        this.bairro = bairro;
//        this.cidade = cidade;
//        this.estado = estado;
//    }
//
//    public Endereco(int id, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
//        this.id = id;
//        this.cep = cep;
//        this.logradouro = logradouro;
//        this.numero = numero;
//        this.complemento = complemento;
//        this.bairro = bairro;
//        this.cidade = cidade;
//        this.estado = estado;
//    }
    public int getId() {
        return id;
    }

    public Endereco setId(int id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Endereco setEstado(String estado) {
        this.estado = estado;
        return this;
    }

}
