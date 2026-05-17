package org.example;

public class Main {
    public static void main(String[] args) {
       ControleDeTemperaturaDeEstufa estufa = new ControleDeTemperaturaDeEstufa();

       System.out.println("TESTE PARA A TEMPERATURA ALTA");
       estufa.monitorar_temperatura(35.0); //para ligar o ventilador

        System.out.println("TESTE PARA TEMPERATURA BAIXA");
        estufa.monitorar_temperatura(10.0); //para ligar o aquecedor

        System.out.println("TESTE PARA SENSOR COM DEFEITO");
        estufa.monitorar_temperatura(999.0);

        System.out.println("TESTE PARA EQUIPAMENTO COM FALHA");
        estufa.monitorar_temperatura(55.0);
    }
}