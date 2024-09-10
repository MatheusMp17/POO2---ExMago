import java.util.*;
public class Main{
    private static String personagem;
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
    public static void main(String[] args) {
        String opcoes;
        boolean jogo = true;
        Scanner t = new Scanner(System.in);
        System.out.println(personagem());
        Mago mago1 = new Mago();
        System.out.print("Informe o nome de seu mago: ");
        mago1.setNome(t.nextLine());
        System.out.print("\nInforme o tipo de seu mago: ");
        mago1.setTipoMagia(t.nextLine());

        while(jogo == true){
            System.out.println(personagem());
            System.out.println(""
            +"_______________________\n"
            +"-----------------------\n"
            +"Nome: " + mago1.getNome() + "\n"
            +"Tipo: " + mago1.getTipoMagia() + "\n"
            +"Vida: " + mago1.getPontosVidaAtuais() + "/" + mago1.getPontosVida() + "\n"
            +"Mana: " +  mago1.getPontosManaAtuais() + "/" + mago1.getPontosMana());
            System.out.println(""
            +"_______________________\n"
            +"AÇÕES: \n"
            +"[0] Lançar magia\n"
            +"[1] Lançar magia ESPECIAL\n"
            +"[2] Alterar vida\n"
            +"[3] Alterar Mana\n"
            +"[4] DESISTIR");
            
            opcoes = t.next();
            switch (opcoes) {
                case "0":
                    System.out.print("\ninforme um número: ");
                    mago1.lancarMagia(t.nextInt());
                    break;
                case "1":
                    mago1.lancarMagiaEspecial();
                    break;
                case "2":
                    System.out.print("\nInforme um número: ");
                    mago1.alterarVida(t.nextInt());
                    break;
                case "3":
                    System.out.print("\nInforme um número: ");
                    mago1.alterarMana(t.nextInt());
                    break;
                case "4":
                    jogo = false;
                    break;
                default:
                    System.out.println("OPÇão INVÁLIDA!");
            }
            System.out.println("Precione qualquer tecla.");
            String pausa = t.next();
            if(mago1.getPontosVidaAtuais() == 0){
                System.out.println("Fim de jogo Aventureiro!!!");
                jogo = false;
            }
        }
    }
}