package org.example;

////vou usar esse tratamento pra quando tentar ligar o ventilador ou aquecedor e ele não funcionar do jeito certo
public class FalhaNoAtuador extends RuntimeException{
    public FalhaNoAtuador(String msg){ //construtor que recebe uma mensagem
        super(msg); //super vai enviar a mensagem do construtor pra classe mão
    }

}
