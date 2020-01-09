package items;

public class birch_firewood extends firewood{
    private static int burniness = 10; //added time
    public birch_firewood(int x,int y, String name,int size){
        super(x,y,name, size);
    }
    @Override
    public int getBurntime() {
        return this.burniness*this.size;
    }
}// change string(size) to sth else

