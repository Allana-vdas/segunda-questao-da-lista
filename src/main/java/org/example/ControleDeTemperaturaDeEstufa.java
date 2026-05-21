package org.example;

public class ControleDeTemperaturaDeEstufa {
   private LerSensor sensor = new LerSensor();
   private AtuadorDoSensor atuador = new AtuadorDoSensor();

   public void monitorar_sistema(){
       String status_do_sistema = "Sistema está funcionando";

       try {
           double temperatura = sensor.ler_tempperatura();
           System.out.println("A temperatura esta de: " + temperatura + " °C");

           if (temperatura > 30){ //se a temperatura tiver alta liga o ventilador
               atuador.ligar_ventilador();
           } else if (temperatura < 18) { //se a temperatura estiver baixa liga o aquecedor
               atuador.ligar_aquecedor();
           } else {
               System.out.println("Está na temperatura certa/ideal");
           }
       } catch (LeituraInconsistente e){
           status_do_sistema = "Falha no sensor";
           System.out.println(e.getMessage());
       } catch (FalhaNoAtuador e){
           status_do_sistema = "Falha no atuador";
           System.out.println(e.getMessage());
       } finally {
           atualizar_o_log(status_do_sistema);
       }
   }

   public void atualizar_o_log(String status){
       System.out.println("O log foi atualizado a tentativa foi finalizada " + status);
   }
}


