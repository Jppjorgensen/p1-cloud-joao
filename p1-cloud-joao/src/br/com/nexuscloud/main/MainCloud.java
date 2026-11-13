package br.com.nexuscloud.main;

import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.model.Cliente;
import br.com.nexuscloud.model.CloudManager;
import br.com.nexuscloud.model.Container;
import br.com.nexuscloud.model.Servidor;

import java.util.Locale;

// Campo de testes: segue o roteiro do enunciado passo a passo. RA: SEU_RA
public class MainCloud {

    public static void main(String[] args) throws CapacidadeExcedidaException {
        // Passo 1: cria o gerenciador. RA: SEU_RA
        CloudManager manager = new CloudManager();

        // Passo 2: cria o cliente. RA: SEU_RA
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // Passo 3: cria o servidor com 16 GB e R$ 5.50 por hora. RA: SEU_RA
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // Passo 4: registra o cliente e associa o servidor a ele. RA: SEU_RA
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);

        // Passo 5: cria os dois containers. RA: SEU_RA
        Container c1 = new Container("C-01", 10.0);
        Container c2 = new Container("C-02", 8.0);

        // Passo 6: com o servidor desligado esta linha estoura ServidorOfflineException.
        // Foi testada e depois comentada, como pede o passo 7. RA: SEU_RA
        // servidor.alocarContainer(c1);

        // Passo 7: liga o servidor. RA: SEU_RA
        servidor.ligar();

        // Passo 8: agora o container 1 entra (10 de 16 GB). RA: SEU_RA
        servidor.alocarContainer(c1);
        System.out.println("Container " + c1.getId() + " alocado com sucesso.");

        // Passo 9: 10 + 8 = 18 GB passa de 16 GB, entao a excecao checked e tratada aqui. RA: SEU_RA
        try {
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Alocacao recusada -> " + e.getMessage());
        }

        // Passo 10: so o servidor ligado entra na fatura (R$ 5.50). RA: SEU_RA
        System.out.printf(Locale.US, "Fatura ativa do cliente: R$ %.2f%n", manager.calcularFaturaAtiva(cliente));
    }
}
