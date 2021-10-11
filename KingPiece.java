/**
 *
 * A class which represents a king chess piece
 * @author Peter Schlueter
 * @version 2.0
 *
 */
public class KingPiece extends ChessPiece implements OmniDirectionalOneSpaceMove, CastleMove
{
  
  //Its possible that something may have to be implimented checking off the fact a castle move was made
  
  /* This section contains the contructor for a king chess piece */
  
  /**
   *  Creates a king chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public KingPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "K", null, row, column, board);
  }
  
  /* This section contains piece movement rules for a king */
  
  /** 
   * Checks if the inputted move is legal for a king (vertical, horizontal, or diagonal of one space)
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a king and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //If the move is not out of bounds or not set to the original position, continue with the method
    if (super.isLegalMove(toRow, toColumn))
    {
      //If the move is legal for a king and the king is not making a move that would put it in check, return true
      if ((isOmniDirectionalOneSpaceMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn()))))
      {
        //This segment is added in project 5: Prevent a king from moving into check
        //if (getChessBoard().squareThreatened(toRow, toColumn, this))
        //{
          //return false;
        //}
        return true;
      }
      //If this is a legal castle move, move the rook here and return true
      if (isCastleMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
      {
        //ChessPiece rookMoved stores the rook which will be moved in this castle move
        return true;
      }
    }
    return false;
  }
  
}