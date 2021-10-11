//Peter Schlueter, Interface defining a legal castle move

/**
 * 
 * An interface defineing a legal castle move
 * @author Peter Schleuter
 * 
 */
public interface CastleMove
{
  
  /**
   * Determines if a king move is a legal castle move
   * @param toRow    the row which the piece is intended to be moved
   * @param toColumn the column which the piece is intended to be moved
   * @param piece    the piece which is intended to be moved
   */
  default boolean isCastleMove(int toRow, int toColumn, ChessPiece piece)
  {
    //Before the rest of the method, check to see if this is a valid castle move
    if ((toRow == piece.getRow()) && (Math.abs(piece.getColumn() - toColumn) == 2))
    {
      //1.) If the king has moved at all this game, immediately return false
      if (piece.getHasMoved() == true)
      {
        return false;
      }
      //If the king is on the north side, check the following conditions
      if (piece.getSide() == ChessGame.Side.NORTH)
      {
        //Next, check for if the king is moving east
        if (toColumn > piece.getColumn())
        {
          //ChessPiece rook stores the chess piece in the left corner of the board (from north perspective)
          ChessPiece rook = piece.getChessBoard().getPiece(0, piece.getChessBoard().getGameRules().getNumColumns() - 1);
          //2.) If piece is not an instance of a rook, return false
          if (!(rook instanceof RookPiece))
          {
            return false;
          }
          //3.) Given this piece is an instance of a rook, if it is on the opposing side, return false
          if (!(piece.getSide().equals(rook.getSide())))
          {
            return false;
          }
          //4.) If the rook piece has moved before, return false
          if (rook.getHasMoved() == true)
          {
            return false;
          }
          //5.) 
          //Loop-Goal: Determine if there are any pieces between the input piece and the rook or any squares between the two are threatened, 
          //and if so, return false
          for (int c = rook.getColumn() - 1; c > piece.getColumn(); c--)
          {
            if ((piece.getChessBoard().getPiece(piece.getRow(), c) != null) ||
                (piece.getChessBoard().squareThreatened(piece.getRow(), c, piece) == true))
            {
              return false;
            }
          }
          //6.) If none of these return false, a castle move is legal for this side and direction and move the rook to its new position
          return true;
        }
        
        //Check the following conditions if the king is moving west (on side north)
        if (toColumn < piece.getColumn())
        {
          //ChessPiece rook stores the chesspiece in the right corner of the board (from north's perspective)
          ChessPiece rook = piece.getChessBoard().getPiece(0, 0);
          //2.) If piece is not an instance of a rook, return false
          if (!(rook instanceof RookPiece))
          {
            return false;
          }
          //3.) Given this piece is an instance of a rook, if it is on the opposing side, return false
          if (!(piece.getSide().equals(rook.getSide())))
          {
            return false;
          }
          //4.) If the rook piece has moved before, return false
          if (rook.getHasMoved() == true)
          {
            return false;
          }
          //5.) 
          //Loop-Goal: Determine if there are any pieces between the input piece and the rook or any squares between the two are threatened, 
          //and if there are, return false
          for (int c = rook.getColumn() + 1; c < piece.getColumn(); c++)
          {
            if ((piece.getChessBoard().getPiece(piece.getRow(), c) != null) ||
                (piece.getChessBoard().squareThreatened(piece.getRow(), c, piece) == true))
            {
              return false;
            }
          }
          //6.) If all of these conditions fail, this castle move is legal for this side and direction
          //Set the new location for the rook at 
          return true;
        }
      }
      
      //If the king is on the south side, check the following conditions
      if (piece.getSide() == ChessGame.Side.SOUTH)
      {
        //Next, check for if the king is moving east
        if (toColumn > piece.getColumn())
        {
          //ChessPiece rook stores the chess piece in the right corner of the board (from north)
          ChessPiece rook = piece.getChessBoard().getPiece(piece.getChessBoard().getGameRules().getNumRows() - 1, piece.getChessBoard().getGameRules().getNumColumns() - 1);
          //2.) If piece is not an instance of a rook, return false
          if (!(rook instanceof RookPiece))
          {
            return false;
          }
          //3.) Given this piece is an instance of a rook, if it is on the opposing side, return false
          if (!(piece.getSide().equals(rook.getSide())))
          {
            return false;
          }
          //4.) If the rook piece has moved before, return false
          if (rook.getHasMoved() == true)
          {
            return false;
          }
          //5.) 
          //Loop-Goal: Determine if there are any pieces between the input piece and the rook or any squares between the two are threatened, 
          //and if so, return false
          for (int c = rook.getColumn() - 1; c > piece.getColumn(); c--)
          {
            if ((piece.getChessBoard().getPiece(piece.getRow(), c) != null) ||
                (piece.getChessBoard().squareThreatened(piece.getRow(), c, piece) == true))
            {
              return false;
            }
          }
          //6.) If none of these return false, a castle move is legal for this side and direction
          return true;
        }
        
        //Check if the piece is moving west
        if (toColumn < piece.getColumn())
        {
          //ChessPiece rook stores the chesspiece in the left corner of the board (from north's perspective)
          ChessPiece rook = piece.getChessBoard().getPiece(piece.getChessBoard().getGameRules().getNumRows() - 1, 0);
          //2.) If piece is not an instance of a rook, return false
          if (!(rook instanceof RookPiece))
          {
            return false;
          }
          //3.) Given this piece is an instance of a rook, if it is on the opposing side, return false
          if (!(piece.getSide().equals(rook.getSide())))
          {
            return false;
          }
          //4.) If the rook piece has moved before, return false
          if (rook.getHasMoved() == true)
          {
            return false;
          }
          //5.) 
          //Loop-Goal: Determine if there are any pieces between the input piece and the rook or any squares between the two are threatened, 
          //and if there are, return false
          for (int c = rook.getColumn() + 1; c < piece.getColumn(); c++)
          {
            if ((piece.getChessBoard().getPiece(piece.getRow(), c) != null) ||
                (piece.getChessBoard().squareThreatened(piece.getRow(), c, piece) == true))
            {
              return false;
            }
          }
          //6.) If all of these conditions fail, this castle move is legal for this side and direction
          return true;
        }
      }
      //Return statements are in the if statement blocks
    }
    //If the initial conditions fails, return false
    return false;
  }

}
      