package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		this.board = new Board(8, 8);
		this.initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getRows(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		
		return mat;
	}

	public boolean[][] possibleMoves(ChessPosition src){
		Position position = src.toPosition();
		validateSourcePosition(position);
		
		return board.piece(position).possibleMoves();
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position src = sourcePosition.toPosition();
		Position tgt = targetPosition.toPosition();
	
		validateSourcePosition(src);
		validateTargetPosition(src, tgt);
	
		Piece capturedPiece = makeMove(src, tgt);
		
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position src, Position tgt) {
		Piece p = board.removePiece(src);
		Piece captured = board.removePiece(tgt);
		board.placePiece(p, tgt);
		
		return captured;
	}
	
	private void validateSourcePosition(Position pos) {
		if(!board.thereIsAPiece(pos)) {
			throw new ChessException("There is no piece on source position");
		}
		if(!board.piece(pos).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position src, Position tgt) {
		if(!board.piece(src).possibleMove(tgt)) {
			throw new ChessException("The chosen piece can't move to the target position");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
        placeNewPiece('a', 2, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('f', 1, new Rook(board, Color.WHITE));
        placeNewPiece('g', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 1, new King(board, Color.WHITE));
        placeNewPiece('b', 2, new King(board, Color.WHITE));
//        placeNewPiece('c', 2, new King(board, Color.WHITE));
//        placeNewPiece('d', 2, new King(board, Color.WHITE));
//        placeNewPiece('e', 2, new King(board, Color.WHITE));
//        placeNewPiece('f', 2, new King(board, Color.WHITE));
//        placeNewPiece('g', 2, new King(board, Color.WHITE));
//        placeNewPiece('h', 2, new King(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('f', 8, new Rook(board, Color.BLACK));
        placeNewPiece('g', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new King(board, Color.BLACK));
        placeNewPiece('b', 7, new King(board, Color.BLACK));
        placeNewPiece('c', 7, new King(board, Color.BLACK));
        placeNewPiece('d', 7, new King(board, Color.BLACK));
        placeNewPiece('e', 7, new King(board, Color.BLACK));
        placeNewPiece('f', 7, new King(board, Color.BLACK));
        placeNewPiece('g', 7, new King(board, Color.BLACK));
        placeNewPiece('h', 7, new King(board, Color.BLACK));
	}
	
	
	
}
