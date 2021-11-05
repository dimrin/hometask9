package ua.ithillel.current;

public class TicTacToe {

    private static final char EMPTY_SYMBOL = '-';
    private int playerScore;
    private int computerScore;

    private final char[][] field = {
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
    };

    public void start() {
        gamePlaying();
    }

    private void doMove(CoordinateFinder coordinateFinder) {
        MoveResult moveResult;
        Coordinate coordinate;

        do {
            moveResult = coordinateFinder.findCoordinate();
            coordinate = moveResult.getCoordinate();
        } while (field[coordinate.getVertical()][coordinate.getHorizontal()] != EMPTY_SYMBOL);

        field[coordinate.getVertical()][coordinate.getHorizontal()] = moveResult.getSymbol();
    }

    private void drawField() {
        for (char[] chars : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(chars[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void playerWinCheck() {
        if (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X') {
            playerScore++;
        }
        if (field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X') {
            playerScore++;
        }
        if (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') {
            playerScore++;
        }
        if (field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') {
            playerScore++;
        }
        if (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') {
            playerScore++;
        }
        if (field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') {
            playerScore++;
        }
        if (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') {
            playerScore++;
        }
        if (field[2][0] == 'X' && field[1][1] == 'X' && field[0][2] == 'X') {
            playerScore++;
        }
    }
    
    private void AIlWinCheck() {
        if (field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O') {
            computerScore++;
        }
        if (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O') {
            computerScore++;
        }
        if (field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O') {
            computerScore++;
        }
        if (field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O') {
            computerScore++;
        }
        if (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') {
            computerScore++;
        }
        if (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') {
            computerScore++;
        }
        if (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') {
            computerScore++;
        }
        if (field[2][0] == 'O' && field[1][1] == 'O' && field[0][2] == 'O') {
            computerScore++;
        }
    }

    private boolean tieCheck() {
        if (field[0][0] != EMPTY_SYMBOL && field[0][1] != EMPTY_SYMBOL && field[0][2] != EMPTY_SYMBOL && field[1][0] != EMPTY_SYMBOL &&
                field[1][1] != EMPTY_SYMBOL && field[1][2] != EMPTY_SYMBOL && field[2][0] != EMPTY_SYMBOL && field[2][1] != EMPTY_SYMBOL && field[2][2] != EMPTY_SYMBOL) {
            System.out.println("Its a tie");
            return true;
        }
        return false;
    }

    private void gamePlaying() {
        CoordinateFinder playerMoveAction = new PlayerCoordinateFinder();
        CoordinateFinder aiMoveAction = new AICoordinateFinder();
        do {
            drawField();
            doMove(playerMoveAction);
            doMove(aiMoveAction);
            winCheck();
            tieCheck();
        } while (winCheck() && !tieCheck());

    }

    private boolean winCheck() {
        for (int i = 0; i < field.length; i++) {
            playerWinCheck();
            AIlWinCheck();
            if (playerScore > 0) {
                drawField();
                System.out.println("Player Wins");
                return false;
            } else if (computerScore > 0) {
                drawField();
                System.out.println("Computer Wins");
                return false;
            }
        }
        return true;
    }

}
