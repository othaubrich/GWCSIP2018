int y= 200;
int x= 100;
boolean moveLeft;
void setup(){
  size(500,400);
  frameRate(24);
}
void draw(){
    background(255);
    fill(255,0,0);
    rect(x,y,100,40);
    moveRect();
}
   
   
void moveRect(){
  if(x==100){
    moveLeft=false;
  }
  if(x==width-140){
    moveLeft=true;
  }
  if(moveLeft==true){
    x-=2;
  }
  if(moveLeft==false){
    x+=2;
  }
}
