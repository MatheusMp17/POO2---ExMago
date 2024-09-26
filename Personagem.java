import java.util.Scanner;
import java.util.concurrent.*;
public class Personagem {
    public Scanner t = new Scanner(System.in);
    private String nome;
    private int pontosVidaMax;
    private int pontosVigor;
    private int nivel;
    private int pontosVidaAtuais;
    private int pontosVigorAtuais;
    private int resistencia;
    private int resistenciaAbsoluta;
    public Personagem(String nome, int resistencia, int nivel){
        this.setPontosVidaMax(100);
        this.setPontosVigor(100);
        this.setNome(nome);
        this.setNivel(nivel);
        this.setPontosVidaAtuais();
        this.setPontosVigorAtuais();
        this.setResistencia(resistencia);
        this.setResistenciaAbsoluta(resistencia);
    }

    public void setPontosVidaMax(int pontosVida){
        this.pontosVidaMax = pontosVida;
    }
    public int getPontosVidaMax(){
        return this.pontosVidaMax;
    }
    public void setResistencia(int resistencia){
        this.resistencia = resistencia * (int) (nivel * 0.5);
    }
    public int getResistencia(){
        return this.resistencia;
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
        this.pontosVidaAtuais = this.pontosVidaMax;
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
    public void setResistenciaAbsoluta(int resistenciaAbsoluta){
        this.resistenciaAbsoluta = resistenciaAbsoluta;
    }
    public int getResistenciaAbsoluta(){
        return this.resistenciaAbsoluta;
    }

    protected void alterarVida(int alterarVida, int tipo){
        if(getPontosVidaAtuais() - alterarVida >= 0 && tipo == 1){
            this.pontosVidaAtuais = getPontosVidaAtuais() - alterarVida;
        }
        else if((getPontosVidaAtuais() - alterarVida < 0 && tipo == 1)){
            this.pontosVidaAtuais = 0;}
        else if(getPontosVidaAtuais() + alterarVida <= getPontosVidaMax() && tipo == 2){
            this.pontosVidaAtuais = getPontosVidaAtuais() + alterarVida;
        }
        else{
            this.pontosVidaAtuais = getPontosVidaMax();}
    }

    protected void alterarVigor(int alterarVigor, int tipo){
        if(getPontosVigorAtuais() - alterarVigor >= 0 && tipo == 1){
            pontosVigorAtuais = getPontosVigorAtuais() - alterarVigor;
        }
        if(getPontosVigorAtuais() + alterarVigor <= getPontosVigor() && tipo == 2){
            pontosVigorAtuais = getPontosVigorAtuais() + alterarVigor;
        }
    }

    public void atacarComSoco(Personagem atacado){
        int dano;
        dano = (20 * (int) (getNivel() * 0.2) ) - atacado.getResistencia();
        if(dano > 0 && pontosVigorAtuais >= 10){
            atacado.alterarVida(dano, 1);
            System.out.println("Acertou!!!");
            alterarVigor(10, 1);
        }
        else{
            System.out.println("Não possui forças para ferir seu adversario");
        }            
    }

    public void tomarPocao(int tipo){
        switch (tipo) {
            case 1:
                alterarVida(30, 2);
                break;
            case 2:
                alterarVigor(30, 2);
                break;
            default:
                break;
        }
    }
    
    public void esperar(){
        t.nextLine();
        //TimeUnit.SECONDS.sleep(2000);
    }
    public void passarTurno(Personagem personagem){
        setResistencia(getResistenciaAbsoluta() - 5);
    }

    public void imprimirPesonagem(int tipo){
            System.out.println(""
        +"         STATUS"
        +"\n--------------------------" 
        +"\nNome: " + getNome()
        +"\nNível: " + getNivel()
        +"\nVida: " + getPontosVidaAtuais() + "/" + getPontosVidaMax()
        +"\nVigor: " + getPontosVigorAtuais() + "/" + getPontosVigor()
        +"\nResistência: " + getResistencia()
        +"\n--------------------------");
        esperar();
    }
    public void agir(Personagem possivelAlvo){
        String acao;
        boolean validade = false;
        System.out.println(""
        +"_______________________\n"
        +"AÇÕES:\n"
        +"[0] atacar com soco\n"
        +"[1] tomar poção de vida\n"
        +"[2] tomar poção de vigor\n"
        +"[3] DESISTIR");
        do{
            acao = t.nextLine();
            switch (acao) {
                case "0":
                    atacarComSoco(possivelAlvo);
                    break;
                case "1":
                    tomarPocao(1);
                    break;
                case"2":
                    tomarPocao(2);
                    break;
                case "3":
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
}
