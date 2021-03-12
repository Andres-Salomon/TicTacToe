package com.salomonandres.tictactoe.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class View extends JFrame {
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private JButton[][] squares = new JButton[3][3];
	private int turn = 0;
	private String character;
	private Font font = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 70);

	public View() {
		addInitializedSquares();
		setTitle("Tic Tac Toe");
		setSize(new Dimension(400, 400));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initializeSquares() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setActionCommand(i + "" + j);
				squares[i][j].setContentAreaFilled(false);
				squares[i][j].setFont(font);
				squares[i][j].setPreferredSize(new Dimension(0, 0));
			}
		}

	}

	public void addInitializedSquares() {

		setLayout(gbl);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		initializeSquares();

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[0][0], gbc);
		add(squares[0][0]);

		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[0][1], gbc);
		add(squares[0][1]);

		gbc.gridy = 0;
		gbc.gridx = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[0][2], gbc);
		add(squares[0][2]);

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[1][0], gbc);
		add(squares[1][0]);

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[1][1], gbc);
		add(squares[1][1]);

		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[1][2], gbc);
		add(squares[1][2]);

		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[2][0], gbc);
		add(squares[2][0]);

		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[2][1], gbc);
		add(squares[2][1]);

		gbc.gridy = 2;
		gbc.gridx = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		gbl.setConstraints(squares[2][2], gbc);
		add(squares[2][2]);
	}

	private String turn() {
		if (turn % 2 == 0) {
			character = "O";
			return character;
		} else {
			character = "X";
			return character;
		}
	}

	private boolean squareIsEmpty(int xPos, int yPos) {
		if (!(squares[xPos][yPos].getText().equals("O")) && !(squares[xPos][yPos].getText().equals("X"))) {
			return true;
		}
		return false;
	}

	public void markSquare(int xPos, int yPos) {
		if ((xPos < 3 && yPos < 3) && squareIsEmpty(xPos, yPos)) {
			squares[xPos][yPos].setText(turn());
			turn++;
		}

	}

	public void addActionListener(ActionListener buttonListener) {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < 3; j++) {
				squares[i][j].addActionListener(buttonListener);
			}
		}

	}

	public void gameOver() {
		JOptionPane.showMessageDialog(null, "" + character + " wins.\n Press OK to play again.", "Game Over",
				JOptionPane.INFORMATION_MESSAGE);
		makeSquaresBlank();
	}

	public void gameOverTie() {
		JOptionPane.showMessageDialog(null, "Tie \n Nobody wins.\n Press OK to play again.", "Game Over",
				JOptionPane.INFORMATION_MESSAGE);
		makeSquaresBlank();
	}

	private void makeSquaresBlank() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				squares[i][j].setText("");
			}
		}
	}

}
