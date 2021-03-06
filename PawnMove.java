/**
 * 
 * An interface defining the rules of the move of a pawn
 * Note that this interface contains only the move rules for a pawn,
 * and is not used anywhere other than in the PawnPiece class
 * @author Peter Schlueter
 * 
 */
public interface PawnMove
{
  
  /* Determines if the move is valid for a pawn
   * @param toRow    the row to which the pawn is intended to be moved
   * @param toColumn the column to which the pawn is intended to be moved
   * @param piece    the chess piece which is intended to be moved
   * @return true if this is a legal pawn move, false otherwise
   */
  default boolean isPawnMove(int toRow, int toColumn, ChessPiece piece)
  {
    //If the piece is on the north side, then check for all of the following conditions
    if (piece.getSide() == ChessGame.Side.NORTH)
    {
      //First, check if the pawn is moving one space forward and that space is unocupied
      //If so, return true
      if ((piece.getColumn() == toColumn) && (piece.getRow() - toRow == -1) && (piece.getChessBoard().getPiece(toRow, toColumn) == null))
      {
        //If the pawn reaches the other side on a legal move, set toBeUpgraded to true
        if (toRow == piece.getChessBoard().getGameRules().getNumRows() - 1)
        {
          piece.setToBeUpgraded(true);
        }
        return true;
      }
      //Second, check if this is the pawns first move
      if (piece.getHasMoved() == false)
      {
        //If it is, the pawn can move two spaces up if there are no pieces on either space
        if ((piece.getColumn() == toColumn) && (piece.getRow() - toRow == -2)
              && (piece.getChessBoard().getPiece(toRow - 1, toColumn) == null) && (piece.getChessBoard().getPiece(toRow, toColumn) == null))
        {
          //If the pawn reaches the other side on a legal move, set toBeUpgraded to true
          if (toRow == piece.getChessBoard().getGameRules().getNumRows() - 1)
          {
            piece.setToBeUpgraded(true);
          }
            return true;
        }
      }
      //Third, if an opponent piece is diagonally in front of the pawn and the input location is on this spot, return true
      if ((((toRow - piece.getRow() == 1) && (toColumn - piece.getColumn() == 1)) || ((toRow - piece.getRow() == 1) && (toColumn - piece.getColumn() == -1)))
            && ((piece.getChessBoard().getPiece(toRow, toColumn) != null) && (!(piece.getSide().equals(piece.getChessBoard().getPiece(toRow, toColumn).getSide())))))
      {
        //Only valid if this space contains an opponent piece, set a flag indicating the piece at this position should be removed
        piece.setToBeRemoved(true);
        //If the pawn reaches the other side on a legal move, set toBeUpgraded to true
        if (toRow == piece.getChessBoard().getGameRules().getNumRows() - 1)
        {
          piece.setToBeUpgraded(true);
        }
        return true;
      }
      //If all of these conditions fail, return false
      return false;
    }
  
    //If this piece is on the south side, then check all of the following conditions
    if (piece.getSide() == ChessGame.Side.SOUTH)
    {
      //First, check if the pawn is moving one space forward and that space is unocupied
      //If so, return true
      if ((piece.getColumn() == toColumn) && (piece.getRow() - toRow == 1) && (piece.getChessBoard().getPiece(toRow, toColumn) == null))
      {
        //If the pawn reaches the other side on a legal move, set toBeUpgraded to true
        //The number of rows on the chessboard minus itself is equal to zero, so this row is the other side of the board
        if (toRow == 0)
        {
          piece.setToBeUpgraded(true);
        }
        return true;
      }
      //Second, check if this is the piece's first move
      if (piece.getHasMoved() == false)
      {
        
        //If it is, the pawn can move two spaces up if there are no pieces on either space
        if ((piece.getColumn() == toColumn) && (piece.getRow() - toRow == 2)
              && (piece.getChessBoard().getPiece(toRow + 1, toColumn) == null) && (piece.getChessBoard().getPiece(toRow, toColumn) == null))
        {
          //If the pawn reaches the other side on a legal move, set toBeUpgraded to true
          if (toRow == 0)
          {
            piece.setToBeUpgraded(true);
          }
            return true;
        }
      }
      //Third, if an opponent piece is diagonally in front of the pawn and the input location is on this spot, return true
      //Only valid if this space contains an opponent piece, set a flag indicating the piece at this position should be removed
      if (((((toRow - piece.getRow() == -1) && (toColumn - piece.getColumn() == 1)) || ((toRow - piece.getRow() == -1) && (toColumn - piece.getColumn() == -1))))
         && ((piece.getChessBoard().getPiece(toRow, toColumn) != null) && (!(piece.getSide().equals(piece.getChessBoard().getPiece(toRow, toColumn).getSide())))))
      {
        piece.setToBeRemoved(true);
        //If the pawn reaches the other side on a legal move, set toBeUpgraded to true
        if (toRow == 0)
        {
          piece.setToBeUpgraded(true);
        }
        return true;
      }
      //If all of these conditions fail, return false
      return false;
    }
    return false;
  }
}