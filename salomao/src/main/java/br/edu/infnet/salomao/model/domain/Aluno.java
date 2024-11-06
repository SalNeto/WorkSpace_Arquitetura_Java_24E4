package br.edu.infnet.salomao.model.domain;

import java.util.List;

public class Aluno {
    private String nome;
    private String cpf;
    private String email;
    private List<Modalidade_Sports> modalidadeSports;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Modalidade_Sports> getModalidadeSports() {
        return modalidadeSports;
    }

    public void setModalidadeSports(List<Modalidade_Sports> modalidadeSports) {
        this.modalidadeSports = modalidadeSports;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
