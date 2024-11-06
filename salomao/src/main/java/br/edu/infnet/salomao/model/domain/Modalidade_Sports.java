package br.edu.infnet.salomao.model.domain;

public abstract class Modalidade_Sports {
    private String tipoSport;
    private int codigo;
    private float duracao;
    private Recepcao recepcao;
    private boolean preco;

    public String getTipoSport() {
        return tipoSport;
    }

    public void setTipoSport(String tipoSport) {
        this.tipoSport = tipoSport;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public Recepcao getRecepcao() {
        return recepcao;
    }

    public void setRecepcao(Recepcao recepcao) {
        this.recepcao = recepcao;
    }

    public boolean isPreco() {
        return preco;
    }

    public void setPreco(boolean preco) {
        this.preco = preco;
    }
}
