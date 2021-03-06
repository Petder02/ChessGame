/**
 * 
 * An interface defining a one-space horizontal move
 * @author Peter Schlueter
 * 
 */
public interface OneSpaceVerticalMove
{
  
  /**
   * Defines the rules of a one space vertical move
   * @param toRow    the row where the piece is intended to be moved
   * @param toColumn the column where the piece is intended to be moved
   * @param piece    the piece which may or may not be moved under this ruleset
   * @return true if the piece is making a valid one space vertical move, false otherwise
   */
  public default boolean isOneSpaceVerticalMove(int toRow, int toColumn, ChessPiece piece)
  {
    return (((toRow == piece.getRow() + 1) || (toRow == piece.getRow() - 1)) && (toColumn == piece.getColumn()));
  }
}