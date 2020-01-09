package items;

public interface depletable_interface {
    void refuel(firewood burnTime, int amount);
    void refuel(firewood burnTime);
    boolean fueled();
    int getFuel_amount();
    int getMaxCapacity();
}
