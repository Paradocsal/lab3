package items;

public class SittableOnItem extends items {
    private String material;
    private String type;
    private int legNumber;
    private boolean isSatOn;
    public SittableOnItem(int x, int y,String name, String material, String type, int legNumber){
        super(x,y,name);
        this.material = material;
        this.type = type;
        this.legNumber = legNumber;
    }
    public boolean isSatOn(){
        return isSatOn;
    }
    public void sit(){
        this.isSatOn = true;
    }
    public void standup(){
        this.isSatOn = false;
    }
    //sit on it func
}
