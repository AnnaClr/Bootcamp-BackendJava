import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        seleçãoCandidatos();
        imprimirSelecionados();
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    } 
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			
		}while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM O " + candidato + " NA " + tentativasRealizadas + "° TENTATIVA.");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM O " + candidato + ", NÚMERO MÁXIMO TENTATIVAS REALIZADA (" + tentativasRealizadas + ")");
    }
    // método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;	
	}
    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n° " + (indice + 1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de intereção for each");
        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }
    static void seleçãoCandidatos() {
        // Array com a lista de candidatos
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA ","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " tem uma pretensão salarial de " + salarioPretendido);
            if(salarioBase > salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado!");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    // Método que simula o valor pretendido
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    } 
    static void analisarcandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O candidato COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS candidatoS");
        }
    }
}