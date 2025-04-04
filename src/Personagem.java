public class Personagem {
    private String nome;
    private int energia;
    private int fome;
    private int sono;

    public Personagem(String nome, int energia, int fome, int sono) {
        this.nome = nome;
        if(energia >= 0 && energia <= 10) {
            this.energia = energia;
        }if(fome >= 0 && fome <=10) {
            this.fome = fome;
        }if (sono >= 0 && sono <= 10) {
            this.sono = sono;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public int getSono() {
        return sono;
    }

    public void setSono(int sono) {
        this.sono = sono;
    }
    
}
