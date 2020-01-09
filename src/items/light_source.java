package items;

import java.util.Objects;

public abstract class light_source extends items implements Light_interface {
    private boolean isLIT;
    private static String type;
    public light_source(int x, int y,String name, boolean isLIT){
        super(x,y,name);
        this.isLIT = isLIT;

    }
    public void SetType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void Activate(){
        this.isLIT = true;
    }
    public void Deactivate(){
        this.isLIT = false;
    }
    public boolean isActive(){
        return isLIT;
    }
//    public void emitLight(map map){
//        if (isLIT){
//            for (int i = 0;i<sizex;i++){
//                for (int j = 0;j<sizey;j++){
//                    if (((getX()+getY())-(i+j))<5){ // distance from light source to point
//                        map[i][j] = 7; //light intensity
//                    }
//                    if (((getX()+getY())-(i+j))<10){
//                        map[i][j] = 5;
//                    }
//                    if (((getX()+getY())-(i+j))<15){
//                        map[i][j] = 3;
//                    }
//                    if (((getX()+getY())-(i+j))<20){
//                        map[i][j] = 1;
//                    }
//                    if (((getX()+getY())-(i+j))<25){
//                        map[i][j] = 0;
//                    }
//                }
//            }*/
//        }//constant check -> recheck
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        light_source that = (light_source) o;
        return getX() == that.getX() && getY() == that.getY() && isLIT == that.isLIT && type.equals(that.type);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(getX(), getY());
        result = 31 * result + type.hashCode();
        result = 31 * result + Boolean.valueOf(isLIT).hashCode();
        return result;
    }
    @Override
    public String toString() {
        return ("Light source type is " + type + " and it is at x" + getX() + "y" + getY());
    }
}
