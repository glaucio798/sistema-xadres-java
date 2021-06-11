package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		ChessMatch m = new ChessMatch();
		Scanner sc = new Scanner(System.in);

		while (true) {
			UI.printBoard(m.getPieces());
			System.out.println();
			System.out.print("Print source: ");
			ChessPosition src = UI.readChessPosition(sc);
			System.out.print("Print target: ");
			ChessPosition tgt = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = m.performChessMove(src, tgt);
		}

	}

}
