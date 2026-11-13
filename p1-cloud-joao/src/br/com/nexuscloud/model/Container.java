package br.com.nexuscloud.model;

import java.util.Objects;

// Aplicacao que roda dentro de um servidor; identificada pelo ID (RN01). RA: SEU_RA
public class Container {

    // Atributos privados do container. RA: SEU_RA
    private final String id;
    private double ramNecessaria;

    // Construtor com o id e a memoria que o container precisa. RA: SEU_RA
    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    public String getId() {
        return id;
    }

    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // Dois containers sao iguais quando tem o mesmo ID. RA: SEU_RA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id);
    }

    // hashCode baseado so no ID, igual ao equals. RA: SEU_RA
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Container{id='" + id + "', ramNecessaria=" + ramNecessaria + "}";
    }
}
