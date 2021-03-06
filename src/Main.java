import java.util.Calendar;
import java.util.Scanner;

import org.overture.codegen.runtime.MATH;

import Hitori.Board;
import Hitori.Cell.Coord;
import Hitori.Player;
import Hitori.Rules;

public class Main {

	private static Player player;
	private static Rules rules;
	private static Board board;

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		MATH.srand(cal.getTimeInMillis());
		Scanner s = new Scanner(System.in);
		int input = 0;
		int x = 0;
		int y = 0;
		boolean whileController = false;
		boolean whileControllerInt = false;

		while(whileController == false)
		{
			whileControllerInt = false;
			System.out.println("1 - Criar Tabuleiro");
			System.out.println("2 - Sair");
			input = s.nextInt();
			switch(input)
			{
			case 1:
				System.out.println("Escolha a dimens�o do tabuleiro (3-12)");
				int n = s.nextInt();
				System.out.println("\n");
				rules = new Rules();
				board = new Board(n, rules);
				player = new Player(board, rules);

				System.out.print("  y");
				for(int i = 0; i < n; i++)
				{
					if(i == 0)
						System.out.print("");
					System.out.print(String.format(" %3d", i));
				}
				System.out.println("");
				System.out.print("x +");
				for(int i = 0; i < n; i++)
				{
					if(i == 0)
						System.out.print("");
					System.out.print(String.format(" %3s", "-"));
				}
				System.out.println("");
				for(int i = 0; i < n; i++)
				{
					for(int j = 0; j < n; j++)
					{
						if(j == 0)
						{
							if(i < 10)
								System.out.print(i + " |");
							else
								System.out.print(i + "|");
						}
						System.out.print(String.format(" %3d", board.getCellOfBoard(new Coord(i, j)).getNumber()));
					}
					System.out.println(" ");
				}
				System.out.println("\n");
				while(whileControllerInt == false)
				{
					System.out.println("1 - Jogar");
					System.out.println("2 - Acabar");
					System.out.println("3 - Voltar atras\n");

					input = s.nextInt();
					switch(input)
					{
					case 1: 
						System.out.println("Escolha as coordenadas onde pretende jogar");
						System.out.println("Escolha a coordenada dos xx");
						x = s.nextInt();
						System.out.println("Escolha a coordenada dos yy");
						y = s.nextInt();
						System.out.println("\n");
						player.play(new Coord(x,y));
						break;

					case 2:
						if(player.checkWin())
						{
							System.out.println("Tabuleiro bem completado\n");
							whileControllerInt = true;
						}
						else
							System.out.println("Tabuleiro mal completado. Por favor tente outra vez.\n");
						break;

					default:
						whileControllerInt = true;
						break;
					}
					
					if(whileControllerInt == true)
						break;

					System.out.print("  y");
					for(int i = 0; i < n; i++)
					{
						if(i == 0)
							System.out.print("");
						System.out.print(String.format(" %3d", i));
					}
					System.out.println("");
					System.out.print("x +");
					for(int i = 0; i < n; i++)
					{
						if(i == 0)
							System.out.print("");
						System.out.print(String.format(" %3s", "-"));
					}
					System.out.println("");
					for(int i = 0; i < n; i++)
					{
						for(int j = 0; j < n; j++)
						{
							if(j == 0)
							{
								if(i < 10)
									System.out.print(i + " |");
								else
									System.out.print(i + "|");
							}
							if(board.getCellOfBoard(new Coord(i,j)).color == Hitori.quotes.WHITEQuote.getInstance())
								System.out.print(String.format(" %3d", board.getCellOfBoard(new Coord(i, j)).getNumber()));
							else
								System.out.print(String.format(" %3s", "#"));
						}
						System.out.println(" ");
					}
					System.out.println("\n");
				}
				break;

			case 2:
				whileController = true;
				break;
				
			//TODO evitar stack overflow
			}
		}		
	}
}
