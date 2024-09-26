public class Clerigo extends Mago{

    public Clerigo(String nome, int resistencia, int nivel, String tipoMagia) {
        super(nome, resistencia, nivel, tipoMagia);
    }
    @Override
    public void agir(Personagem possivelAlvo){
        String acao;
        boolean validade = false;
        System.out.println(""
        +"_______________________\n"
        +"AÇÕES:\n"
        +"[0] atacar com soco\n"
        +"[1] Lançar magia\n"
        +"[2] tomar poção de vida\n"
        +"[3] tomar poção de mana\n"
        +"[4] DESISTIR");
        do{
            acao = t.nextLine();
            switch (acao) {
                case "0":
                    atacarComSoco(possivelAlvo);
                    break;
                case "1":
                    lancarMagia(possivelAlvo);
                    break;
                case "2":
                    tomarPocao(1);
                    break;
                case"3":
                    tomarPocao(2);
                    break;
                case "4":
                    alterarVida(getPontosVidaAtuais(), 1);
                    break;
                default:
                    System.out.println("inválido");
                    validade = true;
                    break;
            }
            esperar();
        }while(validade);
    }
    @Override
    public void imprimirPesonagem(int tipo) {
       System.out.println(""
        +"         -+-\n"
        +"       ___|___\n"
        +"      /       \\\n"
        +"     /         \\\n"
        +"    /  ()   ()  \\\n"
        +"    \\           /\n"
        +" _ _ \\====+====/ _ _\n"
        +"  /        _       \\\n"
        +" /     ___| |___    \\\n"
        +"/     |___   ___|    \\\n"
        +"\\    \\    | |    /   /\n"
        +" \\     \\  |_|  /    /\n"
        +"  -------------------- \n"
        +"  |+++++++++++++++++|\n"
        +"  //||||/    \\||||\\\\\n"
        +"    |||||    |||||    \n"
        +"    |||||    ||||| \n"
        +"    |||||    |||||");
        System.out.println(""
            +"         STATUS"
            +"\n--------------------------" 
            +"\nNome: " + getNome()
            +"\nNível: " + getNivel()
            +"\nTipo da Magia: " + getTipoMagia()
            +"\nVida: " + getPontosVidaAtuais() + "/" + getPontosVidaMax()
            +"\nMana: " + getPontosManaAtuais() + "/" + getPontosMana()
            +"\nResistência: " + getResistencia()
            +"\n--------------------------");
            esperar();
    }
@Override
public void lancarMagia(Personagem alvo) {
    int tipo;
        if(getPontosManaAtuais() > 10){
        System.out.println("Tipos de Magia:"
        +"\n[1] Raio Fulminante"
        +"\n[2] Curar Ferimentos");
        tipo = t.nextInt();
        System.out.println("Conjurando mágica...");
        esperar();
        System.out.println("..");
        esperar();
        System.out.println(".");
        esperar();
            switch (tipo) {
                case 1:
                    int dano = (30 * (int) (getNivel() * 0.2) ) - ((int)0.5 * alvo.getResistencia());
                    if(dano > 0){
                        alvo.alterarVida(dano, 1);
                        System.out.println("Raio Sagrado");
                    }
                    break;
                case 2:
                       alvo.alterarVida(50, 2);
                    break;        
                default:
                    System.out.println("Nada acontece.");
                    break;
            }
            alterarMana(10, 1);
        }
        else
            System.out.println("PRECISO DE REZAR MAIS!!!");
        esperar();
    }
}
