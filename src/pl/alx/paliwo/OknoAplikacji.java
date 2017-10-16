package pl.alx.paliwo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OknoAplikacji {

	private JFrame frame;
	private JTextField textField_cena;
	private JTextField textField_spalanie;
	private JTextField textField_trasa;
	private JTextField textField_wynik;
	private JTextField textField_naOsobe;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoAplikacji window = new OknoAplikacji();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public OknoAplikacji() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 450, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKalkulatorCenyPodry = new JLabel("kalkulator ceny podróży");
		lblKalkulatorCenyPodry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("cena");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("spalanie");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTrasa = new JLabel("trasa");
		lblTrasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnPrzelicz = new JButton("przelicz");
		btnPrzelicz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				double cena=Double.parseDouble(textField_cena.getText());
				double spalanie=Double.parseDouble(textField_spalanie.getText());
				double trasa=Double.parseDouble(textField_trasa.getText());
				double wynik=Przelicz.oblicz(cena, spalanie, trasa);
				textField_wynik.setText(""+wynik);
				double ile=(double) spinner.getValue();
				textField_naOsobe.setText(""+wynik/ile);		
			}
		});
		
		textField_cena = new JTextField();
		textField_cena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_cena.setColumns(10);
		
		textField_spalanie = new JTextField();
		textField_spalanie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_spalanie.setColumns(10);
		
		textField_trasa = new JTextField();
		textField_trasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_trasa.setColumns(10);
		
		textField_wynik = new JTextField();
		textField_wynik.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_wynik.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		
		JLabel lblLiczbaOsob = new JLabel("liczba osob");
		lblLiczbaOsob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_naOsobe = new JTextField();
		textField_naOsobe.setColumns(10);
		
		JLabel lblKosztNaOsobe = new JLabel("koszt na osobe");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
							.addComponent(textField_cena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
							.addComponent(textField_spalanie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTrasa)
							.addGap(258)
							.addComponent(textField_trasa))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(lblKalkulatorCenyPodry))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPrzelicz)
								.addComponent(lblLiczbaOsob))
							.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinner)
								.addComponent(textField_wynik)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblKosztNaOsobe)
							.addPreferredGap(ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
							.addComponent(textField_naOsobe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKalkulatorCenyPodry)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_cena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_spalanie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_trasa)
						.addComponent(lblTrasa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner)
						.addComponent(lblLiczbaOsob))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrzelicz)
						.addComponent(textField_wynik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_naOsobe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKosztNaOsobe))
					.addGap(114))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
