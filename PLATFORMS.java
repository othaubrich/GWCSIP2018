int w = 800;
int h = 600;

int[][] blocks = {

  //boundary box
  {
    600, 600, 50, 20, 1
  }
  , 
  {
    0, h, w, 20, 1
  }
  , 
  {
    -21, 0, 20, h, 1
  }
  , 
  {
    w, 0, 20, h, 1
  }
  , 


  /*platforms*/

  {
    550, 550, 60, 20, 1
  }
  , 
  
  
 
};

void setup() {
  size(800, 600);

  noStroke();
  noSmooth();
  frameRate(30);
}

float psize=20;
float px=w-psize;
float py=h-psize;
float rx=px;
float ry=py;
float pxv=0;
float pyv=0;
float pspeed=5;
float gravity=0;

boolean dead = false;




boolean falling = true;
void blockUpdate() {
  for (int i = 0; i<blocks.length; i++) {

    fill(100);

    if (blocks[i][4]==0) {
      fill(0, 250, 0);
    }

    if (px+pxv+psize>blocks[i][0] && px+pxv<blocks[i][0]+blocks[i][2] && py+psize>blocks[i][1] && py<blocks[i][1]+blocks[i][3]) {
      if (blocks[i][4]==0) {
        dead=true;
      }
      pxv=0;
    }

    if (px+psize>blocks[i][0] && px<blocks[i][0]+blocks[i][2] && py+pyv+psize>blocks[i][1] && py<blocks[i][1]+blocks[i][3]) {
      if (blocks[i][4]==0) {
        dead=true;
      }

      pyv=0;
      gravity=0;
      falling = false;
    }

    if (px+psize>blocks[i][0] && px<blocks[i][0]+blocks[i][2] && py+psize>blocks[i][1] && py+pyv<blocks[i][1]+blocks[i][3]) {
      if (blocks[i][4]==0) {
        dead=true;
      }

      pyv=0;
      gravity=0;
    }

    rect(blocks[i][0], blocks[i][1], blocks[i][2], blocks[i][3]);
  }
}



boolean[] keys = new boolean[256];
void keyPressed() {
  keys[keyCode]=true;
};
void keyReleased() {
  keys[keyCode]=false;
};
void playerInput() {
  pxv=0;
  pyv=0;


  if (dead==false) {
    if (keys[UP] && falling==false) {
      gravity-=7;
    }
    if (keys[LEFT]) {
      pxv=-pspeed;
    }
    if (keys[RIGHT]) {
      pxv=pspeed;
    }
  }
  
  if(keys[82]){
    dead=false;
    px=rx;
    py=ry;
  }
  
  pyv+=gravity;
  gravity+=0.5;

  falling = true;
}
void playerUpdate() {
  px+=pxv;
  py+=pyv;
  
  fill(255, 0, 0);
  if(dead==true){
    fill(255,150,150);
  }
  rect(px, py, psize, psize);
}





void draw() {
  background(250);

  playerInput();
  blockUpdate();
  playerUpdate();

  fill(255, 0, 0);
  text(frameRate, 20, 20);
}
