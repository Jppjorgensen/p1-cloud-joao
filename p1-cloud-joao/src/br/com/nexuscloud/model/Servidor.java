package br.com.nexuscloud.model;

import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.exception.ServidorOfflineException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Servidor virtual; identificado pelo IP (RN01). RA: SEU_RA
public class Servidor {

    // Atributos privados do servidor. RA: SEU_RA
    private final String ip;
    private double ramTotal;
    private double precoPorHora;
    private boolean statusLigado;

    // RN02: lista criada na declaracao para nunca dar NullPointerException. RA: SEU_RA
    private List<Container> containers = new ArrayList<>();

    // Todo servidor nasce desligado (statusLigado = false). RA: SEU_RA
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false;
    }

    // Liga o servidor para que ele aceite containers. RA: SEU_RA
    public void ligar() {
        this.statusLigado = true;
    }

    // RN03: valida as duas regras antes de adicionar o container (fail-fast). RA: SEU_RA
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Regra de status: servidor desligado lanca a excecao unchecked. RA: SEU_RA
        if (!statusLigado) {
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }
        // Regra de capacidade: RAM em uso + RAM do novo container nao pode passar do total. RA: SEU_RA
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }
        containers.add(c);
    }

    // RN04: soma a RAM de todos os containers com Streams, sem for. RA: SEU_RA
    public double calcularRamEmUso() {
        return containers.stream()
                .mapToDouble(Container::getRamNecessaria)
                .sum();
    }

    public String getIp() {
        return ip;
    }

    public double getRamTotal() {
        return ramTotal;
    }

    public double getPrecoPorHora() {
        return precoPorHora;
    }

    public boolean isStatusLigado() {
        return statusLigado;
    }

    public List<Container> getContainers() {
        return containers;
    }

    // Dois servidores sao iguais quando tem o mesmo IP. RA: SEU_RA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servidor servidor = (Servidor) o;
        return Objects.equals(ip, servidor.ip);
    }

    // hashCode usa so o IP, igual ao equals. RA: SEU_RA
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    @Override
    public String toString() {
        return "Servidor{ip='" + ip + "', ramTotal=" + ramTotal + ", ligado=" + statusLigado + "}";
    }
}
