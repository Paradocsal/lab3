package items;

public abstract class depletable_light_source extends light_source implements depletable_interface {
    protected int fuel_amount;
    protected int maxCapacity=100;
    public int HowPowerful;
    public int HowPowerful(){
        return HowPowerful;
    }
    public depletable_light_source(int x,int y,String name, boolean isLIT, int fuel_amount,int maxCapacity){
        super(x,y,name, isLIT);
        this.fuel_amount = fuel_amount;
        this.maxCapacity = maxCapacity;
    }
    public depletable_light_source(int x,int y,String name, boolean isLIT, int fuel_amount){
        super(x,y,name, isLIT);
        this.fuel_amount = fuel_amount;
    }
    public void refuel(firewood burnTime, int amount){
        if (this.fuel_amount + burnTime.getBurntime()*amount > this.maxCapacity){
            this.fuel_amount = this.maxCapacity;
            System.out.println("No room for any more fuel");
        }
        else {
            this.fuel_amount += burnTime.getBurntime()*amount;
        }
    }
    public void refuel(firewood burnTime){
        if (this.fuel_amount + burnTime.getBurntime() > this.maxCapacity){
            this.fuel_amount = this.maxCapacity;
            System.out.println("No room for any more fuel");
        }
        else {
            this.fuel_amount += burnTime.getBurntime();
        }
    }
    public boolean fueled(){
        if (this.fuel_amount > 0){
            return true;
        }
        else{
            this.Deactivate();
            return false;// to main
        }
    }
    @Override
    public boolean isActive(){
        return fueled() & super.isActive();
    }
    public int getFuel_amount(){
        return this.fuel_amount;
    }
    public void emitLight(){
        int a = 0;// dodelay
    }
    public void burn_fuel(){
        if (this.isActive()){
            this.fuel_amount -= 1;
            System.out.printf("%s is operational %n", getType());
        }
        else {
            System.out.println("Not lit or no fuel");
        }
    }
    public int getMaxCapacity(){
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }
}
