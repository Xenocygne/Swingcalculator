package ch.ifage.cours.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainJFrame extends JFrame implements ActionListener {

	private JTextField txtResultat;
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMoins, btnMultiplier,
			btnDiviser, btnEgal, btnPoint, btnRAZ;
	private double nombre1;
	private double nombre2;
	private String operation; 
	

	public MainJFrame() {

		setLayout(new BorderLayout());
		JPanel affichage = new JPanel();
		txtResultat = new JTextField(30);
		txtResultat.setText("0"); 
		txtResultat.setEditable(false);
		affichage.add(txtResultat);
		add(affichage, BorderLayout.NORTH);

		JPanel clavier = new JPanel();
		remplirClavier(clavier);
		add(clavier, BorderLayout.CENTER);

		setTitle("Calculator");
		pack();
		setVisible(true);
	}

	private void remplirClavier(JPanel c) {
		c.setLayout(new GridLayout(5, 4));
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnPlus = new JButton("+");
		btnMoins = new JButton("-");
		btnMultiplier = new JButton("*");
		btnDiviser = new JButton("/");
		btnEgal = new JButton("=");
		btnPoint = new JButton(".");
		btnRAZ = new JButton("C");

		c.add(btn7);
		c.add(btn8);
		c.add(btn9);
		c.add(btnDiviser);

		c.add(btn4);
		c.add(btn5);
		c.add(btn6);
		c.add(btnMultiplier);

		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		c.add(btnMoins);

		c.add(btnEgal);
		c.add(btn0);
		c.add(btnPoint);
		c.add(btnPlus);
		
		c.add(new JButton(" "));
		
		c.add(btnRAZ);
		c.add(new JButton(" "));
		c.add(new JButton(" "));
		
		// s'enregistrer pour l'écouter l'evenement click
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		
		btnMoins.addActionListener(this);
		btnEgal.addActionListener(this);
		btnPoint.addActionListener(this);
		btnPlus.addActionListener(this);
		btnRAZ.addActionListener(this);
		
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		String selectNumber = "0";
		switch (e.getActionCommand()) {
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case ".":
				selectNumber = e.getActionCommand();
				addToTextResult(selectNumber); 
				break; 
		
			case "+":
			case "-":
			case "/":
			case "*": 
			
				addToTextResult(" " + e.getActionCommand());
				break;
			
			case"=":
				calculeResultat(); 
				break;
				
			case"C":
			
				txtResultat.setText("0");
				break;
				
		
			
		
		}
		
		addToTextResult(selectNumber);
	}
	
	private void addToTextResult(String s) {
		txtResultat.setText( txtResultat.getText()+s);
		
	}
	
	private void calculeResultat() {
		String [] contenuResultat = txtResultat.getText().split(" "); 
		nombre1 = Double.parseDouble(contenuResultat[0]); 
		operation = contenuResultat[1];
		nombre2 = Double.parseDouble(contenuResultat[2]); 
		double resultat = 0;
		
      switch (operation) {
      case "+": 
    	  resultat = nombre1 + nombre2;
    	  break; 
    	  
      case "-":
    	  resultat = nombre1 - nombre2;
    	  break; 
    	  
      case "/":
    	  resultat = nombre1 /nombre2; 
    	  break; 
    	  
      case "*":
    	  resultat = nombre1 * nombre2;
    	  break; 
    	  
    default : 
    	resultat = 0;
}
		
	txtResultat.setText("" + resultat);
	
	}
	
}
