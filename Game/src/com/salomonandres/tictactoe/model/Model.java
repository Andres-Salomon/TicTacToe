package com.salomonandres.tictactoe.model;

import com.salomonandres.tictactoe.controller.Controller;

public class Model {

	private int turn;
	private char character;
	private char[][] board = new char[3][3];

	public Model() {
		initializeBoard();
	}

	private void initializeBoard() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
		turn = 0;
	}

	public void fillSquare(int xPos, int yPos) {
		if ((xPos < 3 && yPos < 3) && squareIsEmpty(xPos, yPos)) {
			board[xPos][yPos] = turn();
			Controller.setTicTacToe(isTicTacToe(turn()));
			turn++;
		}
	}

	public boolean squareIsEmpty(int xPos, int yPos) {
		if (board[xPos][yPos] != 'O' && board[xPos][yPos] != 'X') {
			return true;
		}
		return false;
	}

	private char turn() {
		if (turn % 2 == 0) {
			character = 'O';
			return character;
		} else {
			character = 'X';
			return character;
		}
	}

	private boolean isTicTacToe(char character) {
		int row = 0;
		int column = 0;

		if (board[row][column] == character && board[row][column + 1] == character
				&& board[row][column + 2] == character) {
			return true;
		} else if (board[row + 1][column] == character && board[row + 1][column + 1] == character
				&& board[row + 1][column + 2] == character) {
			return true;
		} else if (board[row + 2][column] == character && board[row + 2][column + 1] == character
				&& board[row + 2][column + 2] == character) {
			return true;
		} else if (board[row][column] == character && board[row + 1][column] == character
				&& board[row + 2][column] == character) {
			return true;
		} else if (board[row][column + 1] == character && board[row + 1][column + 1] == character
				&& board[row + 2][column + 1] == character) {
			return true;
		} else if (board[row][column + 2] == character && board[row + 1][column + 2] == character
				&& board[row + 2][column + 2] == character) {
			return true;
		} else if (board[row][column] == character && board[row + 1][column + 1] == character
				&& board[row + 2][column + 2] == character) {
			return true;
		} else if (board[row + 2][column] == character && board[row + 1][column + 1] == character
				&& board[row][column + 2] == character) {
			return true;
		} else if (turn == 9) {
		}
		return false;

	}

	public void resetBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

}
