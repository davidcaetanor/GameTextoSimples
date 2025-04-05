import javax.swing.*;

public class Personagem {
    private String nome;
    private int energia;
    private int fome;
    private int sono;
    private int xp;

    public Personagem(String nome, int energia, int fome, int sono) {
        this.nome = nome;
        this.xp = 0;

        if(energia >= 0 && energia <= 10) {
            this.energia = energia;
        } if(fome >= 0 && fome <= 10) {
            this.fome = fome;
        } if(sono >= 0 && sono <= 10) {
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    void cacar() {
        if(energia >= 2) {
            JOptionPane.showMessageDialog(null, getNome() + " está caçando...");
            JOptionPane.showMessageDialog(null, "Caçada concluída com Sucesso!");
            energia -=2;
            xp += 1;
        } else {
            JOptionPane.showMessageDialog(null, getNome() + " está cansado demais para caçar...");
        }
        fome = Math.min(fome + 1, 10);
        sono = Math.min(sono + 1, 10);
    }

    void comer() {
        if(fome >= 1) {
            JOptionPane.showMessageDialog(null, getNome() + " está comendo..");
            JOptionPane.showMessageDialog(null, "Refeição concluída com êxito.");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            JOptionPane.showMessageDialog(null, getNome() + " está sem fome.");
        }
    }

    void dormir() {
        if (sono >= 1) {
            JOptionPane.showMessageDialog(null, getNome() + " está dormindo...");
            JOptionPane.showMessageDialog(null, "BOM DIA! " + getNome() + " acordou");
            sono--;
            energia = Math.min(energia + 1, 10);
        } else {
            JOptionPane.showMessageDialog(null, getNome() + " está sem sono.");
        }
    }

    public String toString() {
        return String.format("""
                -------------------------------------------------------------
                    Informações detalhadas do Personagem
                -------------------------------------------------------------
               
                    Nome: %s
                    Energia: %d
                    Fome: %d
                    Sono: %d
                    Experiencia: %d
                """, getNome(), getEnergia(), getFome(), getSono(), getXp());
    }
    
}
