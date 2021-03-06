/**
 * 
 * An interface which represents general properties associated with a Chess game board
 * @author Peter Schlueter
 * 
 */
public interface ChessBoard
{
  
  /**
   * Gets the rules of this type of Chess game
   * @return the rules of this type of Chess game
   */
  public ChessGame getGameRules();
  
  /**
   * Adds a piece to the board at the indicated row and collumn
   * @param piece   the piece to be added to the board
   * @param row     the row in which the piece should be added
   * @param column  the column in which the piece should be added
   */
  public void addPiece(ChessPiece piece, int row, int column);
  
  /**
   * Removes a piece from the board at the indicated position
   * @param row    the row which the piece should be removed from
   * @param column the column which the piece should be removed from
   * @return the piece which was removed from the board
   */
  public ChessPiece removePiece(int row, int column);
  
  /**
   * Checks if there is a piece at the indicated position on the board
   * @param row    the row which there may be a piece at
   * @param column the row which there may be a piece at
   * @return true if there is a piece at the indicated position, false otherwise
   */
  public boolean hasPiece(int row, int column);
  
  /**
   * Gets the piece at the indicated position on the board
   * @param row    the row on the board where there may be a piece
   * @param column the column on the board where there may be a piece
   * @return the piece at the indicated row and column, if one exists
   */
  public ChessPiece getPiece(int row, int column);
  
  /**
   * Checks if the opposing player can make a legal capture move to
   * the indicated row and column on the board
   * @param row    the indicated row on the board
   * @param column the indicated column on the board
   * @param piece  the indicated piece which may or may not be threatened
   * @return true if the opposing player can make a legal capture move to
   *         the indicated row and column, false otherwise
   */
  public boolean squareThreatened(int row, int column, ChessPiece piece);
  
}