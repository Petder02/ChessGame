import javafx.scene.control.Button;
//TODO: Implement a stopping condition for the application (i.e. when the King of the opposing side is captured, end the game and maybe display a message)

/**
 * 
 * An interface representative of a features of a ChessBoard display in JavaFX
 * @author Peter Schlueter
 * 
 */
public interface JavaFXChessBoardDisplay
{
  
  /**
   * Displays a empty Button at a given row and column of the board
   * @param button   the button which will be displayed on the board
   * @param row      the row at which the button will be displayed on the board
   * @param column   the column at which the button will be displayed on the board
   */
  public void displayEmptySquare(Button button, int row, int column);
  
  /**
   * Displays a Button which has its space filled by a piece at a given row and column of the board
   * @param button   the button which will be displayed that has a piece on it
   * @param row      the row at which the button will be displayed on the board
   * @param column   the column at which the button will be displayed on the board
   * @param piece    the piece which will be displayed on a given button on the board
   */
  public void displayFilledSquare(Button button, int row, int column, ChessPiece piece);
  
  /**
   * Highlights the square at the given row and column with a piece on it
   * or unhighlights a square currently highlighted at the given row and column which has a piece on it
   * @param highlight  whether or not a given square is currently highlighted
   * @param button     the button which will be highlighted or unhighlighted on the board
   * @param row        the row of the board on which the button resides
   * @param column     the column of the board on which the button resides
   * @param piece      the piece on the board at the given row and column
   */
  public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece);
  
}