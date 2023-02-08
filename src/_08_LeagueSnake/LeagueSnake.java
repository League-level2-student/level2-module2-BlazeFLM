package _08_LeagueSnake;

import java.awt.Color;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 800;

	/*
	 * Game variables
	 * 
	 * Put all the game variables here.
	 */
	Segment head;
	int foodX;
	int foodY;
	int direction = UP;
	int foodEaten;

	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */
	@Override
	public void settings() {
		size(500, 500);
	}

	@Override
	public void setup() {
		head = new Segment(250, 250);
		frameRate(20);
		dropFood();
	}

	void dropFood() {
		// Set the food in a new random location
		foodX = ((int) random(50) * 10);
		foodY = ((int) random(50) * 10);
	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */
	
	@Override
	public void draw() {
		background(0, 0, 0);
		drawFood();
		move();
		drawSnake();
		eat();
	}

	void drawFood() {
		// Draw the food
		fill(255, 0, 0);
		rect(foodX, foodY, 10, 10);
	}

	void drawSnake() {
		// Draw the head of the snake followed by its tail
		fill(0, 255, 0);
		rect(head.x, head.y, 10, 10);
		drawTail();
	}

	void drawTail() {
		// Draw each segment of the tail
		//for(Segment s: )
	}

	/*
	 * Tail Management methods
	 * 
	 * These methods make sure the tail is the correct length.
	 */

	void manageTail() {
		// After drawing the tail, add a new segment at the "start" of the tail and
		// remove the one at the "end"
		// This produces the illusion of the snake tail moving.

	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
		
	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		// Set the direction of the snake according to the arrow keys pressed
		if(key == CODED) {
			if(keyCode == UP) {
				direction = UP;
			} else if(keyCode == DOWN) {
				direction = DOWN;
			} else if(keyCode == LEFT) {
				direction = LEFT;
			} else if(keyCode == RIGHT) {
				direction = RIGHT;
			}
		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.

		if (direction == UP) { // Move head up
			head.y -= 5;
		} else if (direction == DOWN) { // Move head down
			head.y += 5;
		} else if (direction == LEFT) {
			head.x -= 5;
		} else if (direction == RIGHT) {
			head.x += 5;
		}

	}

	void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side
		if(head.x > 500){
			head.x = 0;
		} else if(head.x < 0) {
			head.x = 500;
		} else if(head.y > 500) {
			head.y = 0;
		} else if(head.y < 0) {
			head.y = 500;
		}
	}

	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear
		
		if((head.x == foodX) && (head.y == foodY)) {
			foodEaten++;
			dropFood();
		}
	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
