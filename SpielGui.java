import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpielGui extends JFrame implements ActionListener, ChangeListener {
    private JPanel controler, placehoderNorth, placehoderWest;
    private JTextArea output;
    private JButton right, left, up, down, clear, load, create, one, two, three, four, ex;
    private Font font, fontLarge, fontSmall;
    private JSlider fontSize;
    private JLabel fontSizeLabel;
    private JScrollPane scroll;
    private String fontStyle;
    private ImageLoader image;
    private static Spiel spiel;
    private static SpielGui spielGui;
    
    public static SpielGui getSpielGui()
    {
        if(spielGui == null)
        {
            spielGui = new SpielGui();
        }

        return spielGui;
    }

    public SpielGui() {
        spiel = new Spiel();

        Image icon = new ImageIcon("res\\icon.png").getImage();
        //Image cursorImage = new ImageIcon("res\\cursor.png").getImage();
        //Point hotspot = new Point(0, 0);
        //String cursorName = "customCursor";
        //setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));

        fontStyle = new String("Arial");
        font = new Font(fontStyle, 12, 17);
        fontLarge = new Font(fontStyle, 12, 28);
        fontSmall = new Font(fontStyle, 12, 10);

        Dimension minDim = new Dimension(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(minDim);
        setSize(1, 1);
        setTitle("Build 07-13-21_10-00");
        setIconImage(icon);

        controler = new JPanel();
        controler.setBackground(Color.WHITE);
        controler.setPreferredSize(new Dimension(69420, 200));
        controler.setLayout(null);
        controler.setVisible(true);

        output = new JTextArea();
        output.setFont(font);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setText("");     
        output.setVisible(true);

        scroll = new JScrollPane(output);
        scroll.setAutoscrolls(true);
        scroll.setVisible(true);

        placehoderNorth = new JPanel();
        placehoderNorth.setPreferredSize(new Dimension(0, 10));
        placehoderNorth.setBackground(Color.WHITE);
        placehoderNorth.setVisible(true);
        placehoderWest = new JPanel();
        placehoderWest.setPreferredSize(new Dimension(10, 0));
        placehoderWest.setBackground(Color.WHITE);
        placehoderWest.setVisible(true);

        right = new JButton();
        right.setFont(font);
        right.setText(">");
        right.setFocusable(false);
        right.addActionListener(this);
        right.setBounds(130, 70, 50, 50);
        right.setVisible(true);

        left = new JButton();
        left.setFont(font);
        left.setText("<");
        left.setFocusable(false);
        left.addActionListener(this);
        left.setBounds(10, 70, 50, 50);
        left.setVisible(true);

        up = new JButton();
        up.setFont(new Font(fontStyle, 12, 21));
        up.setText("^");
        up.setFocusable(false);
        up.addActionListener(this);
        up.setBounds(70, 10, 50, 50);
        up.setVisible(true);

        down = new JButton();
        down.setFont(font);
        down.setText("v");
        down.setFocusable(false);
        down.addActionListener(this);
        down.setBounds(70, 130, 50, 50);
        down.setVisible(true);

        ex = new JButton();
        ex.setFont(font);
        ex.setText("X");
        ex.setFocusable(false);
        ex.addActionListener(this);
        ex.setBounds(70, 70, 50, 50);
        ex.setVisible(true);

        clear = new JButton();
        clear.setFont(font);
        clear.setText("Textausgabe leeren");
        clear.setFocusable(false);
        clear.addActionListener(this);
        clear.setBounds(550, 10, 230, 50);
        clear.setVisible(true);

        load = new JButton();
        load.setFont(font);
        load.setText("Spieler laden");
        load.setFocusable(false);
        load.addActionListener(this);
        load.setBounds(550, 70, 230, 50);
        load.setVisible(true);

        create = new JButton();
        create.setFont(font);
        create.setText("Spieler erstellen");
        create.setFocusable(false);
        create.addActionListener(this);
        create.setBounds(550, 130, 230, 50);
        create.setVisible(true);

        one = new JButton();
        one.setFont(font);
        one.setText("1");
        one.setFocusable(false);
        one.addActionListener(this);
        one.setBounds(250, 10, 50, 50);
        one.setVisible(true);

        two = new JButton();
        two.setFont(font);
        two.setText("2");
        two.setFocusable(false);
        two.addActionListener(this);
        two.setBounds(310, 10, 50, 50);
        two.setVisible(true);

        three = new JButton();
        three.setFont(font);
        three.setText("3");
        three.setFocusable(false);
        three.addActionListener(this);
        three.setBounds(370, 10, 50, 50);
        three.setVisible(true);

        four = new JButton();
        four.setFont(font);
        four.setText("4");
        four.setFocusable(false);
        four.addActionListener(this);
        four.setBounds(430, 10, 50, 50);
        four.setVisible(true);

        fontSize = new JSlider(0, 2, 1);
        fontSize.setBounds(250, 130, 230, 50);
        fontSize.setPaintTicks(true);
        fontSize.setMajorTickSpacing(1);
        fontSize.setSnapToTicks(true);
        fontSize.setBackground(Color.WHITE);
        fontSize.addChangeListener(this);
        fontSize.setVisible(true);

        fontSizeLabel = new JLabel();
        fontSizeLabel.setText("Schriftgröße:");
        fontSizeLabel.setFont(font);
        fontSizeLabel.setBounds(250, 85, 230, 50);
        fontSizeLabel.setHorizontalAlignment(JLabel.CENTER);
        fontSizeLabel.setVisible(true);

        image = new ImageLoader();

        controler.add(right);
        controler.add(left);
        controler.add(up);
        controler.add(down);
        controler.add(clear);
        controler.add(load);
        controler.add(create);
        controler.add(one);
        controler.add(two);
        controler.add(three);
        controler.add(four);
        controler.add(ex);
        controler.add(fontSize);
        controler.add(fontSizeLabel);

        add(placehoderNorth, BorderLayout.NORTH);
        add(placehoderWest, BorderLayout.WEST);
        add(image, BorderLayout.EAST);
        add(controler, BorderLayout.SOUTH);
        add(scroll);
    }

    public void print(String text) {
        output.append(text);
    }

    public void printOverwrite(String text) {
        output.setText(text);
    }

    public void schliesseFenster() {
        dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            output.setText("");
        } else if (e.getSource() == up) {
            if (spiel.checkIfPossible(Konstanten.NORDEN))
            {
                spiel.bewegeNach(Konstanten.NORDEN);
                spiel.starteSpiel(spiel.getAktuelleHoehle());
            }
            output.setText("Keine Bewegung in diese Richtung möglich!");
        } else if (e.getSource() == down) {
            if (spiel.checkIfPossible(Konstanten.NORDEN))
            {
                spiel.bewegeNach(Konstanten.SUEDEN);
                spiel.starteSpiel(spiel.getAktuelleHoehle());
            }
            output.setText("Keine Bewegung in diese Richtung möglich!");
        } else if (e.getSource() == left) {
            if (spiel.checkIfPossible(Konstanten.NORDEN))
            {
                spiel.bewegeNach(Konstanten.OSTEN);
                spiel.starteSpiel(spiel.getAktuelleHoehle());
            }
            output.setText("Keine Bewegung in diese Richtung möglich!");
        } else if (e.getSource() == right) {
            if (spiel.checkIfPossible(Konstanten.NORDEN))
            {
                spiel.bewegeNach(Konstanten.WESTEN);
                spiel.starteSpiel(spiel.getAktuelleHoehle());
            }
            output.setText("Keine Bewegung in diese Richtung möglich!");
        } else if (e.getSource() == ex) {
            // System.out.println("Eingabe!");
        } else if (e.getSource() == one) {
            // System.out.println("Eins!");
        } else if (e.getSource() == two) {
            // System.out.println("Zwei!");
        } else if (e.getSource() == three) {
            // System.out.println("Drei!");
        } else if (e.getSource() == four) {
            // System.out.println("Vier!");
        } else if (e.getSource() == load) {
            String inputFromLoad = JOptionPane.showInputDialog("Deine ID:");
            spiel.anmelden(Integer.parseInt(inputFromLoad));
            print("Deine ID: "+inputFromLoad);
        } else if (e.getSource() == create) {
            String VornameinputFromCreate = JOptionPane.showInputDialog("Dein Vorname:");
            String NachnameinputFromCreate = JOptionPane.showInputDialog("Dein Nachname:");
            int idoutput = spiel.registrieren(0, VornameinputFromCreate, NachnameinputFromCreate);
            print("Deine ID: "+idoutput);
        }

    }

    public void stateChanged(ChangeEvent e) {
        if (fontSize.getValue() == 0) {
            output.setFont(fontSmall);
            clear.setFont(fontSmall);
            create.setFont(fontSmall);
            load.setFont(fontSmall);
            one.setFont(fontSmall);
            two.setFont(fontSmall);
            three.setFont(fontSmall);
            four.setFont(fontSmall);
            fontSizeLabel.setFont(fontSmall);
        } else if (fontSize.getValue() == 1) {
            output.setFont(font);
            clear.setFont(font);
            clear.setText("Textausgabe leeren");
            create.setFont(font);
            create.setText("Spieler erstellen");
            load.setFont(font);
            one.setFont(font);
            two.setFont(font);
            three.setFont(font);
            four.setFont(font);
            fontSizeLabel.setFont(font);
        } else if (fontSize.getValue() == 2) {
            output.setFont(fontLarge);
            clear.setFont(fontLarge);
            clear.setText("Leeren");
            create.setFont(fontLarge);
            create.setText("Erstellen");
            load.setFont(fontLarge);
            one.setFont(fontLarge);
            two.setFont(fontLarge);
            three.setFont(fontLarge);
            four.setFont(fontLarge);
            fontSizeLabel.setFont(fontLarge);
        }
    }
}