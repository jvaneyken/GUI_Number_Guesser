import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class Main extends JFrame implements ActionListener {

    private JLabel guessLabel;
    private JTextField guessField;
    private JButton higherButton;
    private JButton lowerButton;
    private JButton correctButton;
    private JButton resetButton;

    private NumberGuesser guesser;

    public Main() {
        // Used to specify GUI component layout
        GridBagConstraints positionConst = null;

        // Set frame's title
        setTitle("Number Guesser");

        // Create the display for the guess
        guessLabel = new JLabel("Is it?");

        guessField = new JTextField(15);
        guessField.setEditable(false);
        guessField.setText("0");

        // Create the buttons Lower, Higher, Corect, Restet
        lowerButton = new JButton("Lower");
        higherButton = new JButton("Higher");
        correctButton = new JButton("Correct");
        resetButton = new JButton("Reset");

        // Use "this" class to handle button presses
        lowerButton.addActionListener(this);
        higherButton.addActionListener(this);
        correctButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();

        // 10 pixels vert, 5 horizontal around components
        positionConst.insets = new Insets(10, 5, 10, 5);

        // Add component using the specified constraints
        positionConst.gridx = 0;
        positionConst.gridy = 0;
        add(guessLabel, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 0;
        add(guessField, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 0;
        add(resetButton, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 2;
        add(lowerButton, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 2;
        add(higherButton, positionConst);

        positionConst.gridx = 2;
        positionConst.gridy = 2;
        add(correctButton, positionConst);

        // Get Ready to play the game
        this.guesser = new RandomNumberGuesser(1, 100);
        this.guessField.setText("" + guesser.getCurrentGuess());
    }

    /*
     * Method is automatically called when a button is pressed
     *
     * It needs some work. The logic here doesn't play a guessing game. It just
     * provides some examples that you can use.
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        // buttonPressed will be initialized with a
        // reference to the button object that was pressed.
        // One of the four buttons: Higher, Lower, Correct, Reset
        Object buttonPressed = event.getSource();

        if (buttonPressed == this.lowerButton) {
            try {
                this.guesser.lower();
                this.guessField.setText(Integer.toString(guesser.getCurrentGuess()));
            } catch(NumberGuesserIllegalStateException exception) {

            }
        }

        if (buttonPressed == this.higherButton) {
            try {
                this.guesser.higher();
                this.guessField.setText(Integer.toString(guesser.getCurrentGuess()));
            } catch(NumberGuesserIllegalStateException exception) {

            }
        }

        if (buttonPressed == this.correctButton) {
            // Correct button was pressed
        }

        if (buttonPressed == this.resetButton) {
            this.guesser.reset();
            this.guessField.setText(Integer.toString(guesser.getCurrentGuess()));
            // I put this code in just to show how to open a JOptionPane

            // When the reset button is pressed the number guesser should
            // be reset. But you can use JOptionPane code like this to
            // notify the user if they are cheating in a catch block.

            // You should remove this line from this reset block
//            JOptionPane.showInternalMessageDialog(null,
//                    "Reset!",
//                    "Notice",
//                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Main myFrame = new Main();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}