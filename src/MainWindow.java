import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MainWindow extends JFrame {

	private JPanel contentPane;
	private Board brd;
	private JCheckBox chckbxEasy;
	private JCheckBox chckbxMedium;
	private JCheckBox chckbxHard;
	private int diff = 1;
	private final int WIDTH = 1200;
	private final int HEIGHT = 900;
	private final int PANELSIZE = 800;
	private JPanel panel;
	private JPanel panel_1;
	private static boolean emptyBoard = true;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 0, 255, 255));
		
		panel = new JPanel(){
			protected void paintComponent(Graphics g){
				Graphics2D g2 = (Graphics2D) g;
				super.paintComponent(g);
				for(int i = 0; i < 10; i++){
					if(i%3 == 0)
						g2.setStroke(new BasicStroke(8));
					else
						g2.setStroke(new BasicStroke(4));
					g2.draw(new Line2D.Float(4+PANELSIZE/9*i, 4, 4+PANELSIZE/9*i, 4+PANELSIZE));
					g2.draw(new Line2D.Float(4, 4+PANELSIZE/9*i, 4+PANELSIZE, 4+PANELSIZE/9*i));
				}
				
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				System.out.printf("x = %d, y = %d\n", x, y);
				int i = -1;
				int j = -1;
				
				if(x > 0 && x < 90)
					i = 0;
				else if(x > 94 && x < 179)
					i = 1;
				else if(x > 182 && x < 263)
					i = 2;
				else if(x > 273 && x <354)
					i = 3;
				else if(x > 360 && x < 441)
					i = 4;
				else if(x > 447 && x < 528)
					i = 5;
				else if(x > 537 && x < 617)
					i = 6;
				else if(x > 621 && x < 706)
					i = 7;
				else if(x > 711 && x < 792)
					i = 8;
				
				if(y > 0 && y < 90)
					j = 0;
				else if(y > 94 && y < 179)
					j = 1;
				else if(y > 182 && y < 263)
					j = 2;
				else if(y > 273 && y <354)
					j = 3;
				else if(y > 360 && y < 441)
					j = 4;
				else if(y > 447 && y < 528)
					j = 5;
				else if(y > 537 && y < 617)
					j = 6;
				else if(y > 621 && y < 706)
					j = 7;
				else if(y > 711 && y < 792)
					j = 8;
				
				System.out.println(brd.fTd[i][j].getVal());
				
				if(i != -1 && j != -1 && brd.fTd[i][j].getEditable() == true){
					try{
						int val = Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Which number to use?\n(Use 0 to clear)"));
						if(val >= 0 && val <= 9){
							brd.fTd[i][j].setVal(val);
							panel_1.repaint();
						} else {
							JOptionPane.showMessageDialog(contentPane, "Wrong number! Please use only 0-9");
						}
					} catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(contentPane, "Not a number! Please enter a number.");
					}
					}
			}
		});
		panel.setBackground(new Color(80, 80, 255, 255));
		panel.setBounds(29, 29, PANELSIZE, PANELSIZE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(957, 709, 143, 53);
		btnExit.setBackground(new Color(80, 80, 255, 255));
		contentPane.add(btnExit);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(brd == null)
					JOptionPane.showMessageDialog(contentPane, "ERROR! The board is empty");
				else{
					if(brd.checkBoard() == false && brd.isFilled() == true)
						JOptionPane.showMessageDialog(contentPane, "CORRECT! Sudoku complete :)");
					else if(brd.checkBoard() == true)
						JOptionPane.showMessageDialog(contentPane, "WRONG! Please verify your solution");
					else if(brd.checkBoard() == false && brd.isFilled() == false)
						JOptionPane.showMessageDialog(contentPane, "SO FAR SO GOOD! Please fill in the blanks");
				}
					
			}
		});
		btnCheck.setBounds(957, 244, 143, 53);
		btnCheck.setBackground(new Color(80, 80, 255, 255));
		contentPane.add(btnCheck);
		
		
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				brd = new Board();
				brd.fillBoard(diff);
				if(emptyBoard == false)
					panel_1.repaint();
				else{
					panel_1 = new JPanel(){
						public void paint(Graphics g) {
						    Dimension d = this.getPreferredSize();
						    int fontSize = 60;

						    g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
						     
						   if(brd.fTd != null){
						    for(int i = 0; i < 9; i++){
						    	for(int j = 0; j < 9; j++){
						    g.setColor(brd.fTd[i][j].getColor());
						    if(brd.fTd[i][j].getVal() != 0)
						    	g.drawString(String.valueOf(brd.fTd[i][j].getVal()), (int) ((3+PANELSIZE/9-60) + i*PANELSIZE/9 - i*0.4),(int) ((3+PANELSIZE/9-23) + j*PANELSIZE/9 - j*0.4));
						    	}
						    }
						   }
						}
					};
					panel_1.setBounds(0, 0, 800, 800);
					panel_1.setOpaque(false);
					panel.add(panel_1);
					panel_1.repaint();
					emptyBoard = false;
				}
			}
		});
		btnGenerate.setBounds(957, 134, 143, 53);
		btnGenerate.setBackground(new Color(80, 80, 255, 255));
		contentPane.add(btnGenerate);
		
		
		
		chckbxEasy = new JCheckBox("EASY", true);
		chckbxEasy.setBounds(868, 84, 70, 25);
		chckbxEasy.setOpaque(true);
		chckbxEasy.setBackground(new Color(80, 80, 255, 255));
		
		contentPane.add(chckbxEasy);
		chckbxEasy.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		          if(chckbxEasy.isSelected()){
		        	  chckbxMedium.setSelected(false);
		        	  chckbxHard.setSelected(false);
		        	  diff = 1;
		          }
		        }
		      });
		
		chckbxMedium = new JCheckBox("MEDIUM");
		chckbxMedium.setBounds(967, 84, 89, 25);
		chckbxMedium.setOpaque(true);
		chckbxMedium.setBackground(new Color(80, 80, 255, 255));
		contentPane.add(chckbxMedium);
		chckbxMedium.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		          if(chckbxMedium.isSelected()){
		        	  chckbxEasy.setSelected(false);
		        	  chckbxHard.setSelected(false);
		        	  diff = 2;
		          }
		        }
		      });
		
		chckbxHard = new JCheckBox("HARD");
		chckbxHard.setBounds(1075, 84, 70, 25);
		chckbxHard.setOpaque(true);
		chckbxHard.setBackground(new Color(80, 80, 255, 255));
		contentPane.add(chckbxHard);
		
		JButton btnSolution = new JButton("SOLUTION");
		btnSolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dec = JOptionPane.showConfirmDialog(contentPane, "Are you sure? This cannot be undone", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dec == JOptionPane.YES_OPTION){
					brd.solve();
					panel_1.repaint();
				}
			}
		});
		btnSolution.setBackground(new Color(80, 80, 255));
		btnSolution.setBounds(957, 354, 143, 53);
		contentPane.add(btnSolution);
		chckbxHard.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		          if(chckbxHard.isSelected()){
		        	  chckbxMedium.setSelected(false);
		        	  chckbxEasy.setSelected(false);
		        	  diff = 3;
		          }
		        }
		      });
	}
}
