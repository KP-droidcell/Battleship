import java.util.ArrayList;
import java.util.Random;

public class BSBoardMaker
{
        final static int ROWS = 10;
        final static int COLS = 10;
        final static int HORIZONTAL = 0;
        final static int VERTICAL = 1;

        final static String EMPTY = " ";
        final static String MISS = "M";
        final static String HIT = "X";

        static String bsBoard[][] = new String[ROWS][COLS];
        static Random rndGen = new Random();
        static final int shipSet[] = {5, 4, 3, 3};

        public static void main(String[] args) {
            blankBoard();
            generateBoard();
            showBoard();
        }

        private static void blankBoard()
            {
                for (int r = 0; r < ROWS; r++)
                    for(int c = 0; c < COLS; c++)
                        bsBoard[r][c] = " ";
            }

        private static void generateBoard() {
            boolean shipFits = true;
            boolean shipPlaced = false;
            int orrientation = 0;
            int rowCol = 0;
            int startPlacement = 0;

            ArrayList<Integer> lociSet = new ArrayList<>();

            for (int ship : shipSet) {
                System.out.println("Trying to place ship" + ship);
                shipPlaced = false;
                while (!shipPlaced) {
                    orrientation = rndGen.nextInt(2);
                    rowCol = rndGen.nextInt(ROWS);
                    lociSet.clear();
                    shipFits = true;

                    System.out.println("\tOrrientation: " + orrientation);
                    System.out.println("\tRowCol; " + rowCol);

                    for (int locus = 0; locus <= ROWS - ship; locus++) {
                        int startLocus = locus;
                        int endLocus = startLocus + ship - 1;

                        shipFits = true;

                        for (int c = startLocus; c <= endLocus; c++)
                            if (orrientation == HORIZONTAL) {
                                if (!bsBoard[rowCol][c].equals(" ")) {
                                    shipFits = false;
                                    break;
                                }
                            } else {
                                if (!bsBoard[c][rowCol].equals(" ")) {
                                    shipFits = false;
                                    break;
                                }
                            }
                        if (shipFits) {
                            lociSet.add(startLocus);
                            System.out.println("\t\tAdding locus " + startLocus + " for ship " + ship);
                        }
                    }
                    if (!lociSet.isEmpty()) {
                        startPlacement = lociSet.get(rndGen.nextInt(lociSet.size()));
                        System.out.println("Ship " + ship + " placed at startlocus: " + startPlacement);
                    }
                    if (orrientation == HORIZONTAL) {
                        for (int p = startPlacement; p < startPlacement + ship; p++) {
                            bsBoard[rowCol][p] = "" + ship;
                        }
                    } else {
                        for (int p = startPlacement; p < startPlacement + ship; p++) {
                            bsBoard[p][rowCol] = "" + ship;
                        }
                    }
                    shipPlaced = true;
                }
            }
        }
        private static void showBoard()
        {
            for(int r = 0; r < ROWS; r++)
            {
                for(int c = 0; c < COLS; c++)
                {
                  if(bsBoard[r][c].equals(" "))
                  {
                      System.out.println(". ");
                  }
                  else
                  {
                      System.out.println(bsBoard[r][c] + " ");
                  }
                }
                System.out.println();
            }
        }
    }
