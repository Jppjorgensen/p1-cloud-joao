package br.com.nexuscloud.exception;

// Excecao unchecked: herda de RuntimeException, nao obriga try-catch. RA: SEU_RA
public class ServidorOfflineException extends RuntimeException {

    // Repassa a mensagem para a classe mae. RA: SEU_RA
    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}
