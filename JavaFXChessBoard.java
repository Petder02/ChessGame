import java.util.List;
import java.io.*;
import javafx.application.Application.Parameters;
import javafx.application.Application;
import javafx.stage.Stage;              
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.application.Platform;

//TODO: If able, give the player a choice on whether or not each move should have a set deadline, and display the time that the player has remaining to make a move
/*
TODO: Another interesting potential idea: Make it so the player is able to play the chess game with a keyboard as well, with the following controls:
TODO: 1.) Be able to use the arrow keys to select the spot in which the player wants to place the piece
TODO: 2.) Select the piece that the user wants to play via the "enter" key
TODO: 3.) Repeat step 1, and when "enter" is pressed a second time, then check if a move can be made to the indicated square, and if so move the piece
TODO: In general, this is similar to what is already done by ChessAction, except it involves keyboard events rather than mouse events
 */

/**
 * 
 * A class which is representative of a ChessBoard, and is
 * an implementation of the ChessBoard class for JavaFX
 * @author Peter Schlueter
 * 
 */
public class JavaFXChessBoard extends Application implements ChessBoard
{
  
  private GridPane board;                        // the game board
  private Button[][] tiles;                      // the squares of the board
  private ChessPiece[][] pieces;                 // stores the pieces
  private ChessGame gameRules;                   // global rules for this particular game
  private JavaFXChessBoardDisplay boardDisplay;  // rules for how to draw the chess board
  
  /**
   * Sets the stage for the Chess game indicated by the command line arguments
   * @param primaryStage  the stage in which this ChessGame will be played on
   */
  public void start(Stage primaryStage)
  {
    try 
    {
      //Application.Parameters parameters stores the user inputted commandline arguments from launch()
      Application.Parameters parameters = getParameters();
      //List<String> gameType stores the game type specified by the user in the commandline arguments
      List<String> gameType = parameters.getRaw();
    
      //Determines which type of chess will be played this game and sets the title of the window based on the user's game selection
      if (gameType.get(0).equals("chess"))
      {
        gameRules = new EuropeanChess();
        boardDisplay = new JavaFXEuropeanChessDisplay();
        primaryStage.setTitle("European Chess");
      }
      if (gameType.get(0).equals("xiangqi"))
      {
        gameRules = new Xiangqi();
        boardDisplay = new JavaFXXiangqiChessDisplay();
        primaryStage.setTitle("Xiangqi");
      }
      /* I might add this so I will put it here for reference (Start) */
      //if (gameType.get(0).equals("shogi"))
      //{
        //gameRules = new Shogi();
        //boardDisplay = new JavaFXShogiDisplay();
      //}
      /* End of Section above */
    
      //Sets fields appropriately
      tiles = new Button[gameRules.getNumRows()][gameRules.getNumColumns()];
      pieces = new ChessPiece[gameRules.getNumRows()][gameRules.getNumColumns()];
      board = new GridPane();
      //Set the grid lines of the pane to be visible (I think it improves athetics)
      board.setGridLinesVisible(true);
      
      //EventHandler<ActionEvent> event stores the event handler for all buttons when a chess piece is clicked
      EventHandler<ActionEvent> event = new ChessEvent();
    
      //Loop-Goal: Fill the gridpane with a set of buttons, each with a chess event handler
      for (int r = 0; r < tiles.length; r++)
      {
        for (int c = 0; c < tiles[r].length; c++)
        {
          tiles[r][c] = new Button();
          //Resize the button, as by default, in my opinion, is too small
          tiles[r][c].setMinSize(100, 100);
          tiles[r][c].setOnAction(event);
          boardDisplay.displayEmptySquare(tiles[r][c], r, c);
          board.add(tiles[r][c], c, r);
          pieces[r][c] = null;
        }
      }
      
      //This segment handles if the user wishes to close the game when the user requests to close the game (i.e. attempts to exit the application)
      //EXTRA CREDIT FEATURE
      primaryStage.setOnCloseRequest(close -> {
        //Alert closeWindow stores an alert that will be displayed to the screen should the user request to close the application
        Alert closeWindow = new Alert(Alert.AlertType.CONFIRMATION,
                                      "Are you sure you want to close the game?",
                                      ButtonType.YES, ButtonType.NO);
        closeWindow.setTitle("Closing the Game");
        //Display the Alert to the screen, and if the user clicks a Button with a ButtonType of YES,
        //then the application should be closed and resources assocaited with it should be collected
        //If the user does not click a button of Type YES, then this event handler should be consumed
        //and the primary stage should be the only window displayed to the screen.
        closeWindow.showAndWait().ifPresent(request -> {
          if (request == ButtonType.YES)
          {
            Platform.exit();
          }
          else
          {
            close.consume();
          }
        });
      });

      //Scene playArea stores the scene which will be displayed to the user (i.e. the chessboard)
      Scene playArea = new Scene(board);
      gameRules.startGame(this);
      primaryStage.setScene(playArea);
      primaryStage.show();
    }
    //If an error occurs in the start method, print out an error message and trace the method call stack to see the origins of the error
    catch(Exception e)
    {
      System.out.println("There was an error in starting the game, and the error encountered is traced below.");
      e.printStackTrace();
    }
  }
  
  /**
   * Gets the rules of this type of Chess game
   * @return the rules of this type of Chess game
   */
  public ChessGame getGameRules()
  {
    return this.gameRules;
  }
  
  /**
   * Returns the number of rows in the board.
   * @return the number of rows
   */
  //public final int numRows() 
  //{
    //return tiles.length;
 // }
  
