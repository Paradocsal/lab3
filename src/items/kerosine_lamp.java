package items;

public class kerosine_lamp extends depletable_light_source { // lets be in percent
    private String type = "Kerosine lamp";
    public kerosine_lamp(int x,int y,String name,boolean isLIT, int fuel_amount, int maxCapacity){
        super(x,y, name,isLIT, fuel_amount,maxCapacity);
    }
    //func for fuel amount change(fuel type)
    public kerosine_lamp(int x,int y,String name,boolean isLIT, int fuel_amount){
        super(x,y,name, isLIT, fuel_amount);
    }

    public int getHowPowerful(){
        return 3;
    }
    @Override
    public String getType() {
        return type;
    }
}
