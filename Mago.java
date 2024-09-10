public class Mago {
    private int pontosVida;
    private int pontosMana;
    private String nome;
    private String tipoMagia;
    private int nivel;
    private int pontosVidaAtuais;
    private int pontosManaAtuais;

    public Mago(){
        this.setPontosVida(100);
        this.setPontosMana(100);
        this.setNome("");
        this.setTipoMagia("");
        this.setNivel(1);
        this.setPontosVidaAtuais();
        this.setPontosManaAtuais();
    }

    public void setPontosVida(int pontosVida){
        this.pontosVida = pontosVida;
    }
    public int getPontosVida(){
        return this.pontosVida;
    }
    public void setPontosMana(int pontosMana){
        this.pontosMana = pontosMana;
    }
    public int getPontosMana(){
        return(pontosMana);
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setTipoMagia(String tipoMagia){
        this.tipoMagia = tipoMagia;
    }
    public String getTipoMagia(){
        return tipoMagia;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public int getNivel(){
        return nivel;
    }
    public void setPontosVidaAtuais(){
        this.pontosVidaAtuais = this.pontosVida;
    }
    public int getPontosVidaAtuais(){
        return pontosVidaAtuais;
    }
    public void setPontosManaAtuais(){
        this.pontosManaAtuais = this.pontosMana;
    }
    public int getPontosManaAtuais(){
        return this.pontosManaAtuais;
    }

    public void lancarMagia(int feitico){
        if(pontosManaAtuais >= 4){
            switch (feitico) {
                case 1:
                System.out.println("Bola de Fogo"); 
                    break;
                case 2:
                    System.out.println("Relâmpago"); 
                    break;
                case 3:
                    System.out.println("Invocar Esqueletos");
                    break;
                case 4:
                    System.out.println("Conjurar Familiar");
                    break;
                case 5:
                    System.out.println("Queda Suave");
                    break;
                case 6:
                    System.out.println("Armadura Arcana");
                default:
                    System.out.println("Muito bem! agora estou azul!!!");
            }
            pontosManaAtuais -= 4;
        }
        else{
            System.out.println("EU PRECISO DE CAFÉ!!!");
        }
    }
    public void lancarMagiaEspecial(){
        if(pontosManaAtuais >= 30){
            System.out.println("Chuva de Meteoros");
            pontosManaAtuais -= 30;
        }
        else{
            this.pontosVidaAtuais -= this.pontosVidaAtuais;	
        }
    }
    public void alterarVida(int pontosVida){
        if (pontosVida + this.pontosVidaAtuais <= this.pontosVida){
            this.pontosVidaAtuais = pontosVida + this.pontosVidaAtuais;
            System.out.println("pontos de vida atuais: " + getPontosVidaAtuais());
        }
        else{
            System.out.println("Ação inválida");
        }
    }
    public void alterarMana(int pontosMana){
        if (pontosMana + this.pontosManaAtuais <= this.pontosMana && pontosMana + this.pontosManaAtuais >= 0){
            this.pontosManaAtuais += pontosMana;
            System.out.println("pontos de mana: " + pontosManaAtuais);
        }
        else{
            System.out.println("Ação inválida");
        }
    }
}

