package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		ChessMatch m = new ChessMatch();
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(m.getPieces());
				System.out.println();
				System.out.print("Print source: ");
				ChessPosition src = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = m.possibleMoves(src);
				UI.clearScreen();
				UI.printBoard(m.getPieces(), possibleMoves);				
				
				System.out.print("Print target: ");
				ChessPosition tgt = UI.readChessPosition(sc);

				ChessPiece capturedPiece = m.performChessMove(src, tgt);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}

}
