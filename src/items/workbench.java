package items;
import Map2.*;
import java.util.ArrayList;

public class workbench extends items {
    //items on it? !LIST! add/remove
    // SIZE??
    private ArrayList<items> ItemList = new ArrayList<items>();
    public workbench(int x,int y,String name){
        super(x,y,name);
    }
    public workbench(int x1,int x2,int y1,int y2,String name){
        super(x1,x2,y1,y2,name);

    }

    public void addItem(items Item,int workbenchX){
        Item.setPosition(workbenchX,this.getY()+1);
        ItemList.add(Item);
        System.out.println("Added to the bench !");
    }
    public ArrayList<items> getItemlist(){
        return ItemList;
    }
    public void removeItem(items Item){
        ItemList.remove(Item);
        System.out.println("Removed from the bench !");
    }
}
