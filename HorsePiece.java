/**
 * 
 * A class which represents a Xiangqi Horse Piece
 * @author Peter Schlueter
 * 
 */
public class HorsePiece extends ChessPiece implements LMove
{
  
  /** 
   * Creates a horse piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public HorsePiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "H", null, row, column, board);
  }
  
  /** 
   * Checks if the inputted move is legal for a horse
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a horse and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    if (super.isLegalMove(toRow, toColumn))
    {
      //If this is an L-shaped move, then continue checking for its legality
      if (isLMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
      {
        /* 
         * The if blocks here run through possible variations of L-shaped moves,
         * and checks each variation for if there is a piece that would obstruct the Horse piece's initial movement
         */
        //If the piece moved up and northwest or left and northwest
        //invalidate the move if there is a piece southeast of this piece's destination square that would block this piece's path
        if ((toRow == getRow() - 2 && toColumn == getColumn() - 1) ||
            (toRow == getRow() - 1 && toColumn == getColumn() - 2))
        {
          return !(getChessBoard().hasPiece(toRow + 1, toColumn + 1));
        }
        //If the piece moved left and southwest or down and southwest
        //invalidate the move if there is a piece northeast of this piece's destination square that would block this piece's path
        if ((toRow == getRow() + 1 && toColumn == getColumn() - 2) ||
            (toRow == getRow() + 2 && toColumn == getColumn() - 1))
        {
          return !(getChessBoard().hasPiece(toRow - 1, toColumn + 1));
        }
        //If the piece moved down and southeast or right and southeast
        //invalidate the move if there is a piece northwest of this piece's destination square that would block this piece's path
        if ((toRow == getRow() + 2 && toColumn == getColumn() + 1) ||
            (toRow == getRow() + 1 && toColumn == getColumn() + 2))
        {
          return !(getChessBoard().hasPiece(toRow - 1, toColumn - 1));
        }
        //If the piece moved right and northeast or up and northeast
        //invalidate the move if there is a piece southwest of this piece's destination square that would block this piece's path
        if ((toRow == getRow() - 2 && toColumn == getColumn() + 1) ||
            (toRow == getRow() - 1 && toColumn == getColumn() + 2))
        {
          return !(getChessBoard().hasPiece(toRow + 1, toColumn - 1));
        }
      }
    }
    return false;
  }
}