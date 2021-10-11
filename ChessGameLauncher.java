/**
 * 
 * A class which launches a game of Indo-European Chess 
 * for the Java Swing package/graphics library
 * @author Peter Schlueter
 * @version 2.0
 * 
 */
public class ChessGameLauncher
{
  
  /** 
   * Launches a game of chess using the Java Swing package/graphics library
   */
  public static void launchSwingChessGame()
  {
    //EuropeanChess gameRules stores the basic rules for this chess game
    EuropeanChess gameRules = new EuropeanChess();
  
    //EuropeanChessDisplay boardDisplay stores a chess board display instance
    SwingEuropeanChessDisplay boardDisplay = new SwingEuropeanChessDisplay();
  
    //ChessBoard board stores the chess game board
    //Note: This is a normal sized chess board, being 8 squares x 8 squares
    ChessBoard board = new SwingChessBoard(boardDisplay, gameRules);
  
    //Sets up the chessboard for a game of Indo-European chess using a Java Swing display
    gameRules.startGame(board);
  }
  
}
  
/*
 * The following code is from the previous version of this class (from Project 3),
 * please do not use it in the final grading of this class
 */

  /* The piece's initial positions on the board are being created under the assumption that this is a typical chess board (8 squares x 8 squares),
   * the two player sides are NORTH and SOUTH, and NORTH starts at row 0 and SOUTH starts at row 7 */
  
  /* Instanciate and place all pieces of the NORTH side on the board */
  /*
  //Instanciates a NORTH rook chess piece at its starting position
  ChessPiece northRook1 = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
  //Instanciates a NORTH knight chess piece at its starting position
  ChessPiece northKnight1 = new KnightPiece(ChessGame.Side.NORTH, 0, 1, board);
  //Instanciates a NORTH bishop chess piece at its starting position
  ChessPiece northBishop1 = new BishopPiece(ChessGame.Side.NORTH, 0, 2, board);
  //Instanciates a NORTH queen chess piece at its starting position
  ChessPiece northQueen = new QueenPiece(ChessGame.Side.NORTH, 0, 3, board);
  //Instanciates a NORTH king chess piece at its starting position
  ChessPiece northKing = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
  //Instanciates a NORTH bishop chess piece at its starting position
  ChessPiece northBishop2 = new BishopPiece(ChessGame.Side.NORTH, 0, 5, board);
  //Instanciates a NORTH knight chess piece at its starting position
  ChessPiece northKnight2 = new KnightPiece(ChessGame.Side.NORTH, 0, 6, board);
  //Instanciates a NORTH rook chess piece at its starting position
  ChessPiece northRook2 = new RookPiece(ChessGame.Side.NORTH, 0, 7, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn1 = new PawnPiece(ChessGame.Side.NORTH, 1, 0, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn2 = new PawnPiece(ChessGame.Side.NORTH, 1, 1, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn3 = new PawnPiece(ChessGame.Side.NORTH, 1, 2, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn4 = new PawnPiece(ChessGame.Side.NORTH, 1, 3, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn5 = new PawnPiece(ChessGame.Side.NORTH, 1, 4, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn6 = new PawnPiece(ChessGame.Side.NORTH, 1, 5, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn7 = new PawnPiece(ChessGame.Side.NORTH, 1, 6, board);
  //Instanciates a NORTH pawn chess piece at its starting position
  ChessPiece northPawn8 = new PawnPiece(ChessGame.Side.NORTH, 1, 7, board);
  //Adds the pieces on the NORTH side to the board
  board.addPiece(northRook1, 0, 0);
  board.addPiece(northKnight1, 0, 1);
  board.addPiece(northBishop1, 0, 2);
  board.addPiece(northQueen, 0, 3);
  board.addPiece(northKing, 0, 4);
  board.addPiece(northBishop2, 0, 5);
  board.addPiece(northKnight2, 0, 6);
  board.addPiece(northRook2, 0, 7);
  board.addPiece(northPawn1, 1, 0);
  board.addPiece(northPawn2, 1, 1);
  board.addPiece(northPawn3, 1, 2);
  board.addPiece(northPawn4, 1, 3);
  board.addPiece(northPawn5, 1, 4);
  board.addPiece(northPawn6, 1, 5);
  board.addPiece(northPawn7, 1, 6);
  board.addPiece(northPawn8, 1, 7);
  */
  /* Instanciate and place all pieces of the SOUTH side of the board */
  /*
  //Instanciates a SOUTH rook chess piece at its starting position
  ChessPiece southRook1 = new RookPiece(ChessGame.Side.SOUTH, 7, 0, board);
  //Instanciates a SOUTH knight chess piece at its starting position
  ChessPiece southKnight1 = new KnightPiece(ChessGame.Side.SOUTH, 7, 1, board);
  //Instanciates a SOUTH bishop chess piece at its starting position
  ChessPiece southBishop1 = new BishopPiece(ChessGame.Side.SOUTH, 7, 2, board);
  //Instanciates a SOUTH queen chess piece at its starting position
  ChessPiece southQueen = new QueenPiece(ChessGame.Side.SOUTH, 7, 3, board);
  //Instanciates a SOUTH king chess piece at its starting position
  ChessPiece southKing = new KingPiece(ChessGame.Side.SOUTH, 7, 4, board);
  //Instanciates a SOUTH bishop chess piece at its starting position
  ChessPiece southBishop2 = new BishopPiece(ChessGame.Side.SOUTH, 7, 5, board);
  //Instanciates a SOUTH knight chess piece at its starting position
  ChessPiece southKnight2 = new KnightPiece(ChessGame.Side.SOUTH, 7, 6, board);
  //Instanciates a SOUTH rook chess piece at its starting position
  ChessPiece southRook2 = new RookPiece(ChessGame.Side.SOUTH, 7, 7, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn1 = new PawnPiece(ChessGame.Side.SOUTH, 6, 0, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn2 = new PawnPiece(ChessGame.Side.SOUTH, 6, 1, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn3 = new PawnPiece(ChessGame.Side.SOUTH, 6, 2, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn4 = new PawnPiece(ChessGame.Side.SOUTH, 6, 3, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn5 = new PawnPiece(ChessGame.Side.SOUTH, 6, 4, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn6 = new PawnPiece(ChessGame.Side.SOUTH, 6, 5, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn7 = new PawnPiece(ChessGame.Side.SOUTH, 6, 6, board);
  //Instanciates a SOUTH pawn chess piece at its starting position
  ChessPiece southPawn8 = new PawnPiece(ChessGame.Side.SOUTH, 6, 7, board);
  //Adds the pieces on the SOUTH side to the board
  board.addPiece(southRook1, 7, 0);
  board.addPiece(southKnight1, 7, 1);
  board.addPiece(southBishop1, 7, 2);
  board.addPiece(southQueen, 7, 3);
  board.addPiece(southKing, 7, 4);
  board.addPiece(southBishop2, 7, 5);
  board.addPiece(southKnight2, 7, 6);
  board.addPiece(southRook2, 7, 7);
  board.addPiece(southPawn1, 6, 0);
  board.addPiece(southPawn2, 6, 1);
  board.addPiece(southPawn3, 6, 2);
  board.addPiece(southPawn4, 6, 3);
  board.addPiece(southPawn5, 6, 4);
  board.addPiece(southPawn6, 6, 5);
  board.addPiece(southPawn7, 6, 6);
  board.addPiece(southPawn8, 6, 7);
  */