
public enum GameIssue {

	WON,
	LOOSE,
	TIE;
	
	public String gameIssueMessage(boolean isGameOver) {

		String won_over = "\n > Congratulations! You won the game!\n";
		String won_not_over = "\n > You won this round! Keep it up!\n";
		String loose_over = "\n > Oops! You lost the game. Better luck next time!\n";
		String loose_not_over = "\n > You lost this round but it's not over yet!\n";
		String tie = "\n > It's a tie! Try again!\n > Replay the round...\n";

		switch (this) {
		
			case WON ->  {

                if (isGameOver) {
					return won_over;
				} else {
					return won_not_over;
				}               
            }

            case LOOSE ->  {

                if (isGameOver) {
                    return loose_over;
                } else {
                    return loose_not_over;
                }
            }
            default ->  {
                return tie;
    
            }
		}
	}
}
