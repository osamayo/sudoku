package sudoku;

public class SudokuSolutionValidate {

	private Integer game[][] = new Integer[9][9];
	private Integer GameSolution[][] = new Integer[9][9];
	private SudokuValidator SudokuGame;
	private Integer SudokuGrid[][];
	
	public SudokuSolutionValidate(Integer game[][], Integer GameSolution[][])
	{
		
		for (int i=0; i<9; i++)
		{
			for (int x=0; x<9; x++)
			{
				this.game[i][x] = game[i][x];
				this.GameSolution[i][x]=GameSolution[i][x];
			}
		}
	}
	
	boolean SudokuValidate()
	{
		for (int i=0; i<9; i++)
		{
			for (int x=0; x<9; x++)
			{
				if (game[i][x]==GameSolution[i][x] && GameSolution[i][x]!=0)
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	void SudokuValidatorCreate()
	{
		Integer Sudoku[][]=this.game;
		for (int i=0; i<9; i++)
		{
			for (int x=0; x<9; x++)
			{
				if (GameSolution[i][x]!=0)
				{
					Sudoku[i][x]=GameSolution[i][x];
					
				}
			}
		}
		SudokuGrid=Sudoku;
		SudokuGame=new SudokuValidator(Sudoku);
	}
	
	public boolean[][] SolutionValidate()
	{
		boolean SolutionCorrect[][] = new boolean[9][9];
		SudokuValidatorCreate();
		for (int i=0; i<9; i++)
		{
			for (int x=0; x<9; x++)
			{
				int num = SudokuGrid[i][x];
				if (num==0)
				{
					SolutionCorrect[i][x]=false;
				} else if(!SudokuGame.ValidNum(num, i, x))
				{
					SolutionCorrect[i][x]=false;
				} else 
				{
					SolutionCorrect[i][x]=true;
				}
			}
		}
		return SolutionCorrect;
	}
	
	void PrintSudokuGrid()
	{
		SudokuValidatorCreate();
		System.out.println("Sudoku Grid:");
		for (int i=0; i<9; i++)
		{
			for (int x=0; x<9; x++)
			{
				int num = SudokuGrid[i][x];
				if (num==0)
				{
					System.out.print("  ");
				} else
				{
					System.out.print(String.valueOf(num)+" ");
				}
			}
			System.out.print("\n");
		}
	}
}
