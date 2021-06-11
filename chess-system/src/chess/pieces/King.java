package chess.pieces;

import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

		Position p = new Position(0, 0);

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				p.setValues(position.getRow() + i, position.getColumn() + j);
				if (getBoard().positionExists(p)) {
					mat[p.getRow()][p.getColumn()] = !getBoard().thereIsAPiece(p);

					mat[p.getRow()][p.getColumn()] = mat[p.getRow()][p.getColumn()] || isThereOpponentPiece(p);
				}
			}
		}
		return mat;
	}

}
