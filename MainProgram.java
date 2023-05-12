import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainProgram{
	private JFrame frame;
	private static JTextField textField;
	private static double answer;
	private static boolean actionBefore;
	private static boolean equalBefore;
	private static int action;
	private static double save_input;


	// Buttons
	JButton modbtn;
		JButton CEbtn;
		JButton Cbtn;
		JButton backbtn;

		// Row 2
		JButton oneOverX;
		JButton xSquare;
		JButton rootX;
		JButton dividebtn;

		// Row 3
		JButton num7;
		JButton num8;
		JButton num9;
		JButton timesbtn;

		// Row 4
		JButton num4;
		JButton num5;
		JButton num6;
		JButton minusbtn;

		// Row 5
		JButton num1;
		JButton num2;
		JButton num3;
		JButton addbtn;

		// Row 6
		JButton posnegBtn;
		JButton num0;
		JButton dot;
		JButton equal;

	// private int answer;
	// Constract and Initialization
	MainProgram(){
		frame = new JFrame();
		init();
		init_button_listener();
		text_field_num_only();

	}

	private void init() {
		frame.setLayout(new GridBagLayout());	//creating grid layout of 6 rows and 4 columns
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Text Field
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 20));
		textField.setHorizontalAlignment(JTextField.RIGHT);

		MainProgram.textField = textField;

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

		this.modbtn = modbtn;
		this.CEbtn = CEbtn;
		this.Cbtn = Cbtn;
		this.backbtn = backbtn;


		// Row 2
		JButton oneOverX = new JButton("1 / x");
		JButton xSquare = new JButton("x ^ 2");
		JButton rootX = new JButton("root(x)");
		JButton dividebtn = new JButton(" / ");

		this.oneOverX = oneOverX;
		this.xSquare = xSquare;
		this.rootX = rootX;
		this.dividebtn = dividebtn;

		// Row 3
		JButton num7=new JButton("7");
		JButton num8=new JButton("8");
		JButton num9=new JButton("9");
		JButton timesbtn=new JButton(" * ");

		this.num7 = num7;
		this.num8 = num8;
		this.num9 = num9;
		this.timesbtn = timesbtn;

		// Row 4
		JButton num4=new JButton("4");
		JButton num5=new JButton("5");
		JButton num6=new JButton("6");
		JButton minusbtn=new JButton(" - ");

		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
		this.minusbtn = minusbtn;

		// Row 5
		JButton num1=new JButton("1");
		JButton num2=new JButton("2");
		JButton num3=new JButton("3");
		JButton addbtn =new JButton(" + ");

		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.addbtn = addbtn;

		// Row 6
		JButton posnegBtn =new JButton("+ / -");
		JButton num0 =new JButton("0");
		JButton dot =new JButton(".");
		JButton equal =new JButton(" = ");

		this.posnegBtn = posnegBtn;
		this.num0 = num0;
		this.dot = dot;
		this.equal = equal;

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

	public void init_button_listener() {
		// Number Buttons
		this.num0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "0");
				check_number_input();
			}
		});

		this.num1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "1");
				check_number_input();
			}
		});

		this.num2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "2");
				check_number_input();
			}
		});

		this.num3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "3");
				check_number_input();
			}
		});

		this.num4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "4");
				check_number_input();
			}
		});

		this.num5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "5");
				check_number_input();
			}
		});

		this.num6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "6");
				check_number_input();
			}
		});

		this.num7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "7");
				check_number_input();
			}
		});

		this.num8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "8");
				check_number_input();
			}
		});

		this.num9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				MainProgram.textField.setText(MainProgram.textField.getText() + "9");
				check_number_input();
			}
		});

		// Non-Num

		this.modbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to run when the button is clicked
				check_nonnum_input('%');
			}
		});

		this.CEbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainProgram.textField.setText("");
				MainProgram.actionBefore = false;
				MainProgram.equalBefore = true;
			}
		});

		this.Cbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainProgram.textField.setText("");
				MainProgram.actionBefore = false;
				MainProgram.equalBefore = true;
			}
		});

		this.backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainProgram.textField.setText(MainProgram.textField.getText().substring(0, MainProgram.textField.getText().length() - 1));
			}
		});

		this.timesbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check_nonnum_input('*');
			}
		});

		this.minusbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check_nonnum_input('-');
			}
		});

		this.addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check_nonnum_input('+');
			}
		});

		this.dividebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check_nonnum_input('/');
			}
		});

		this.equal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check_nonnum_input('=');
			}
		});
	}

	public static void calculation(int action, double value_to_add) {
		switch (action) {
			case 1:
				MainProgram.answer += value_to_add;
				
				break;

			case 2:
				MainProgram.answer -= value_to_add;
				break;

			case 3:
				MainProgram.answer *= value_to_add;
				break;

			case 4:
				MainProgram.answer /= value_to_add;
				break;

			case 5:
				MainProgram.answer %= value_to_add;
				break;
		}
	}

	public static void check_number_input() {
		if (MainProgram.equalBefore) {
			textField.setText("");
			MainProgram.actionBefore = false;
			MainProgram.equalBefore = false;
		}
	}

	public static void check_nonnum_input(char c) {
		String fieldtext = textField.getText();
					
		double currentInput = Double.parseDouble(fieldtext);

		if (MainProgram.equalBefore) {
			MainProgram.equalBefore = false;
		} else if (!MainProgram.actionBefore) {
			MainProgram.answer = currentInput;
		}

		save_input = currentInput;

		// Action Section
		switch (c) {
			case '+':

				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 1;
				break;

			case '-':

				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
					// this.answer -= currentInput;
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 2;

				break;

			case '*':
				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
					// this.answer *= currentInput;
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 3;

				break;

			case '/':

				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
					// this.answer /= currentInput;
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 4;

				break;

			case '%':

				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
					// this.answer /= currentInput;
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 5;

				break;

			case '=':
				// System.out.println(this.answer);
				// System.out.println(action + " " + currentInput);
				calculation(action, currentInput);

				textField.setText(MainProgram.answer + "");
				MainProgram.actionBefore = false;
				MainProgram.equalBefore = true;
				break;
		}
	}

	public static void check_nonnum_input(KeyEvent e, char c) {
		String fieldtext = textField.getText();
					
		double currentInput = Double.parseDouble(fieldtext);

		if (MainProgram.equalBefore) {
			MainProgram.equalBefore = false;
		} else if (!MainProgram.actionBefore) {
			MainProgram.answer = currentInput;
		}

		save_input = currentInput;

		// Action Section
		switch (c) {
			case '+':

				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 1;
				break;

			case '-':

				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
					// this.answer -= currentInput;
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 2;

				break;

			case '*':
				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
					// this.answer *= currentInput;
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 3;

				break;

			case '/':

				if (MainProgram.actionBefore && !MainProgram.equalBefore) {
					calculation(action, save_input);
					// this.answer /= currentInput;
				}

				MainProgram.actionBefore = true;
				textField.setText("");
				action = 4;

				break;

			case '=':
				// System.out.println(this.answer);
				// System.out.println(action + " " + currentInput);
				calculation(action, currentInput);

				textField.setText(MainProgram.answer + "");
				MainProgram.actionBefore = false;
				MainProgram.equalBefore = true;
				break;
		}

		e.consume();
	}

	private void text_field_num_only() {
		MainProgram.textField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!Character.isDigit(c)) {
					check_nonnum_input(e, c);
				} else {
					check_number_input();
					
				}
			}
		});
	}

	public static void main(String[] args) {
		new MainProgram();
	}
}
