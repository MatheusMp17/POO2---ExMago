public class Mago extends Personagem{
    private String tipoMagia;
    private int pontosMana;
    private int pontosManaAtuais;
    public Mago(String nome, int resistencia, int nivel, String tipoMagia){
        super(nome, resistencia, nivel);
        this.setPontosVidaMax((int) (getPontosVidaMax() * 0.75));
        this.setPontosMana(100);
        this.setTipoMagia(tipoMagia);
        this.setPontosVidaAtuais();
        this.setPontosManaAtuais(getPontosMana());
    }

    @Override
    public void setPontosVigor(int pontosVigor){
    }
    @Override
    public int getPontosVigor(){
        return 0;
    }
    @Override
    public void setPontosVigorAtuais(){
    }
    @Override
    public int getPontosVigorAtuais(){
        return 0;
    }
    @Override
    public void atacarComSoco(Personagem atacado) {
        int dano;
        dano = (10 * (int) (getNivel() * 0.2) ) - atacado.getResistencia();
        if(dano > 0 && pontosManaAtuais >= 5){
            atacado.alterarVida(dano, 1);
            System.out.println("Golpe Mágico!!!");
            alterarMana(10, 1);
        }
        else{
            System.out.println("Não possui forças para ferir seu adversario");
        }            
    }
    @Override
    public void alterarVigor(int alterarVigor, int tipo) {
    }
    @Override
    public void tomarPocao(int tipo) {
        switch (tipo) {
            case 1:
                alterarVida(30, 2);
                break;
            case 2:
                alterarMana(30, 2);
                break;
            default:
                break;
        }
    }
    @Override
    public void imprimirPesonagem(int tipo){
        switch (tipo) {
            case 1:
            System.out.println("\n" 
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
            +"    |_| |_|    ||");
            esperar();
                break;
            case 2:
                System.out.println("\n" 
            +"       /\\\n"
            +"      /  \\     /\\\n"
            +"   ----------  \\/\n"
            +"    ( o o )    ||\n"
            +"   ::::::::::  ||\n"
            +"  //|||||||\\\\  ||\n"
            +" // ||||||| \\\\ ||\n"
            +"||| |||||||  \\\\||\n"
            +"    | | | |    ||\n"
            +"    | | | |    ||\n"
            +"    |_| |_|    ||");
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
            default:
                break;
        }
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
        +"[2] Lançar magia ESPECIAL\n"
        +"[3] tomar poção de vida\n"
        +"[4] tomar poção de mana\n"
        +"[5] DESISTIR");
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
                    lancarMagiaPoderosa(possivelAlvo);
                    break;
                case "3":
                    tomarPocao(1);
                    break;
                case"4":
                    tomarPocao(2);
                    break;
                case "5":
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


    public void setTipoMagia(String tipoMagia){
        this.tipoMagia = tipoMagia;
    }
    public String getTipoMagia(){
        return this.tipoMagia;
    }
    public void setPontosMana(int pontosMana){
        if(pontosMana > 0 ){
            this.pontosMana = pontosMana;
        }
    }
    public int getPontosMana(){
        return this.pontosMana;
    }
    public void setPontosManaAtuais(int pontosMana){
        if(pontosMana > 0 && pontosMana <= getPontosMana()){
        this.pontosManaAtuais = pontosMana;
        }
        else if(pontosMana >= getPontosMana()){
            pontosManaAtuais = getPontosMana();
        }
    }
    public int getPontosManaAtuais(){
        return this.pontosManaAtuais;
    }

    public void alterarMana(int valor, int tipo){
        if(getPontosManaAtuais() - valor >= 0 && tipo == 1){
            setPontosManaAtuais(getPontosManaAtuais() - valor);
        }
        else 
            setPontosManaAtuais(0);
        if(getPontosManaAtuais() + valor <= getPontosMana() && tipo == 2){
            setPontosManaAtuais(getPontosVidaAtuais() + valor);
        }
        else
            setPontosManaAtuais(getPontosMana());
    }
    public void lancarMagia(Personagem alvo){
        int tipo;
        if(getPontosManaAtuais() > 10){
        System.out.println("Tipos de Magia:"
        +"\n[1] Magia Elemental"
        +"\n[2] Armadura Arcana");
        tipo = t.nextInt();
        System.out.println("Conjurando mágica...");
        System.out.println("..");
        System.out.println(".");
        esperar();
            switch (tipo) {
                case 1:
                    int dano = (30 * (int) (getNivel() * 0.2) ) - ((int)0.5 * alvo.getResistencia());
                    if(dano > 0){
                        alvo.alterarVida(dano, 1);
                        System.out.println("Raio de " + getTipoMagia());
                    }
                    break;
                case 2:
                        setResistencia(50);
                        System.out.println("Blindado magicamente");
                    break;        
            
                default:
                    break;
            }
            alterarMana(10, 1);
        }
        else
        System.out.println("PRECISO DE CAFÉ!!!");
    }
    private void lancarMagiaPoderosa(Personagem alvo){
        System.out.println("Conjurando mágica...");
        esperar();
        System.out.println("..");
        esperar();
        System.out.println(".");
        esperar();
        System.out.println("KABOOM!!!");
        alterarMana(getPontosManaAtuais(), 1);
        alterarVida(getPontosVidaMax(), 1);
        alvo.alterarVida(alvo.getPontosVidaAtuais(), 1);
    }

}