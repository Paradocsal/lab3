import Map2.Prostranstvo;
import entities.Karlson;
import items.birch_firewood;
import items.*;
public class MainSergg {
    public static void main(String[] args){
        Karlson Karl= new Karlson(1,1);
        fireplace Fireplace = new fireplace(15,15,"MyFieplace",true,50);
        birch_firewood birch = new birch_firewood(5,1,"birch",2);
        kerosine_lamp Lamp = new kerosine_lamp(20,20,"Kerosine_lamp",false,50);
        workbench WorkBench = new workbench(5,10,4,8,"Верстак"); //learn to map big objects
        Tool Hammer = new Tool(2,6,"Myhammer","To provide strong blunt force");
        Tool Scissors = new Tool(1,6,"Myscissors","To cut through surfaces");
        WorkBench.addItem(Hammer, 1);
        WorkBench.addItem(Scissors, 2);
        room Room = new room();
        //Karl.go

        Prostranstvo Map = new Prostranstvo();
        Map.AddOnMap(Lamp);

        Map.AddMultlObjOnMap(WorkBench);
        Map.AddOnMap(birch);
        Map.ShowMap();
        Map.AddIstSveta(Fireplace,3);
        Fireplace.refuel(birch,1);
        Fireplace.refuel(birch);
        while(Fireplace.isActive()){
            Fireplace.burn_fuel();
            //Fireplace.emitLight(Light_map);
        }
        //change lighting
        //Karlson go to lamp
        //Lamp.Activate();
        //Lamp.burn_fuel();
        //Lamp.emitLight(Light_map);
        //change lighting
    }

}
