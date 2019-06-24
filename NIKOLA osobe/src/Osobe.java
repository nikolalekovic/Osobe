import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Osobe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	

	public static void infoBox(String infoMessage, String titleBar)
	  {
	        JOptionPane.showMessageDialog(null, infoMessage, "Error: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	  }
	/**
	 * Launch the application.
	 */
	
	public static boolean isNumeric(String strNum) {
	    try {
	        Integer d = Integer.parseInt(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Osobe frame = new Osobe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Osobe() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "sortiranje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(25, 153, 381, 105);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton radioButton = new JRadioButton("Po godinama starosti, rastuce");
		buttonGroup.add(radioButton);
		radioButton.setBounds(20, 58, 243, 23);
		panel_1.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Po prezimenu i imenu");
		buttonGroup.add(radioButton_1);
		radioButton_1.setSelected(true);
		radioButton_1.setBounds(20, 27, 199, 23);
		panel_1.add(radioButton_1);
		
		JLabel lblNewLabel = new JLabel("Ime i Prezime");
		lblNewLabel.setBounds(31, 34, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Godiste");
		lblNewLabel_1.setBounds(291, 34, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(125, 31, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(344, 31, 56, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 366, 381, 140);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setMargin(new Insets(5,5,5,5));
		
		scrollPane.setViewportView(textArea);
		
		ArrayList<String> os = new ArrayList<String>();
		ArrayList<String> os2 = new ArrayList<String>();
		Osoba o = new Osoba();
		JButton btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char test=' ';
				try
				{
				test = textField.getText().charAt(0);
				}
				catch (Exception e1)
				{
				}
				if (test!=' '&&!textField.getText().equals("")&&textField.getText()!=null&&!textField.getText().substring(textField.getText().lastIndexOf(" ")+1).equals(""))
				{
					if (isNumeric(textField_1.getText())==true&&textField_1.getText().length()==4)
					{
						try
						{
						Osoba o = new Osoba(textField.getText(),Integer.parseInt(textField_1.getText()));
						os.add(o.getPrezime()+", "+o.getIme()+", "+o.getGodiste());
						os2.add(o.getGodiste()+", "+o.getPrezime()+", "+o.getIme());
						System.out.println("Unos je uspesan");
						}
						catch (StringIndexOutOfBoundsException SIOoBE)
						{
							Osobe.infoBox("Ime nije ispravno", "");
							textField.setText("");
						}
					
					}
					else
					{
						Osobe.infoBox("Godina nije ispravna", "");
						textField_1.setText("");
					}
				}
				else
				{
					
					Osobe.infoBox("Ime nije ispravno", "");
					textField.setText("");
					
				}
				
				
				
			}
		});
		btnNewButton.setBounds(122, 102, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ponisti");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");textField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(221, 102, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Sortiraj i ispisi rezultat");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (radioButton_1.isSelected())
				{
					String ispis = "";
					Collections.sort(os);
					for (int i = 0; i < os.size(); i++) {
						ispis=ispis+""+os.get(i)+"\n";
						
					}
					textArea.setText(ispis);
					String ime=os.get(0).substring(0,os.get(0).lastIndexOf(" ")-1);
					String godina=os.get(0).substring(os.get(0).lastIndexOf(" ")+1);
					textField_2.setText(ime);
					textField_3.setText(godina);
				}
				else
				{
					String ispis = "";
					Collections.sort(os2);
					for (int i = 0; i < os2.size(); i++) {
						ispis=ispis+""+os2.get(i)+"\n";
						
					}
					textArea.setText(ispis);
					String ime=os2.get(0).substring(os2.get(0).indexOf(" ")+1);
					String godina=os2.get(0).substring(0,os2.get(0).indexOf(" ")-1);
					textField_2.setText(ime);
					textField_3.setText(godina);
				}
				}
				catch(IndexOutOfBoundsException IOoBE)
				{
					textArea.setText("Baza je prazna");
				}
			}
		});
		btnNewButton_2.setBounds(122, 276, 198, 23);
		contentPane.add(btnNewButton_2);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Font font = new Font("arial",Font.BOLD, 19);
				textField_2.setFont(font);
				textField_2.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Font font = new Font("arial",Font.PLAIN, 14);
		        textField_2.setFont(font);
		        textField_2.setForeground(Color.black);
			}
		});
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(125, 320, 156, 20);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("Ime i Prezime");
		label.setBounds(31, 323, 84, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Godiste");
		label_1.setBounds(291, 323, 46, 14);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Font font = new Font("arial",Font.BOLD, 19);
				textField_3.setFont(font);
				textField_3.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Font font = new Font("arial",Font.PLAIN, 14);
		        textField_3.setFont(font);
		        textField_3.setForeground(Color.black);
			}
		});
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(344, 320, 56, 20);
		contentPane.add(textField_3);
		
		
		
		

	}
}
