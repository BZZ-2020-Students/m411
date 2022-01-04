package ipconverter; /**
 * Das GUI dient der Eingabe einer IP-Adresse im "klassischen" Format (IP-V4) 192.168.1.1
 * Diese Adresse wird dann in einen Bin�rwert (32-Bit) und in eine HEX-Darstellung umgewandelt.
 * 
 * @author  B163AAL
 * @version 1.0
 * @date    22.10.2016
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class IPAdrConverterGUI extends JFrame implements IPAdrConverterListener{
	
	private IPAdrConverterIF model; // Referenz des Datenobjektes
	//
	private JTextField ipAdrTXT;
	private JTextField ipAdrBinOutTXT;
	private JTextField ipAdrHexOutTXT;
	private JButton    computeBTN;
	
	/**
	 * Erstellt das GUI f�r die Anwendung.
	 * Die Referenz des Datenobjekts wird im Attribut model zur
	 * Verf�gung gestellt.
	 * Danach meldet sic das GUI als Listener beim Model an.
	 * 
	 * @param m Referenz auf Datenobjekt.
	 */
	public IPAdrConverterGUI(IPAdrConverterIF m){
		super("IP-Adress Converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		model = m;
		model.addIPAdrConverterListener(this);
		//
		init();
		//
		this.pack();
		this.setVisible(true);
	}
	
	/*
	 * Initialisiert alle Komponenten des GUI und bindet sie in die
	 * Benutzeroberfl�che ein.
	 */
	private void init(){
		// zuerst die Westseite mit den Labels in einem Grid
		JPanel lblPane = new JPanel(new GridLayout(3,1));
		lblPane.add(new JLabel("IP-Adresse :"));
		lblPane.add(new JLabel("Bin�r :"));
		lblPane.add(new JLabel("HEX :"));
		this.getContentPane().add(lblPane,  BorderLayout.WEST);
		//
		// zentral die Felder f�r die IP-Adress (Einagbe und Ausgabe)
		ipAdrTXT       = new JTextField("---.---.---.---");
		ipAdrBinOutTXT = new JTextField(35);
		ipAdrBinOutTXT.setEnabled(false);
		ipAdrHexOutTXT = new JTextField(11);
		ipAdrHexOutTXT.setEnabled(false);
		JPanel adrPane = new JPanel(new GridLayout(3,1));
		adrPane.add(ipAdrTXT);
		adrPane.add(ipAdrBinOutTXT);
		adrPane.add(ipAdrHexOutTXT);
		this.getContentPane().add(adrPane, BorderLayout.CENTER);
		//
		// im Osten die Schaltfl�che f�r die Umwandlung
		computeBTN = new JButton("berechne");
		computeBTN.setEnabled(false);
		JPanel btnPanel = new JPanel(new BorderLayout());
		btnPanel.add(computeBTN, BorderLayout.NORTH);
		this.getContentPane().add(btnPanel, BorderLayout.EAST);
		//
		// Action
		// wird das Eingabefeld geklickt, wird das Feld geleert.
		ipAdrTXT.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ipAdrTXT.setText("");
				computeBTN.setEnabled(true);
			}
		});
		//
		// wird [berechnen] gedr�ckt, wird die Methode zur Umrechnung der IP-Adresse 
		// aufgerufen
		computeBTN.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onAction();
			}
		});
	}
	
	/**
	 * Meldet einem registrierten Listener eine �nderung der Datenwerte.
	 * Implementation der Schnittstelle aus IPAdrConveterListener.
	 */
	public void update(){
		// Liest vom Model die neuen Datenwerte und schreibt diese
		// in die entsprechenden GUI-Komponenten.
		ipAdrBinOutTXT.setText(model.getIPAdrBinFormat());
		ipAdrHexOutTXT.setText(model.getIPAdrHexFormat());
	}
	
	/*
	 * Bei Action [berechnen] ausgef�hrt.
	 */
	private void onAction(){
		try{
			computeBTN.setEnabled(false);
			model.computeIP(ipAdrTXT.getText());
		}
		catch(IPFormatException ex){
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Eingabefehler", JOptionPane.ERROR_MESSAGE);
		}
	}
}
