package br.com.nexuscloud.model;

import java.util.Objects;

// Cliente da NexusCloud; o CPF identifica o cliente (RN01). RA: SEU_RA
public class Cliente {

    // Atributos privados para garantir o encapsulamento. RA: SEU_RA
    private final String cpf;
    private String nome;

    // Construtor recebe os dados obrigatorios do cliente. RA: SEU_RA
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getters para leitura dos dados. RA: SEU_RA
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    // Setter so do nome; o CPF nao muda porque e a identidade. RA: SEU_RA
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Dois clientes sao iguais quando tem o mesmo CPF. RA: SEU_RA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    // hashCode usa o mesmo campo do equals para o HashMap funcionar. RA: SEU_RA
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{cpf='" + cpf + "', nome='" + nome + "'}";
    }
}
