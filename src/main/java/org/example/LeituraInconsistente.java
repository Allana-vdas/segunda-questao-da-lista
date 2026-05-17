package org.example;

//usar pra quando o valor do sensor for impossivel ou absurdo
public class LeituraInconsistente extends RuntimeException {
    public LeituraInconsistente(String msg) { //construtor que recebe um texto
        super(msg);//super pra enviar essa mensagem que o construtor recebeu pra classe mãe
    }
}
