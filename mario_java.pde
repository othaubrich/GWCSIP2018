PImage square;
 
Mario myMario;
 
void setup() {
 size(800, 800);
 smooth();
 noStroke();
 square = loadImage("square.png"); 
 myMario = new Mario(0,575);
}
 
void draw() {
  background(0);   
  myMario.move();
  myMario.display(); 
}
 
//KEYBOARD INPUT
 
void keyPressed() {
  if (key == CODED) {
     if (keyCode == LEFT) {
       myMario.moveLeft = true;
       square = loadImage("square.png");
       square.resize(80,65);
 
     } else if(keyCode == RIGHT) {
       myMario.moveRight = true;
       square = loadImage("square.png");
       square.resize(80,65);
 
     } else if(keyCode == UP) {
       myMario.moveUp = true;
     }
  }
}
 
void keyReleased() {
  if (key == CODED) {
     if (keyCode == LEFT) {
       myMario.moveLeft = false;
       square = loadImage("square.png");
       square.resize(60,60);
     } else if(keyCode == RIGHT) {
       myMario.moveRight = false;
       square = loadImage("square.png");
       square.resize(60,60);
     } else if(keyCode == UP) {
       myMario.moveUp = false;
       myMario.moveDown = true;
     }
  }
}
 
//PLAYER CLASS
 
class Mario {
  float xPos;
  float yPos;
  float speed = 2;
  boolean moveLeft, moveRight, moveUp, moveDown = false;
 
  Mario(float x_in, float y_in) {
    xPos = x_in;
    yPos = y_in; 
  }
 
  void display() {
    fill(255);
    noStroke();
    image(square, xPos, yPos);
    square.resize(50,60);
  }
 
  void move() {
    if(moveLeft) xPos -= speed;
    if(moveRight) xPos += speed;
    if(moveUp) yPos -= speed*3;
    if(moveDown) yPos += speed*2;
    if (yPos >= 575) {
    moveDown = false;
    }  
  }
  }
