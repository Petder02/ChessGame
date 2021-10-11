
/**
 * 
 * A class representing a pawn chess piece
 * @author Peter Schlueter
 * 
 */
public class PawnPiece extends ChessPiece implements PawnMove
{
  
  //Field storing the user's desired piece upgrade (wont be used here
  //private int pieceUpgrade = 0;
  
  /* This section contains the constructor for a pawn chess piece */
  
  /**
   * Creates a pawn chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public PawnPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "P", null, row, column, board);
  }
  
  /* This section contains methods defining the move rules of a pawn */

  /**
   * Determines if the move is valid for a pawn
   * @param toRow    the row to which the pawn is intended to be moved
   * @param toColumn the column to which the pawn is intended to be moved
   * @return true if this is a legal pawn move, false otherwise
   */
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //If the move is not out of bounds or not set to the original position, continue with the method
    if (super.isLegalMove(toRow, toColumn))
    {
      //If the move is legal for a pawn, return true
      if (isPawnMove(toRow, toColumn, getChessBoard().getPiece(getRow(),getColumn())))
      {
        return true;
      }
    }
    return false;
  }

}