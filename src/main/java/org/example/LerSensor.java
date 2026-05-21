package org.example;

public class LerSensor {
    public double ler_tempperatura() throws LeituraInconsistente{
        double temperatura = 999; //valor invalido

        //ai vem pra ca que vai dar erro
        if (temperatura > 60 || temperatura < -50){ //comparandou 2 valores de temperatura
           throw new LeituraInconsistente("Erro na leitura do sensor");
        }
        return temperatura;
    }
}
