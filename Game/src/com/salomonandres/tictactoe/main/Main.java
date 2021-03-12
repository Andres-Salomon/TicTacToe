package com.salomonandres.tictactoe.main;

import com.salomonandres.tictactoe.controller.Controller;
import com.salomonandres.tictactoe.model.Model;
import com.salomonandres.tictactoe.view.View;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Controller c = new Controller(new Model(), new View());
	}
}
