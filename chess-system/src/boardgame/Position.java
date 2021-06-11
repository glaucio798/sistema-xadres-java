package boardgame;

public class Position {

	private int row, column;

	public Position() {
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public String toString() {
		return "row " + row + ", column " + column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	
	
	
	
}
