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
        int exp;
        Personagem hunter = new Personagem(nome, energia, fome, sono);

        do{
            int op;
            op = Integer.parseInt(JOptionPane.showInputDialog(null,"""
                    ---------------------------------------------------------
                        Menu Interativo do Sistema de Sobrevivente!
                    ----------------------------------------------------------
                    1 - Caçar ( + 1 XP, - 2 ENERGIA, + 1 FOME & SONO )
                    2 - Comer ( - 1 FOME, + 1 ENERGIA )
                    3 - Dormir ( - 1 SONO, + 1 ENERGIA )
                    4 - MostrarInformações
                    
                    Escolha uma opção:
                    """));
            
            switch(op){
                case 1:
                    hunter.cacar();
                    break;
                case 2:
                    hunter.comer();
                    break;
                case 3:
                    hunter.dormir();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,hunter);
                    String vazia = JOptionPane.showInputDialog(null,"Aperte Enter para retonar ao Menu!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Erro!. Opção inválida.");
                    vazia = JOptionPane.showInputDialog(null, """
                            Após retornar ao menu, selecione um número inteiro de 1 a 4
                            Para retornar ao menu, aperte Enter!""");
                    break;
            }

        }while(energia > 0 && sono <= 9 && fome <= 9);
    }
}