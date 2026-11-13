package br.com.nexuscloud.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Banco de dados principal: cada cliente aponta para o seu conjunto de servidores. RA: SEU_RA
public class CloudManager {

    // RN02: Map com HashMap (busca rapida) e Set de servidores sem duplicados. RA: SEU_RA
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Registra o cliente com um conjunto vazio de servidores. RA: SEU_RA
    public void registrarCliente(Cliente c) {
        bancoDeDados.put(c, new HashSet<>());
    }

    // Adiciona um servidor ao conjunto do cliente. RA: SEU_RA
    public void adicionarServidor(Cliente c, Servidor s) {
        bancoDeDados.get(c).add(s);
    }

    // RN04: filtra so os servidores ligados e soma o preco por hora deles. RA: SEU_RA
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.get(c).stream()
                .filter(Servidor::isStatusLigado)
                .mapToDouble(Servidor::getPrecoPorHora)
                .sum();
    }
}
