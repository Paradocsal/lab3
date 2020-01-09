package Map2;

public enum Enum {
    Wall("Стена"),
    Surface("Поверхность"),
    Air("Воздух");
    private final String EnumDescription;
    private Enum(String p){
        EnumDescription = p;
    }
    public  String toString(){
        return EnumDescription;
    }

}
