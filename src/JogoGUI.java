import javax.swing.*;
import java.awt.*;

public class JogoGUI extends JFrame {
    private final Personagem personagem;
    private final JProgressBar energiaBar;
    private final JProgressBar fomeBar;
    private final JProgressBar sonoBar;
    private final JProgressBar xpBar;
    private final JButton cacarBtn;
    private final JButton comerBtn;
    private final JButton dormirBtn;

    public JogoGUI(Personagem personagem) {
        this.personagem = personagem;
        setTitle("Jogo de Sobreviv\u00eancia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel nomeLabel = new JLabel("Personagem: " + personagem.getNome());
        nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        energiaBar = createBar("Energia", personagem.getEnergia());
        fomeBar = createBar("Fome", personagem.getFome());
        sonoBar = createBar("Sono", personagem.getSono());
        xpBar = createBar("Experi\u00eancia", personagem.getExperiencia());

        JPanel statusPanel = new JPanel(new GridLayout(5, 1));
        statusPanel.add(nomeLabel);
        statusPanel.add(energiaBar);
        statusPanel.add(fomeBar);
        statusPanel.add(sonoBar);
        statusPanel.add(xpBar);

        cacarBtn = new JButton("Ca\u00e7ar");
        comerBtn = new JButton("Comer");
        dormirBtn = new JButton("Dormir");

        JPanel actionPanel = new JPanel();
        actionPanel.add(cacarBtn);
        actionPanel.add(comerBtn);
        actionPanel.add(dormirBtn);

        add(statusPanel, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        cacarBtn.addActionListener(e -> {
            if (personagem.cacar()) {
                updateStatus();
                checkFimDeJogo();
            }
        });

        comerBtn.addActionListener(e -> {
            if (personagem.comer()) {
                updateStatus();
            }
        });

        dormirBtn.addActionListener(e -> {
            if (personagem.dormir()) {
                updateStatus();
            }
        });
    }

    private JProgressBar createBar(String titulo, int valor) {
        JProgressBar bar = new JProgressBar(0, 10);
        bar.setValue(valor);
        bar.setStringPainted(true);
        bar.setBorder(BorderFactory.createTitledBorder(titulo));
        return bar;
    }

    private void updateStatus() {
        energiaBar.setValue(personagem.getEnergia());
        fomeBar.setValue(personagem.getFome());
        sonoBar.setValue(personagem.getSono());
        xpBar.setValue(personagem.getExperiencia());
    }

    private void checkFimDeJogo() {
        if (personagem.venceu()) {
            JOptionPane.showMessageDialog(this, "Parab\u00e9ns! Voc\u00ea venceu!");
            disableButtons();
        } else if (personagem.perdeu()) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea perdeu!");
            disableButtons();
        }
    }

    private void disableButtons() {
        cacarBtn.setEnabled(false);
        comerBtn.setEnabled(false);
        dormirBtn.setEnabled(false);
    }
}