  /**
   * Returns the number of columns in the board.
   * @return the number of columns
   */
  //public final int numColumns() 
  //{
    //return tiles[0].length;
  //}
  
  
  /**
   * Adds a piece to the board at the indicated row and collumn
   * @param piece   the piece to be added to the board
   * @param row     the row in which the piece should be added
   * @param column  the column in which the piece should be added
   */
  public void addPiece(ChessPiece piece, int row, int column)
  {
    pieces[row][column] = piece;
    piece.setLocation(row, column);
    boardDisplay.displayFilledSquare(tiles[row][column], row, column, piece);
  }
  
  /**
   * Removes a piece from the board at the indicated position
   * @param row    the row which the piece should be removed from
   * @oaram column the column which the piece should be removed from
   * @return the piece which was removed from the board
   */
  public ChessPiece removePiece(int row, int column)
  {
    //ChessPiece removed stores the piece which will be removed from the board
    ChessPiece removed = pieces[row][column];
    pieces[row][column] = null;
    boardDisplay.displayEmptySquare(tiles[row][column], row, column);
    return removed;
  }
  
  /**
   * Checks if there is a piece at the indicated position on the board
   * @param row    the row which there may be a piece at
   * @param column the row which there may be a piece at
   * @return true if there is a piece at the indicated position, false otherwise
   */
  public boolean hasPiece(int row, int column)
  {
    return pieces[row][column] != null;
  }
  
  /**
   * Gets the piece at the indicated position on the board
   * @param row    the row on the board where there may be a piece
   * @param column the column on the board where there may be a piece
   * @return the piece at the indicated row and column, if one exists
   */
  public ChessPiece getPiece(int row, int column)
  {
    return pieces[row][column];
  }
  
  /**
   * Checks if the opposing player can make a legal capture move to
   * the indicated row and column on the board
   * @param row    the indicated row on the board
   * @param column the indicated column on the board
   * @param piece  the indicated piece which may or may not be threatened
   * @return true if the opposing player can make a legal capture move to
   *         the indicated row and column, false otherwise
   */
  public boolean squareThreatened(int row, int column, ChessPiece piece)
  {
    
    //Loop-Goal: Get the first row of the board
    for (int i = 0; i < pieces.length; i++) 
    {
      
      //Loop-Goal: Check if any pieces of the opposing side as piece
      //are able to make a legal capture move to row i and column j
      for (int j = 0; j < pieces[i].length; j++) 
      {
        if (hasPiece(i,j) && getPiece(i, j).getSide() != piece.getSide() &&
            getPiece(i, j).isLegalMove(row, column))
        {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * 
   * A class which defines properties of events which happen in the game
   * @author Peter Schlueter
   * 
   */
  private class ChessEvent implements EventHandler<ActionEvent> 
  {
    private boolean firstPick = true;  // if true, we a selecting a piece
    private int pieceRow;              // remember row of selected piece
    private int pieceCol;              // remember column of selected piece
    
    /** 
     * What we do when the user chooses the piece to move.
     * @param row the row of the chosen piece
     * @param col the column of the chosen piece
     */
    private void processFirstSelection(int row, int col) 
    {
      if ((pieces[row][col] != null) && 
          (gameRules == null || gameRules.legalPieceToPlay(pieces[row][col], row, col))) 
      {
        /*
         * if this is the first pick and a square with a piece was picked,
         * remember the piece's location and highlight the square.
         */
        pieceRow = row;
        pieceCol = col;
        boardDisplay.highlightSquare(true, tiles[row][col], row, col, pieces[row][col]);
        firstPick = false;
      }
    }
    
    /**
     * What we do when the user chooses the square to move the piece to.
     * @param row the row the piece will move to
     * @param col the column the piece will move to
     */
    private void processSecondSelection(int row, int col) 
    {
      // if the row and column of the piece are the same as the place the player intends to move the piece, do nothing
      if (row == pieceRow && col == pieceCol)
      {
        return;
      }
      
      //boolean moveMade stores a flag indicating the legality of a pieces intended move
      boolean moveMade = gameRules.makeMove(pieces[pieceRow][pieceCol], row, col);

      // if the move was made or if it was not made and the user select a new piece, then reset to choose a new move
      if (moveMade || gameRules.canChangeSelection(pieces[pieceRow][pieceCol], pieceRow, pieceCol)) 
      {
        boardDisplay.highlightSquare(false, tiles[pieceRow][pieceCol], pieceRow, pieceCol, pieces[pieceRow][pieceCol]);
        firstPick = true;
      }
    }
    
    /**
     *  Handle a button click.  The method alternates between selecting a piece
     *  and selecting any square.  After both are selected, the piece's 
     *  legalMove is called, and if the move is legal, the piece is moved.
     *  @param e   the event that triggered the method
     */
    public void handle(ActionEvent e) 
    {
      //System.out.println("Something happened here");
      Button b = (Button)e.getSource();
      int col = -1;
      int row = -1;
      
      // first find which button (board square) was clicked.
      for (int i = 0; i < tiles.length; i++) 
      {
        for (int j = 0; j < tiles[i].length; j++) 
        {
          if (tiles[i][j] == b) 
          {
            row = i;
            col = j;
            //System.out.println("Button row: " + i + "Button Column " + j);
          }
        }
      }
      
      if (firstPick) 
      {
        //System.out.println("First Selection");
        processFirstSelection(row, col);
      }
      else 
      {
        //System.out.println("Second Selction");
        processSecondSelection(row, col);
      }
    }
  }
  
  /**
   * Launches the chess game using the given commandline arguments
   * @param args the commandline arguemnts representing the users chess game selection
   */
  public static void main(String[] args)
  {
    Application.launch(args);
  }
    
    
}