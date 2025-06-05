import javax.swing.*;

public class Jogo {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Bem-vindo ao Desafio do Sobrevivente!");

        JOptionPane.showMessageDialog(null,"Seu objetivo é fazer com que seu personagem alcance 10 pontos de experiência.");
        JOptionPane.showMessageDialog(null,"Cuidado! O jogo termina se sua energia chegar a 0 ou se os níveis de fome e sono atingirem o limite (10).");
        JOptionPane.showMessageDialog(null,"Cada vez que você caçar, ganhará 1 ponto de experiência.");

        JOptionPane.showMessageDialog(null,"Gerencie bem seus recursos e boa sorte!");

        String nome = JOptionPane.showInputDialog(null,"Insira o nome do Personagem: ");
        int energia = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a Energia do Personagem (Recomendado 10): "));
        int fome = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a Fome do Personagem (Recomendado 0): "));
        int sono = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o Sono do Personagem (Recomendado 0): "));
        Personagem hunter = new Personagem(nome, energia, fome, sono);

        SwingUtilities.invokeLater(() -> {
            JogoGUI gui = new JogoGUI(hunter);
            gui.setVisible(true);
        });
    }
}