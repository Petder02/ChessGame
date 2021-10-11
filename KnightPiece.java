/**
 *
 * A class which represents a knight chess piece
 * @author Peter Schlueter
 */
public class KnightPiece extends ChessPiece implements LMove
{
  
  /* This section contains the constructor for a knight chess piece */
  
  /**
   * Creates a knight chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public KnightPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "N", null, row, column, board);
  }
  
  /* This section defines piece movement rules for a knight */
  
  /**
   * Checks if the move is L-Shaped (if the move is a knight's legal move)
   * @param toRow    stores the row which the knight is intended to be moved to
   * @param toColumn stores the column which the knight is intended to be moved to
   * @return true if the move is L-Shaped and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //If the move is not out of bounds or not set to the original position, continue with the method
    if (super.isLegalMove(toRow, toColumn))
    {
      //If the move is L-Shaped, the move is legal
      //The piece at the current row and column should be a knight
      //If there is an error here, get the chess piece out side of the if, then check if it is an instance of KnightPiece
      /* Note to self for testers: If the chess piece at this square is empty (equal to null), a null pointer exception will be thrown */
      if (isLMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
      {
        return true;
      }
    }
    return false;
  }

}