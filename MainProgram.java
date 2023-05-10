import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainProgram{
	private JFrame frame;
	private JTextField textField;
	// private int answer;
	// Constract and Initialization
	MainProgram(){
		frame = new JFrame();
		init();
		text_field_num_only();
	}

	private void init() {
		frame.setLayout(new GridBagLayout());	//creating grid layout of 6 rows and 4 columns
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Text Field
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 20));
		textField.setHorizontalAlignment(JTextField.RIGHT);

		this.textField = textField;

		// Creating the constraints for textField1
        GridBagConstraints constraints = new GridBagConstraints();
        // constraints.gridwidth = 4; // Set the column span to 4
		// constraints.gridwidth = 4; // Extend to 3 columns
        constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0; // Start from the first column
        constraints.gridy = 0; // First row
		constraints.weighty = 1.0;   //request any extra vertical space
		constraints.ipady = 40;
        constraints.gridwidth = 4; // Span all four columns
		
		// Row 1
		JButton modbtn = new JButton("%");
		JButton CEbtn = new JButton("CE");
		JButton Cbtn = new JButton("C");
		JButton backbtn = new JButton("Backward");

		// Row 2
		JButton oneOverX = new JButton("1 / x");
		JButton xSquare = new JButton("x ^ 2");
		JButton rootX = new JButton("root(x)");
		JButton dividebtn = new JButton(" / ");

		// Row 3
		JButton num7=new JButton("7");
		JButton num8=new JButton("8");
		JButton num9=new JButton("9");
		JButton timesbtn=new JButton(" * ");

		// Row 4
		JButton num4=new JButton("4");
		JButton num5=new JButton("5");
		JButton num6=new JButton("6");
		JButton minusbtn=new JButton(" - ");

		// Row 5
		JButton num1=new JButton("1");
		JButton num2=new JButton("2");
		JButton num3=new JButton("3");
		JButton addbtn =new JButton(" + ");

		// Row 6
		JButton posnegBtn =new JButton("+ / -");
		JButton num0 =new JButton("0");
		JButton dot =new JButton(".");
		JButton equal =new JButton(" = ");

		JButton[][] btns = { {modbtn, CEbtn, Cbtn, backbtn}, 
			{oneOverX, xSquare, rootX, dividebtn}, 
			{num7, num8, num9, timesbtn},
			{num4, num5, num6, minusbtn},
			{num1, num2, num3, addbtn},
			{posnegBtn, num0, dot, equal}
		};

		// Text Field
		frame.add(textField, constraints, 0);
			

		for (int i = 0; i < btns.length; i++) {
			for (int j = 0; j < btns[i].length; j++) {
				constraints.gridx = j; // Current column
                constraints.gridy = i + 1; // Rows after the first
                constraints.gridwidth = 1; // Span one column
                frame.add(btns[i][j], constraints);
			}
		}
		
		frame.pack();
		frame.setSize(frame.getPreferredSize());
		// frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void text_field_num_only() {
		this.textField.addKeyListener(new KeyAdapter() {
			private double answer = 0.0;
			private boolean actionBefore = false;
			private boolean equalBefore = false;
			private int action = 0;
			private double save_input = 0;

			public void calculation(int action, double value_to_add) {
				switch (action) {
					case 1:
						this.answer += value_to_add;
						
						break;

					case 2:
						this.answer -= value_to_add;
						break;

					case 3:
						this.answer *= value_to_add;
						break;

					case 4:
						this.answer /= value_to_add;
						break;
				}
			}

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!Character.isDigit(c)) {

					System.out.println(c);
					String fieldtext = textField.getText();
					
					double currentInput = Double.parseDouble(fieldtext);

					if (equalBefore) {
						equalBefore = false;
					} else if (!actionBefore) {
						this.answer = currentInput;
					}

					save_input = currentInput;

					// Action Section
					switch (c) {
						case '+':

							if (actionBefore && !equalBefore) {
								calculation(action, save_input);
							}

							actionBefore = true;
							textField.setText("");
							action = 1;
							break;

						case '-':

							if (actionBefore && !equalBefore) {
								calculation(action, save_input);
								// this.answer -= currentInput;
							}

							actionBefore = true;
							textField.setText("");
							action = 2;

							break;

						case '*':
							if (actionBefore && !equalBefore) {
								calculation(action, save_input);
								// this.answer *= currentInput;
							}

							actionBefore = true;
							textField.setText("");
							action = 3;

							break;

						case '/':

							if (actionBefore && !equalBefore) {
								calculation(action, save_input);
								// this.answer /= currentInput;
							}

							actionBefore = true;
							textField.setText("");
							action = 4;

							break;

						case '=':
							// System.out.println(this.answer);
							// System.out.println(action + " " + currentInput);
							calculation(action, currentInput);

							textField.setText(this.answer + "");
							actionBefore = false;
							equalBefore = true;
							break;
					}

					e.consume();
				} else {
					if (equalBefore) {
						textField.setText("");
						actionBefore = false;
						equalBefore = false;
					}
					
				}
			}
		});
	}

	public static void main(String[] args) {
		new MainProgram();
	}
}