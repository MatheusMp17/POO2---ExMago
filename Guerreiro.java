public class Guerreiro {
    private int pontosVida;
    private int pontosVigor;
    private String nome;
    private int nivel;
    private int pontosVidaAtuais;
    private int pontosVigorAtuais;

    public Guerreiro(){
        this.setPontosVida(100);
        this.setPontosVigor(100);
        this.setNome("");
        this.setNivel(1);
        this.setPontosVidaAtuais();
        this.setPontosVigorAtuais();
    }

    public void setPontosVida(int pontosVida){
        this.pontosVida = pontosVida;
    }
    public int getPontosVida(){
        return this.pontosVida;
    }
    public void setPontosVigor(int pontosVigor){
        this.pontosVigor = pontosVigor;
    }
    public int getPontosVigor(){
        return pontosVigor;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
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
    public void setPontosVigorAtuais(){
        this.pontosVigorAtuais = this.pontosVigor;
    }
    public int getPontosVigorAtuais(){
        return this.pontosVigorAtuais;
    }

    public void alterarVida(int pontosVida){
        if (pontosVida + this.pontosVidaAtuais <= this.pontosVida){
            this.pontosVidaAtuais = pontosVida + this.pontosVidaAtuais;
        }
        else{
            System.out.println("Ação inválida");
        }
    }
    public void alterarVigor(int pontosVigor){
        if (pontosVigor + this.pontosVigorAtuais <= this.pontosVigor && pontosVigor + this.pontosVigorAtuais >= 0){
            this.pontosVigorAtuais += pontosVigor;
        }
        else{
            System.out.println("Ação inválida");
        }
    }
    
    public int ataqueLeve(){
        if(20 <= pontosVigorAtuais){
            pontosVigorAtuais -= 10;
            System.out.println("Ataque Leve");
            return -20;
        }
        else{
            System.out.println("Sem Vigor!!!");
            return 0;
        }
    }
    public int ataquePesado(){
        if(30 <= pontosVigorAtuais){
            pontosVigorAtuais -= 30;
            System.out.println("Ataque Pesado");
            return -30;
        }
        else{
            System.out.println("Sem Vigor!!!");
            return 0;
        }
    }
    public int defender(){
        if(10 <= pontosVigorAtuais){
            pontosVigorAtuais -= 10;
            System.out.println("Defesa");
            return 25;
        }
        else{
            System.out.println("Sem Vigor!!!");
            return 0;
        }
    }
}

