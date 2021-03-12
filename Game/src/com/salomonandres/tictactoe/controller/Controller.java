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

	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "00":
				model.fillSquare(0, 0);
				view.markSquare(0, 0);
				isTicTacToe();
				turn++;
				break;
			case "01":
				model.fillSquare(0, 1);
				view.markSquare(0, 1);
				isTicTacToe();
				turn++;
				break;
			case "02":
				model.fillSquare(0, 2);
				view.markSquare(0, 2);
				isTicTacToe();
				turn++;
				break;
			case "10":
				model.fillSquare(1, 0);
				view.markSquare(1, 0);
				isTicTacToe();
				turn++;
				break;
			case "11":
				model.fillSquare(1, 1);
				view.markSquare(1, 1);
				isTicTacToe();
				turn++;
				break;
			case "12":
				model.fillSquare(1, 2);
				view.markSquare(1, 2);
				isTicTacToe();
				turn++;
				break;
			case "20":
				model.fillSquare(2, 0);
				view.markSquare(2, 0);
				isTicTacToe();
				turn++;
				break;
			case "21":
				model.fillSquare(2, 1);
				view.markSquare(2, 1);
				isTicTacToe();
				turn++;
				break;
			case "22":
				model.fillSquare(2, 2);
				view.markSquare(2, 2);
				isTicTacToe();
				turn++;
				break;
			}
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

	}

}
