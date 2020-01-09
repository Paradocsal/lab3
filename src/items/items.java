package items;

import Map2.KoordOfObj;

public abstract class items extends KoordOfObj {
    private int[] position = new int[2];
    public items(int y,int x,String name){
        super(x,y,name);

    }
    public items(String name){
        super(name);

    }
    public items(int x1,int x2,int y1,int y2,String name){
        super(x1, x2, y1, y2, name);
    }
//    public void setX(int x){
//        this.position[0] = x;
//    }
//    public void setY(int y){
//        this.position[0] = y;
//    }
    public void setPosition(int x,int y){
        this.position[0] = x;
        this.position[1] = y;
    }
//    public int getX(){
//        return position[0];
//    }
//    public int getY(){
//        return position[1];
//    }

    public int[] getPosition() {
        return position;
    }

}