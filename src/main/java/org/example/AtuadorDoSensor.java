package org.example;

public class AtuadorDoSensor {
    public void ligar_ventilador() throws FalhaNoAtuador{ //metodo pra ligar o ventilador
        boolean ventilador_falhou =  true;

        if (ventilador_falhou){
            throw new FalhaNoAtuador("Erro o ventilador falhou");
        }
        System.out.println("O ventilador está ligado!");
    }

    public void ligar_aquecedor(){
        System.out.println("O aquecedor foi ligado!");
    }
}
