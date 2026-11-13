package br.com.nexuscloud.exception;

// Excecao checked: herda de Exception, o compilador obriga a tratar. RA: SEU_RA
public class CapacidadeExcedidaException extends Exception {

    // Repassa a mensagem para a classe mae. RA: SEU_RA
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
