package com.salomonandres.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.salomonandres.tictactoe.model.Model;
import com.salomonandres.tictactoe.view.View;

public class Controller {
	private Model model;
	private View view;
	private static boolean ticTacToe = false;
	private int turn = 0;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		view.addActionListener(new ButtonListener());
	}

	public static void setTicTacToe(boolean ticTacToe) {
		Controller.ticTacToe = ticTacToe;
	}

	public int turn(int xPos, int yPos) {
		if (model.squareIsEmpty(xPos, yPos)) {
			model.fillSquare(xPos, yPos);
			view.markSquare(xPos, yPos);
			isTicTacToe();
			turn++;
		}

		return turn;
	}

	private void isTicTacToe() {
		if (ticTacToe) {
			turn = 0;
			model.resetBoard();
			view.gameOver();
		} else if (turn == 9 && ticTacToe == false) {
			turn = 0;
			model.resetBoard();
			view.gameOverTie();
		}
		ticTacToe = false;

	}

	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "00":
				turn(0, 0);
				break;
			case "01":
				turn(0, 1);
				break;
			case "02":
				turn(0, 2);
				break;
			case "10":
				turn(1, 0);
				break;
			case "11":
				turn(1, 1);
				break;
			case "12":
				turn(1, 2);
				break;
			case "20":
				turn(2, 0);
				break;
			case "21":
				turn(2, 1);
				break;
			case "22":
				turn(2, 2);
				break;
			}
		}

	}

}
