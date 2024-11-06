package br.edu.infnet.salomao.model.domain;

public class Alimenticios {
    private boolean organico;
    private String industrializado;

    public boolean isOrganico() {
        return organico;
    }

    public void setOrganico(boolean organico) {
        this.organico = organico;
    }

    public String getIndustrializado() {
        return industrializado;
    }

    public void setIndustrializado(String industrializado) {
        this.industrializado = industrializado;
    }
}
