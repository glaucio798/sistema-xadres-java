package boardgame;

public class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.position = null;
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}

//	public abstract boolean[][] possibleMoves();
//
//	public abstract boolean possibleMove(Position pos);
//
//	public abstract boolean isThereAnyPossibleMove();

}
