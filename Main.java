import java.util.*;
public class Main{
    private static String personagem;
    private static String personagem2;
    public static String personagem(){
        return personagem = "\n" 
+"       /\\\n"
+"      /  \\     /\\\n"
+"   ----------  \\/\n"
+"    ( o o )    ||\n"
+"   ::::::::::  ||\n"
+"  //|||||||\\\\  ||\n"
+" // ||||||| \\\\ ||\n"
+" || |||||||  \\\\||\n"
+"    | | | |    ||\n"
+"    | | | |    ||\n"
+"    |_| |_|    ||";
    }
    public static String personagem2(){
        return personagem2 = "\n"
        +""   
+"          (( /--\\ ))\n"
+"            /    \\\n"
+"            |o  o|     /\\\n"   
+"            \\ __ /     ||\n"
+"          ------------ ||\n" 
+"          //|||||||\\\\  ||\n"
+"         // ||||||| \\\\_||_\n"
+"    /\\/\\/\\  |||||||  \\\\||\n"
+"   |      | | | | |\n"
+"    \\    /  | | | |\n"
+"     \\__/   |_| |_|";
      }
    public static void main(String[] args) {
        String pausa = "";
        personagem2();
        boolean validade = false;
        int danoMago = 0;
        int danoGuerreiro = 0;
        int defesaGuerreiro = 0;
        String opcoes;
        boolean jogo = true;
        Scanner t = new Scanner(System.in);
        System.out.println(""
        +"---------------------\n"
        +" BEM VINDO À ARENA\n"
        +"    DE BATALHA\n"
        +"---------------------");
        t.nextLine();
        System.out.println(personagem());
        Mago mago1 = new Mago();
        System.out.print("Informe o nome de seu mago: ");
        mago1.setNome(t.nextLine());
        System.out.print("\nInforme o tipo de seu mago: ");
        mago1.setTipoMagia(t.nextLine());
        System.out.println();
        
        t.nextLine();
        
        System.out.println(personagem2);
        Guerreiro guerreiro1 = new Guerreiro();
        System.out.print("Informe o nome de seu guerreiro: ");
        guerreiro1.setNome(t.nextLine());
        System.out.println();

        while(jogo == true){
            System.out.println(personagem());
            System.out.println(""
            +"_______________________\n"
            +"-----------------------\n"
            +"Nome: " + mago1.getNome() + "\n"
            +"Tipo: " + mago1.getTipoMagia() + "\n"
            +"Vida: " + mago1.getPontosVidaAtuais() + "/" + mago1.getPontosVida() + "\n"
            +"Mana: " + mago1.getPontosManaAtuais() + "/" + mago1.getPontosMana());
            
            do{
                validade = false;
                System.out.println(""
                +"_______________________\n"
                +"AÇÕES: \n"
                +"[0] Lançar magia\n"
                +"[1] Lançar magia ESPECIAL\n"
                +"[2] curar\n"
                +"[3] recuperar Mana\n"
                +"[4] DESISTIR");
                
                opcoes = t.next();
                switch (opcoes) {
                    case "0":
                        System.out.print("\ninforme um número: ");
                        danoMago = mago1.lancarMagia(t.nextInt());
                        break;
                    case "1":
                        danoMago = mago1.lancarMagiaEspecial();
                        break;
                    case "2":
                        System.out.println("15 pontos de vida foram recuperados.");
                        mago1.alterarVida(15);
                        break;
                    case "3":
                    System.out.println("15 pontos de mana foram recuperados.");
                        mago1.alterarMana(15);
                        break;
                    case "4":
                        mago1.alterarVida(-mago1.getPontosVidaAtuais());
                        break;
                    default:
                        System.out.println("OPÇão INVÁLIDA!");
                        validade = true;
                }
            }while(validade);
            System.out.println("Precione enter.");
            t.nextLine();
            
            System.out.println(personagem2());
            System.out.println(""
            +"_______________________\n"
            +"-----------------------\n"
            +"Nome: " + guerreiro1.getNome() + "\n"
            +"Vida: " + guerreiro1.getPontosVidaAtuais() + "/" + guerreiro1.getPontosVida() + "\n"
            +"Mana: " +  guerreiro1.getPontosVigorAtuais() + "/" + guerreiro1.getPontosVigor());
            
            do{
                validade = false;
                System.out.println(""
                +"_______________________\n"
                +"AÇÕES: \n"
                +"[0] Ataque leve\n"
                +"[1] Ataque Pesado\n"
                +"[2] Defender\n"
                +"[3] curar\n"
                +"[4] recuperar Vigor\n"
                +"[5] DESISTIR");
                
                opcoes = t.next();
                switch (opcoes) {
                    case "0":
                        danoGuerreiro = guerreiro1.ataqueLeve();
                        break;
                    case "1":
                        danoGuerreiro = guerreiro1.ataquePesado();
                        break;
                    case "2":
                        defesaGuerreiro = guerreiro1.defender();
                        break;
                    case "3":
                        System.out.println("15 pontos de vida foram recuperados.");
                        guerreiro1.alterarVida(15);
                        break;
                    case "4":
                    System.out.println("15 pontos de mana foram recuperados.");
                        guerreiro1.alterarVigor(15);
                        break;
                    case "5":
                        guerreiro1.alterarVida(-guerreiro1.getPontosVidaAtuais());
                        break;
                    default:
                        System.out.println("OPÇão INVÁLIDA!");
                        validade = true;
                }
            }while(validade);
            if(defesaGuerreiro + danoMago < 0){
                danoMago += defesaGuerreiro;
                guerreiro1.alterarVida(danoMago);
            }
            mago1.alterarVida(danoGuerreiro);

            if(mago1.getPontosVidaAtuais() <= 0){
                System.out.println("O Mago " + mago1.getNome() + " foi derrotado!!!");
                jogo = false;
            }
            else if(guerreiro1.getPontosVidaAtuais() <=0){
                System.out.println("O Guerreiro " + guerreiro1.getNome() + " foi derrotado!!!");
            }
        }
    }
}