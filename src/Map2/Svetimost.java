package Map2;

public enum Svetimost {

    OchBlizko("Очень ярко"),
    Blizko("Ярко"),
    NetakNeedak("Нормально"),
    Daleko("Довольно тускло"),
    OchenDaleko("Темень сплошная");



    private final String SvetimostDescription;
    private Svetimost(String p){
        SvetimostDescription = p;
    }
    public  String toString(){
        return SvetimostDescription;
    }
}
