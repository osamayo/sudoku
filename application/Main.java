package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
// import sudoku package
import sudoku.SudokuValidator;
import sudoku.SudokuSolutionValidate;

public class Main extends Application {

    private PseudoClass right = PseudoClass.getPseudoClass("right");
    private PseudoClass bottom = PseudoClass.getPseudoClass("bottom");
    
    TextField A0 = new TextField();
    TextField A1 = new TextField();
    TextField A2 = new TextField();
    TextField A3 = new TextField();
    TextField A4 = new TextField();
    TextField A5 = new TextField();
    TextField A6 = new TextField();
    TextField A7 = new TextField();
    TextField A8 = new TextField();
    TextField B0 = new TextField();
    TextField B1 = new TextField();
    TextField B2 = new TextField();
    TextField B3 = new TextField();
    TextField B4 = new TextField();
    TextField B5 = new TextField();
    TextField B6 = new TextField();
    TextField B7 = new TextField();
    TextField B8 = new TextField();
    TextField C0 = new TextField();
    TextField C1 = new TextField();
    TextField C2 = new TextField();
    TextField C3 = new TextField();
    TextField C4 = new TextField();
    TextField C5 = new TextField();
    TextField C6 = new TextField();
    TextField C7 = new TextField();
    TextField C8 = new TextField();
    TextField D0 = new TextField();
    TextField D1 = new TextField();
    TextField D2 = new TextField();
    TextField D3 = new TextField();
    TextField D4 = new TextField();
    TextField D5 = new TextField();
    TextField D6 = new TextField();
    TextField D7 = new TextField();
    TextField D8 = new TextField();
    TextField E0 = new TextField();
    TextField E1 = new TextField();
    TextField E2 = new TextField();
    TextField E3 = new TextField();
    TextField E4 = new TextField();
    TextField E5 = new TextField();
    TextField E6 = new TextField();
    TextField E7 = new TextField();
    TextField E8 = new TextField();
    TextField F0 = new TextField();
    TextField F1 = new TextField();
    TextField F2 = new TextField();
    TextField F3 = new TextField();
    TextField F4 = new TextField();
    TextField F5 = new TextField();
    TextField F6 = new TextField();
    TextField F7 = new TextField();
    TextField F8 = new TextField();
    TextField G0 = new TextField();
    TextField G1 = new TextField();
    TextField G2 = new TextField();
    TextField G3 = new TextField();
    TextField G4 = new TextField();
    TextField G5 = new TextField();
    TextField G6 = new TextField();
    TextField G7 = new TextField();
    TextField G8 = new TextField();
    TextField H0 = new TextField();
    TextField H1 = new TextField();
    TextField H2 = new TextField();
    TextField H3 = new TextField();
    TextField H4 = new TextField();
    TextField H5 = new TextField();
    TextField H6 = new TextField();
    TextField H7 = new TextField();
    TextField H8 = new TextField();
    TextField I0 = new TextField();
    TextField I1 = new TextField();
    TextField I2 = new TextField();
    TextField I3 = new TextField();
    TextField I4 = new TextField();
    TextField I5 = new TextField();
    TextField I6 = new TextField();
    TextField I7 = new TextField();
    TextField I8 = new TextField();
    
    TextField cells[][]= {{A0, A1, A2, A3, A4, A5, A6, A7, A8},
    		{B0, B1, B2, B3, B4, B5, B6, B7, B8},
    		{C0, C1, C2, C3, C4, C5, C6, C7, C8},
    		{D0, D1, D2, D3, D4, D5, D6, D7, D8},
    		{E0, E1, E2, E3, E4, E5, E6, E7, E8},
    		{F0, F1, F2, F3, F4, F5, F6, F7, F8},
    		{G0, G1, G2, G3, G4, G5, G6, G7, G8},
    		{H0, H1, H2, H3, H4, H5, H6, H7, H8},
    		{I0, I1, I2, I3, I4, I5, I6, I7, I8}};
    
    Integer puzzle[][] = {{5,3,0,0,7,0,0,0,0},
			{6,0,0,1,9,5,0,0,0},
			{0,9,8,0,0,0,0,6,0},
			{8,0,0,0,6,0,0,0,3},
			{4,0,0,8,0,3,0,0,1},
			{7,0,0,0,0,0,0,0,6},
			{0,6,0,0,0,0,2,8,0},
			{0,0,0,4,1,9,0,0,5},
			{0,0,0,0,5,0,0,7,9}};
    
    
    Integer solution[][] = new Integer[9][9];

