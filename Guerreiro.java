public class Guerreiro extends Personagem{

    public Guerreiro(String nome, int resistencia, int nivel){
        super(nome, resistencia, nivel);
        this.setPontosVida(100);
        this.setPontosVigor(100);
        this.setNome("");
        this.setNivel(1);
        this.setPontosVidaAtuais();
        this.setPontosVigorAtuais();
    }
    public void agir(Personagem possivelAlvo){
        String acao;
        boolean validade = false;
        System.out.println(""
        +"_______________________\n"
        +"AÇÕES:\n"
        +"[0] atacar com soco\n"
        +"[1] Ataque leve\n"
        +"[2] Ataque Pesado\n"
        +"[3] Defender\n"
        +"[4] tomar poção de vida\n"
        +"[5] tomar poção de vigor\n"
        +"[6] DESISTIR");
        do{
            acao = t.nextLine();
            switch (acao) {
                case "0":
                    atacarComSoco(possivelAlvo);
                    break;
                case "1":
                    ataqueLeve(possivelAlvo);
                    break;
                case "2":
                    ataquePesado(possivelAlvo);
                    break;
                case "3":
                    defender();
                    break;
                case "4":
                    tomarPocao(1);
                    break;
                case"5":
                    tomarPocao(2);
                    break;
                case "6":
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
+"     \\__/   |_| |_|");
        super.imprimirPesonagem(tipo);
    }

    public void ataqueLeve(Personagem alvo){
        int dano = (int) (20 * (getNivel() * 0.5) * 2 ) - alvo.getResistencia(); 
        alterarVigor(20, 1);
        if(20 <= getPontosVigorAtuais() && dano > 0){
            System.out.println("Ataque Leve");
            alvo.alterarVida(dano, 1);
        }
        else{
            System.out.println("Sem Força!!!");
        }
    }
    public void ataquePesado(Personagem alvo){
        if(30 <= getPontosVigorAtuais()){
            int dano = (int) (20 * 2 ) - alvo.getResistencia();
            alterarVigor(30, 1);
            if(dano > 0){;
                alvo.alterarVida(dano, 1);
                System.out.println("Ataque Pesado");
            }
        }
        else{
            System.out.println("Sem Vigor!!!");
        }
    }
    public void defender(){
        if(10 <= getPontosVigorAtuais()){
            alterarVigor(10, 1);;
            System.out.println("Defesa");
            setResistencia(60);
        }
        else{
            System.out.println("Sem Vigor!!!");
        }
    }
}

