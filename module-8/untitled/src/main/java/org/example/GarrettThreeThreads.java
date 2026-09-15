// Garrett Woods Module 8

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GarrettThreeThreads extends JFrame {
    private JTextArea textArea;
    private static final int MIN_CHAR_COUNT = 10000;

    public GarrettThreeThreads() {

        setTitle("Three Thread Random Generator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendCharacter(char c) {
        SwingUtilities.invokeLater(() -> textArea.append(String.valueOf(c)));
    }

    public void threadGeneration() {

        Runnable pickLetter = new CharacterGenerator("abcdefghijklmnopqrstuvwxyz", MIN_CHAR_COUNT);
        Runnable pickNumber = new CharacterGenerator("0123456789", MIN_CHAR_COUNT);
        Runnable pickSymbol = new CharacterGenerator("!,@,#,$,%,&,*", MIN_CHAR_COUNT);


        Thread thread1 = new Thread(pickLetter, "PickLetter");
        Thread thread2 = new Thread(pickNumber, "PickNumber");
        Thread thread3 = new Thread(pickSymbol, "PickSymbol");

        thread1.start();
        thread2.start();
        thread3.start();
    }
    private class CharacterGenerator implements Runnable {
        private final String charPool;
        private final int totalCount;
        private final Random random;

        public CharacterGenerator(String charPool, int totalCount) {
            this.charPool = charPool;
            this.totalCount = totalCount;
            this.random = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < totalCount; i++) {
                int randomIndex = random.nextInt(charPool.length());
                char nextChar = charPool.charAt(randomIndex);

                appendCharacter(nextChar);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GarrettThreeThreads app = new GarrettThreeThreads();
            app.setVisible(true);
            app.threadGeneration();
        });
    }
}