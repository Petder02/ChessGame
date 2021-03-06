/**
 * 
 * An interface defining the rules of a one space diagonal move
 * @author Peter Schlueter
 * 
 */
public interface OneSpaceDiagonalMove
{
  
  /**
   * Defines the rules of a one space diagonal move in any direction
   * @param toRow     the row which the piece is intended to be moved to
   * @param toColumn  the column which the piece is intended to be moved to
   * @param piece     the piece which is intended to be moved
   * @return true if this is a legal one-space diagonal move, false otherwise
   */
  public default boolean isOneSpaceDiagonalMove(int toRow, int toColumn, ChessPiece piece)
  {
    //Restricting the piece to only be allowed to move one space diagonally
    if (Math.abs(piece.getRow() - toRow) == 1 && Math.abs(piece.getColumn() - toColumn) == 1)
    {
      return Math.abs(piece.getRow() - toRow) == Math.abs(piece.getColumn() - toColumn);
    }
    return false;
  }
}