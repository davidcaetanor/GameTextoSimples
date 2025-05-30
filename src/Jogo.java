import javax.swing.*;
import static java.lang.System.exit;

public class Jogo {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Desafio do Sobrevivente!\n" +
                "Seu objetivo é fazer com que seu personagem alcance 10 pontos de experiência.\n" +
                "Cuidado! O jogo termina se sua energia chegar a 0 ou se os níveis de fome e sono atingirem o limite (10).\n" +
                "Cada vez que você caçar, ganhará 1 ponto de experiência.\n" +
                "Gerencie bem seus recursos e boa sorte!");

        String nome;
        do {
            nome = JOptionPane.showInputDialog(null, "Insira o nome do Personagem: ");
            if (nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: O nome não pode ser vazio. Por favor, insira um nome válido.");
            }
        } while (nome.trim().isEmpty());

        int energia = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a Energia do Personagem (Recomendado 10): "));
        if (energia <= 0) {
            JOptionPane.showMessageDialog(null, "VOCE PERDEU!\nMOTIVO: MUITO CANSAÇO");
            exit(403);
        }

        int fome = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a Fome do Personagem (Recomendado 0): "));
        if (fome == 10) {
            JOptionPane.showMessageDialog(null, "VOCE PERDEU!\nMOTIVO: MUITA FOME");
            exit(403);
        }

        int sono = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Sono do Personagem (Recomendado 0): "));
        if (sono == 10) {
            JOptionPane.showMessageDialog(null, "VOCE PERDEU!\nMOTIVO: MUITO SONO");
            exit(403);
        }

        Personagem hunter = new Personagem(nome, energia, fome, sono);
        int exp;
        String vazia;

        do {
            int op;
            op = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    ---------------------------------------------------------
                        Menu Interativo do Sistema de Sobrevivente!
                    ----------------------------------------------------------
                    1 - Caçar ( + 1 XP, - 2 ENERGIA, + 1 FOME & SONO )
                    2 - Comer ( - 1 FOME, + 1 ENERGIA )
                    3 - Dormir ( - 1 SONO, + 1 ENERGIA )
                    4 - MostrarInformações
                    
                    Escolha uma opção:
                    """));

            if (op == 777) {
                int cheat;
                JOptionPane.showMessageDialog(null, "Cheat Mode ON");
                int opcheat = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    ---------------------------------------------------------
                                    Menu Cheat do Sistema
                    ----------------------------------------------------------
                    1 - Alterar a Energia
                    2 - Alterar a Fome
                    3 - Alterar o Sono
                    4 - Alterar o XP
                    5 - Alterar o Nome
                    Escolha uma opção:
                    """));

                switch(opcheat) {
                    case 1:
                        cheat = Integer.parseInt(JOptionPane.showInputDialog(null, "ENERGIA SERÁ ALTERADA\nEssa é sua ENERGIA atual: "+hunter.getEnergia()+"\nInforme o valor desejado: "));
                        hunter.setEnergia(cheat);
                        break;
                    case 2:
                        cheat = Integer.parseInt(JOptionPane.showInputDialog(null, "FOME SERÁ ALTERADA\nEssa é sua FOME atual: " + hunter.getFome() + "\nInforme o valor desejado: "));
                        hunter.setFome(cheat);
                        break;
                    case 3:
                        cheat = Integer.parseInt(JOptionPane.showInputDialog(null, "SONO SERÁ ALTERADO\nEsse é seu SONO atual: " + hunter.getSono() + "\nInforme o valor desejado: "));
                        hunter.setSono(cheat);
                        break;
                    case 4:
                        cheat = Integer.parseInt(JOptionPane.showInputDialog(null, "XP SERÁ ALTERADO\nEsse é seu XP atual: " + hunter.getXp() + "\nInforme o valor desejado: "));
                        hunter.setXp(cheat);
                        break;
                    case 5:
                        nome = JOptionPane.showInputDialog(null, "NOME SERÁ ALTERADO\nEsse é seu NOME atual: " + hunter.getNome() + "\nDigite o novo nome: ");
                        hunter.setNome(nome);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } else {
                switch(op) {
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
                        JOptionPane.showMessageDialog(null, hunter);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Erro!. Opção inválida.");
                        vazia = JOptionPane.showInputDialog(null, """
                            Após retornar ao menu, selecione um número inteiro de 1 a 4
                            Para retornar ao menu, aperte Enter!
                            """);
                        break;
                }
            }

        } while(hunter.getEnergia() > 0 && hunter.getSono() < 10 && hunter.getFome() < 10 && hunter.getXp() < 10);
        
        if (hunter.getXp() == 10) {
            JOptionPane.showMessageDialog(null, "PARABÉNS, VOCE GANHOU!\nALCANÇOU O NIVEL NECESSÁRIO DE EXPERIENCIA E SUBIU DE NIVEL");
        } else if (hunter.getSono() == 10) {
            JOptionPane.showMessageDialog(null, "VOCE PERDEU!\nMOTIVO: MUITO SONO");
        } else if (hunter.getFome() == 10) {
            JOptionPane.showMessageDialog(null, "VOCE PERDEU!\nMOTIVO: MUITA FOME");
        } else {
            JOptionPane.showMessageDialog(null, "VOCE PERDEU!\nMOTIVO: MUITO CANSAÇO");
        }

        vazia = JOptionPane.showInputDialog(null, hunter.toString() + "\nAperte enter para encerrar o programa!");
        JOptionPane.showMessageDialog(null, "FIM DE JOGO!\nObrigado por Jogar.");
    }
}