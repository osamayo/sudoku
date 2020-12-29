package sudoku;

public class SudokuValidator {
	
	private Integer game[][] = new Integer[9][9];

	
	public SudokuValidator(Integer game[][])
	{
		this.game=game;
	}
	
	boolean ValidGrid()
	{
		if (game.length==9)
		{
			for (int i=0; i<9; i++)
			{
				if (game[i].length!=9)
				{
					return false;
				}
			}
		} else 
		{
			return false;
		}
		
		return true;
	}
	
	public boolean ValidGame()
	{
		for (int i=0; i<9; i++)
		{
			for (int x=0; x<9; x++)
			{
				// for each number in grid
				if (!ValidNum(game[i][x], i, x))
				{
				    System.out.println("i: " + String.valueOf(i)+",x: " + String.valueOf(x));
					return false;
				}
					
			}
		}
		return true;
	}
	
	boolean ValidNum(int num, int row, int column)
	{
		//check row numbers
		for (int i=0; i<9; i++)
		{
			if(i==column)
				continue;
			else if (num==game[row][i] && num!=0)
			{
			    System.out.println("num: "+String.valueOf(num)+", row: " + String.valueOf(row) + ", column: " + String.valueOf(column) + ", i: "+String.valueOf(i));
				return false;
			}
		}
		
		// check column numbers
		for (int i=0; i<9; i++)
		{
			if (i==row)
				continue;
			else if (num==game[i][column] && num!=0)
			{
				System.out.println("num: "+String.valueOf(num)+", row: " + String.valueOf(row) + ", column: " + String.valueOf(column) + ", i: "+String.valueOf(i));
				return false;
			}
		}
		
		// check square numbers
		if (row<3 && column<3)
		{
			// square one
			if (!CheckSquareNums(num, row, column, 0, 2, 0, 2))
				return false;
		} else if(row<3 && column<6)
		{
			// square two
			if (!CheckSquareNums(num, row, column, 0, 2, 3, 5))
				return false;
		} else if (row<3 && column<9)
		{
			// square three
			if (!CheckSquareNums(num, row, column, 0, 2, 6, 8))
				return false;
		} else if (row<6 && column<3)
		{
			// square four
			if (!CheckSquareNums(num, row, column, 3, 5, 0, 2))
				return false;
		} else if (row<6 && column<6)
		{
			// square five
			if (!CheckSquareNums(num, row, column, 3, 5, 3, 5))
				return false;
		} else if (row<6 && column<9)
		{
			// square six
			if (!CheckSquareNums(num, row, column, 3, 5, 6, 8))
				return false;
		} else if (row<9 && column<3)
		{
			// square seven
			if (!CheckSquareNums(num, row, column, 6, 8, 0, 2))
				return false;
		} else if (row<=9 && column<=6)
		{
			// square eight
			if (!CheckSquareNums(num, row, column, 6, 8, 3, 5))
				return false;
		} else if (row<=9 && column<=9)
		{
			// square nine
			if (!CheckSquareNums(num, row, column, 6, 8, 6, 8))
				return false;
		}
		
		return true;
	}
	
	boolean CheckSquareNums(int num, int numRow, int numColumn, int RowStart, int RowEnd, int ColumnStart, int ColumnEnd)
	{
		for (int i=RowStart; i<=RowEnd; i++)
		{
			for (int x=ColumnStart; x<=ColumnEnd; x++)
			{
				if (i==numRow && x==numColumn)
					continue;
				else if (num==game[i][x] && num!=0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
}
