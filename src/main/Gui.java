package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame {
    private static final long serialVersionUID = 1L;

    String currentSpecial = "Dashes";

    JPanel wholeThing = new JPanel(new BorderLayout());
    JPanel menuPanel = new JPanel(new FlowLayout());
    JPanel contentPanel = new JPanel(new GridLayout(4, 2));

    JLabel specialLabel = new JLabel("Rule");
    String[] specialChoices = { "None", "Dashes", "Any" };
    JComboBox<String> special = new JComboBox<>(specialChoices);

    JLabel lengthLabel = new JLabel("Length");
    String[] lengthChoices = { "8", "10", "12", "16", "20", "22", "24" };
    String[] dashLengthChoices = { "9", "13", "14", "18", "19", "20", "24" };
    JComboBox<String> length = new JComboBox<>(dashLengthChoices);

    JButton fillButton = new JButton("Fill");

    public static void main(String[] args) {
        new Gui();
    }

    Gui() {
        super("pwGen");
        setSize(440, 200);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - this.getWidth()) / 2,
                (screenSize.height - this.getHeight()) / 2);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuPanel.add(specialLabel);
        special.setSelectedItem(currentSpecial);
        length.setSelectedItem("19");
        special.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!special.getSelectedItem().equals(currentSpecial)) {
                    currentSpecial = (String) special.getSelectedItem();
                    length.removeAllItems();
                    if (currentSpecial.equals("Dashes")) {
                        for (String s : dashLengthChoices) {
                            length.addItem(s);
                        }
                        length.setSelectedItem("19");
                    } else {
                        for (String s : lengthChoices) {
                            length.addItem(s);
                        }
                        length.setSelectedItem("16");
                    }
                }
            }
        });
        fillButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.removeAll();
                for (int i = 0; i < 8; i++) {
                    contentPanel.add(new JTextField(
                            fill((String) special.getSelectedItem(),
                                    Integer.parseInt((String) length
                                            .getSelectedItem()))));
                }
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        menuPanel.add(special);
        menuPanel.add(lengthLabel);
        menuPanel.add(length);
        menuPanel.add(fillButton);
        for (int i = 0; i < 8; i++) {
            contentPanel.add(new JTextField());
        }
        wholeThing.add(menuPanel, BorderLayout.NORTH);
        wholeThing.add(contentPanel, BorderLayout.CENTER);
        add(wholeThing);
        setVisible(true);
    }

    public static String fill(String special, int length) {
        Generator gen;
        if (special.equals("Dashes")) {
            gen = new Generator(true, false);
        } else {
            gen = new Generator(false, special.equals("Any"));
        }
        return gen.createPW(length);
    }
}
