public class Personagem {
    private String nome;
    private int energia;
    private int fome;
    private int sono;
    private int experiencia;

    public Personagem(String nome, int energia, int fome, int sono) {
        this.nome = nome;
        if (energia >= 0 && energia <= 10) {
            this.energia = energia;
        }
        if (fome >= 0 && fome <= 10) {
            this.fome = fome;
        }
        if (sono >= 0 && sono <= 10) {
            this.sono = sono;
        }
        this.experiencia = 0;
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

    public int getExperiencia() {
        return experiencia;
    }

    public boolean cacar() {
        if (energia >= 2 && fome < 10 && sono < 10) {
            energia -= 2;
            fome = Math.min(10, fome + 1);
            sono = Math.min(10, sono + 1);
            experiencia = Math.min(10, experiencia + 1);
            return true;
        }
        return false;
    }

    public boolean comer() {
        if (fome >= 1) {
            fome -= 1;
            if (energia < 10) {
                energia += 1;
            }
            return true;
        }
        return false;
    }

    public boolean dormir() {
        if (sono >= 1) {
            sono -= 1;
            if (energia < 10) {
                energia += 1;
            }
            return true;
        }
        return false;
    }

    public boolean perdeu() {
        return energia <= 0 || fome >= 10 || sono >= 10;
    }

    public boolean venceu() {
        return experiencia >= 10 && !perdeu();
    }
}
