import java.util.*;
public class Main{
    public static void main(String[] args) {
        int turno = 1;
        String nome;
        boolean validade = false;
        int escolhaPj;
        String opcoes;
        boolean jogo = true;
        Personagem p1;
        Personagem p2;
        Scanner t = new Scanner(System.in);
        System.out.println(""
        +"---------------------\n"
        +" BEM VINDO À ARENA\n"
        +"    DE BATALHA\n"
        +"---------------------");
        t.nextLine();
        do{
            System.out.println("Jogador 1 escolha seu personagem:");
            System.out.print(""
            +"AÇÕES: \n"
            +"[1] Clérigo\n"
            +"[2] Guerreiro\n"
            +"[3] Mago\n");
            escolhaPj = t.nextInt();
            System.out.print("Qual é o nome de seu personagem: ");
            nome = t.next();
            p1 = new Personagem(nome, 10, 1);
            switch (escolhaPj) {
                case 1:
                    p1 = new Clerigo(nome, 20, 1, "Sacra");
                    break;
                case 2:
                    p1 = new Guerreiro(nome, 25, 1);
                    break;
                case 3:
                    p1 = new Mago(nome, 20, 1, "fogo");
                    break;
                default:
                    validade = false;
                    break;
            }
        }while(validade);
        t.nextLine();
        System.out.println();
       //selecao de personagem
       do{
            System.out.println("Jogador 2 escolha seu personagem:");
            System.out.print(""
            +"AÇÕES: \n"
            +"[1] Clérigo\n"
            +"[2] Guerreiro\n"
            +"[3] Mago\n");
            escolhaPj = t.nextInt();
            System.out.print("Qual é o nome de seu personagem: ");
            nome = t.next();
            p2 = new Personagem(nome, 10, 1);
            switch (escolhaPj) {
                case 1:
                    p2 = new Clerigo(nome, 20, 1, "Sacra");
                    break;
                case 2:
                    p2 = new Guerreiro(nome, 25, 1);
                    break;
                case 3:
                    p2 = new Mago(nome, 25, 1, "fogo");
                    break;
                default:
                    validade = false;
                    break;
            }
        }while(validade);
        while(jogo == true){
            p1.imprimirPesonagem(2);
            p1.agir(p2);
            p1.esperar();
            p2.imprimirPesonagem(2);
            p2.agir(p1);
            p2.esperar();
            if(p1.getPontosVidaAtuais() <= 0){
                System.out.println(p1.getNome() + " foi derrotado!!!");
                jogo = false;
            }
            if(p2.getPontosVidaAtuais() <=0){
                System.out.println(p2.getNome() + " foi derrotado!!!");
                jogo = false;
            }
            ++turno;
        }
    }
}