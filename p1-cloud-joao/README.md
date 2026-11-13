# Atividade 15/10 — NexusCloud Manager

`Cliente`, `Servidor` e `Container` com `equals`/`hashCode` por CPF, IP e ID. `Servidor.alocarContainer` aplica fail-fast com `ServidorOfflineException` (unchecked) e `CapacidadeExcedidaException` (checked). `calcularRamEmUso` e `calcularFaturaAtiva` usam Streams. O `CloudManager` guarda `Map<Cliente, Set<Servidor>>`.

## Como rodar

Abra o terminal na pasta do projeto (onde está este README). É preciso ter o JDK 17 ou superior.

**macOS / Linux**

```bash
javac -encoding UTF-8 -sourcepath src -d bin src/br/com/nexuscloud/main/MainCloud.java
java -cp "bin" br.com.nexuscloud.main.MainCloud
```

**Windows**

```bat
javac -encoding UTF-8 -sourcepath src -d bin src\br\com\nexuscloud\main\MainCloud.java
java -cp "bin" br.com.nexuscloud.main.MainCloud
```

## Resultado esperado

O container C-01 é alocado, o C-02 é recusado (18 GB > 16 GB) e a fatura sai R$ 5.50. O passo 6 está comentado no `MainCloud`; tirando o comentário, a `ServidorOfflineException` aparece, como pede o enunciado.
