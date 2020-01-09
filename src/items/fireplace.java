package items;

public class fireplace extends depletable_light_source {
    private String type = "Fireplace";
    public fireplace(int x,int y,String name, boolean isLIT, int fuel_amount,int maxCapacity) {
        super(x,y, name,isLIT, fuel_amount, maxCapacity);
    }

    @Override
    public String getType() {
        return type;
    }
    public int getHowPowerful(){
        return 10;
    }
    public fireplace(int x, int y, String name,boolean isLIT, int fuel_amount) {
        super(x,y, name,isLIT, fuel_amount);
    }
}


