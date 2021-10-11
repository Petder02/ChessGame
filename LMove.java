/**
 *
 * An interface defining the rules of an L-shaped move
 * @author Peter SChlueter
 *
 */
public interface LMove
{
  
  /* Determines if a move is an LShaped move
   * @param toRow    the row to which the piece is intended to be moved
   * @param toColumn the column to which the piece is intended to be moved
   * @param piece    the chess piece the player is attempting to move
   * @return true if the move is LShaped, false otherwise
   */
  default boolean isLMove(int toRow, int toColumn, ChessPiece piece)
  {
    //If the move is two spaces up from the original position and one over or
    //one spaces up from the original position and two over, then this is an L-shaped move
    return (((Math.abs(piece.getRow() - toRow) == 2) && (Math.abs(piece.getColumn() - toColumn) == 1))
       || ((Math.abs(piece.getRow() - toRow) == 1) && (Math.abs(piece.getColumn() - toColumn) == 2)));
  }
    
}
