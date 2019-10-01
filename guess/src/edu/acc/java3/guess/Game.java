package edu.acc.java3.guess;

public class Game implements java.io.Serializable {
	private int range;
	private int answer;
	private int guesses;
	private int lastGuess;
	
	public Game() {}
	
	public Game(int range) {
		this.setRange(range);
		answer = 1 + (int)(Math.random() * range);
	}
	
	public void setRange(int range) {
		if (range < 0) throw new IllegalArgumentException("Range must be a positive integer");
		this.range = range;
	}
	
	public int getGuesses() { return guesses; }	
	public int getRange() { return range; }
	public int getAnswer() { return answer; }
	public int getLastGuess() { return lastGuess; }
	
	public int guess(int guess) {
		lastGuess = guess;
		guesses++;
		if (guess == answer) return 0;
		else if (guess < answer) return -1;
		else return 1;
	}
}