package org.example;

public class ControleDeTemperaturaDeEstufa {
    double temperatura_atual_do_sensor; //pra guardar o valor da temperatura
    double limite_maximo_do_sensor = 30.0; //pra saber qual o valor máximo do sensor, para se passar ligar o ventilador
    double limite_minimo_do_sensor = 15.0; //pra saber qual o valor minimo do sensor, para se diminuir ligar o aquecedor
    boolean ventilador_ligado_desligado; //pra guardar o estado do ventilador se for true ele ta ligado se for false ta desligado
    boolean aquecedor_ligado_desligado; //pra guardar o estado do aquecedor se for true ta ligado se for false ta desligado

    public double ler_sensor(double valor_do_sensor) throws LeituraInconsistente {
        if (valor_do_sensor > 60 || valor_do_sensor < -10) { //esses valores pq é impossível de acontecer em uma estufa
            throw new LeituraInconsistente("Erro de leitura do sensor o valor lido " + valor_do_sensor + " °C é impossível para uma estufa");
        } else { //pra se não cair no erro vai ser valido então vai guardar o valor na variavel temperatura
            temperatura_atual_do_sensor = valor_do_sensor; //aqui tá guardando
        }
        return valor_do_sensor; //delvolve o valor pra quem chamou
    }
        //metodos pra ligar e desligar o ventilador e aquecedor
        public void ligar_ventilador () throws FalhaNoAtuador {
            //condição de falha
            if (temperatura_atual_do_sensor > 50) { //condição de erro
                throw new FalhaNoAtuador("Erro na temperatura o ventilador queimou, não liga!");
            } else { //se a condição não for vdd vem pro else, onde muda o status do ventilador pra true
                ventilador_ligado_desligado = true; //ligando o ventilador
                System.out.println(" O ventilador foi ligado!"); //avisando que o ventilador foi ligado
            }
        }
        //aqui não tem tratamento de erro pq desligar o ventilador sempre vai funcionar
        public void desligar_ventilador () {
            ventilador_ligado_desligado = false;
            System.out.println("Ventilador desligado");
        }

        //msm logica do metodo desligar ventilador so vai mudar a condição de erro
        public void ligar_aquecedor() throws FalhaNoAtuador{
            //condição de falha
            if (temperatura_atual_do_sensor < -5){
                throw new FalhaNoAtuador("Erro na temperatura do aquecedor ele congelou e não liga!");
            } else {
                aquecedor_ligado_desligado = true;
                System.out.println(" O aquecedor foi igado!");
            }
        }
        public void desligar_aquecedor(){
            aquecedor_ligado_desligado = false;
            System.out.println("Aquecedor desligado");
        }

        public void monitorar_temperatura(double valor_do_sensor) {
            String status_log = ""; //variavel pra guardar o status de tudo e serve pra usar no try,catch e finally
            try { //tratamento de erro
                //aqui eu chamo o metodo ler sensor
                double temperatura_lida = ler_sensor(valor_do_sensor); //se passar dessa linha é pq deu certo
                status_log = "Leitura da temperatura foi lida, valor: " + temperatura_lida + " °C"; //vai guar a informação aqui

                if (temperatura_atual_do_sensor > limite_maximo_do_sensor) {
                    ligar_ventilador(); //se passar do limite maximo, liga o ventilador e atualiza o texto de status += pq vai adiconar esse texto na variavel
                    status_log += " O ventilador foi ligado por conta da temperatura baixa";
                } else if (temperatura_atual_do_sensor < limite_minimo_do_sensor) {
                    ligar_aquecedor(); //se tiver frio liga o aquecedor e atualiza o status
                    status_log += " Aquecedor ligado temperatura baixa";
                } else { //se a temperatura tiver boa desliga tudo
                    desligar_ventilador();
                    desligar_aquecedor();
                    status_log += "Atemperatura está ideal, todos os equipamentos estão desligados";
                }
            } catch (LeituraInconsistente e) { //pega o erro que teve em try
                //se o erro for do tipo leitura vai executar ele
                status_log = "Falha no sensor: " + e.getMessage(); //guardo o erro na variavel status e pega a mensagem do throw la em cima
                //não precisa do system pq vai usar o finally e ele vai registrar tudo
            } catch (FalhaNoAtuador e) { //para o outro tipo de erro
                status_log = "Falha no equipamento: " + e.getMessage();
            } finally { //aqui ele sempre vai rodar msm se deu certo ou não no try
                System.out.println("\n");
                System.out.println("Status do sensor: " + status_log); //pra mostrar o registro de histórico
            }
        }


    }