    Button ClearButton = new Button();
    Button MakePuzzle = new Button();
    Button SetPuzzle = new Button();
    Button CheckSolution = new Button();

    
    @Override
    public void start(Stage primaryStage) {

        GridPane board = new GridPane();

        // create sudoku text fields
        
        for (int i=0; i<9; i++)
        {
        	for (int x=0; x<9; x++)
        	{
        		CreateSudokuTextField(cells[i][x], i, x, board);
        	}
        }

        
        
        ClearButton.setText("Clear");
        MakePuzzle.setText("Make Puzzle");
        SetPuzzle.setText("Set Puzzle");
        CheckSolution.setText("Check Solution");
        
        board.add(ClearButton, 1, 9, 2, 1);
        board.add(MakePuzzle, 2, 9, 2, 1);
        board.add(SetPuzzle, 4, 9, 2, 1);
        board.add(CheckSolution, 6,  9, 3, 1);
        
        
        Scene scene = new Scene(board);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Sudoku");
        primaryStage.show();
        
        // showing the main game
        for (int i=0; i<9; i++)
        {
        	for (int x=0; x<9; x++)
        	{
        		if (puzzle[i][x]!=0)
        		{
        			cells[i][x].setText(String.valueOf(puzzle[i][x]));
        			cells[i][x].setDisable(true);
        		}
        	}
        }
        
        // Buttons Events
        ClearButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        		{
        			@Override
        			public void handle(ActionEvent event)
        			{
        				clear();
        			}
        		});
        MakePuzzle.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				MakePuzzle();
			}
		});
        
        SetPuzzle.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				SetPuzzle();
			}
		});
        
        CheckSolution.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				CheckSolution();
			}
		});
        
        SetPuzzle.setDisable(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
    
    private void CreateSudokuTextField(TextField t, int row, int column, GridPane board)
    {
    	t.setTextFormatter(new TextFormatter<Integer>(c -> {
            if (c.getControlNewText().matches("\\d?")) {
            	if (c.getControlNewText().matches("0"))
            	{
            		return null;
            	} else
            	{
                    return c ;
            	}
            } else {
                return null ;
            }
        }));
    	
    	StackPane cell = new StackPane();
        cell.getStyleClass().add("cell");
    	
        cell.pseudoClassStateChanged(right, column == 2 || column == 5);
        cell.pseudoClassStateChanged(bottom, row == 2 || row == 5);

        cell.getChildren().add(t);


        board.add(cell, column, row);
    }
    
    private void clear()
    {
    	for (int i=0; i<9; i++)
        {
        	for (int x=0; x<9; x++)
        	{
        		cells[i][x].setText("");
        		cells[i][x].setDisable(false);
        		cells[i][x].setStyle("-fx-background-color: #FFFFFF;");
        	}
        }
    }
    
    private void MakePuzzle()
    {
    	for (int i=0; i<9; i++)
        {
        	for (int x=0; x<9; x++)
        	{
        		cells[i][x].setDisable(false);
        		cells[i][x].setStyle("-fx-background-color: #FFFFFF;");
        	}
        }
    	MakePuzzle.setDisable(true);
    	SetPuzzle.setDisable(false);
    }
    
    private void SetPuzzle()
    {
    	
    	// getting the puzzle
    	for (int i=0; i<9; i++)
        {
        	for (int x=0; x<9; x++)
        	{
        		if (cells[i][x].getText().strip().equals(""))
        		{
        			puzzle[i][x]=0;
        		} else 
        		{
        			puzzle[i][x] = Integer.valueOf(cells[i][x].getText());
        		}
        		
        	}
        }
    	// creating SudokuGame Object
    	SudokuValidator sudoku = new SudokuValidator(puzzle);
    	boolean valid = sudoku.ValidGame();
    	if (valid)
    	{
    		for (int i=0; i<9; i++)
            {
            	for (int x=0; x<9; x++)
            	{
            		if (puzzle[i][x]!=0)
            		{
            			cells[i][x].setDisable(true);
            		}
            	}
            }
    		
    		MakePuzzle.setDisable(false);
        	SetPuzzle.setDisable(true);
    		
    	} else 
    	{
    		// showing the user a message
    		Alert a = new Alert(Alert.AlertType.INFORMATION);
    		a.setContentText("Your Sudoku Puzzle Is Not Valid");
    		a.show();
    		
    	}
    }
    
    private void CheckSolution()
    {
    	// getting the grid
    	Integer grid[][] = new Integer[9][9];
    	
    	for (int i=0; i<9; i++)
        {
        	for (int x=0; x<9; x++)
        	{
        		if (cells[i][x].getText().strip().equals(""))
        		{
        			grid[i][x]=0;
        		} else 
        		{
        			grid[i][x] = Integer.valueOf(cells[i][x].getText());
        		}
        		
        	}
        }
    	
    	//getting the solution
    	for (int i=0; i<9; i++)
        {
        	for (int x=0; x<9; x++)
        	{
        		if (puzzle[i][x]==0)
        		{
        			solution[i][x]=grid[i][x];
        		} else 
        		{
        			solution[i][x]=0;
        		}
        	}
        }
    	
    	// checking the solution
    	
    	SudokuSolutionValidate game = new SudokuSolutionValidate(puzzle, solution);
    	boolean result[][] = new boolean[9][9];
    	result = game.SolutionValidate();
    	
    	
    	// showing the result
    	for (int i=0; i<9; i++)
		{
			for (int x=0; x<9; x++)
			{
				if (result[i][x]==true)
				{
					System.out.print("true ");
				} else 
				{
					System.out.print("false ");
				}
			}
			System.out.print("\n");
		}

		System.out.println("_______________________");

    	for (int i=0; i<9; i++)
    	{
    		for (int x=0; x<9; x++)
    		{
    			if (puzzle[i][x]==0)
    			{
    				if (result[i][x])
    				{
    					// green square
    					cells[i][x].setStyle("-fx-background-color: #41b62c;");
    				} else 
    				{
    					// red square
    					cells[i][x].setStyle("-fx-background-color: #d11616;");
    				}
    			}
    		}
    	}
    }

}
