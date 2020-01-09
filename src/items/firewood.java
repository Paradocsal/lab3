package items;

abstract class firewood extends items{
    //size - 1 to 3
    protected int size;
    public firewood(int x,int y,String name,int size){
        super(x,y,name);
        this.size = size;
    }
    public int getBurntime() {
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }
}
