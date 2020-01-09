package Map2;
import items.items;

public class Prostranstvo {
    private KoordOfObj[][] myMap;
    private Enum[][] enumMap;
    private int sizeX;
    private int sizeY;
    private Svetimost[][] svetMap;
    String Light;
    public Prostranstvo() {
        this(50, 50);
    }
//    public Prostranstvo(int sizeX, int sizeY,String Light) {
//        this.sizeX = sizeX;
//        this.sizeY = sizeY;
//        this.svetMap = new Svetimost[sizeX][sizeY];
//        for (int i = 0; i <= sizeY - 1; i++) {
//            for (int j = 0; j <= sizeX - 1; j++) {
//
//
//                    if (((getSizeX()+getSizeY())-(i+j))<5){ // distance from light source to point
//                        this.svetMap[i][j] = Svetimost.OchBlizko; //light intensity
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<10){
//                        this.svetMap[i][j] = Svetimost.Blizko;
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<15){
//                        this.svetMap[i][j] = Svetimost.NetakNeedak;
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<20){
//                        this.svetMap[i][j] = Svetimost.Daleko;
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<25){
//                        this.svetMap[i][j] = Svetimost.OchenDaleko;
//                    }
//                }
//
//        }
//    }



            //constant check -> recheck



    public Prostranstvo(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.myMap = new KoordOfObj[sizeX][sizeY];
        this.enumMap = new Enum[sizeX][sizeY];
        this.svetMap = new Svetimost[sizeX][sizeY];

        for (int i = 0; i <= sizeY-1; i++) {
            for (int j = 0; j <= sizeX-1 ; j++) {
                this.enumMap[i][j] = Enum.Air;
                if (j == 0) {
                    this.enumMap[i][j] = Enum.Surface;
                }else {
                    if (i == 0 | i == sizeX-1) {
                        this.enumMap[i][j] = Enum.Wall;
                    }
                }
            }
        }

    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
    public void AddIstSveta(items obj, int svetimost){
        for (int i = 0; i <= sizeY - 1; i++) {
            for (int j = 0; j <= sizeX - 1; j++) {

                if (i==obj.getY() && j ==obj.getX()){
                this.svetMap[i][j] = Svetimost.Daleko;
                }else {
                    if ((Math.abs(-obj.getX() - obj.getY() + (i + j))) < 3) { // distance from light source to point
                        this.svetMap[i][j] = Svetimost.OchBlizko; //light intensity
                    } else if ((Math.abs(-obj.getX() - obj.getY() + (i + j))) < 2 * svetimost) {
                        this.svetMap[i][j] = Svetimost.Blizko;
                    } else if ((Math.abs(-obj.getX() - obj.getY() + (i + j))) < 4 * svetimost) {
                        this.svetMap[i][j] = Svetimost.NetakNeedak;
                    } else if ((Math.abs(-(obj.getX() - obj.getY()) + (i + j))) < 6 * svetimost) {
                        this.svetMap[i][j] = Svetimost.Daleko;
                    } else if (((obj.getX() - obj.getY()) + (i + j)) < 500) {
                        this.svetMap[i][j] = Svetimost.OchenDaleko;
                    }
                }
            }

        }
        ShowLightMap();
    }

    public void AddMultlObjOnMap(items obj) {

        for (int i = obj.getY2(); i >= obj.getY1(); i--) {
            for (int j = obj.getX1(); j < obj.getX2(); j++) {
                if (this.getObjInCoord(i,j) == null) {
                    this.myMap[i][j] = obj;

                }
                else{
                    System.out.println("Это Место уже занято(");
                }
            }
        }

    }

    public int getX1KoordOfMultObj(KoordOfObj obj) {
        return obj.getX1();
    }

    public int getX2KoordOfMultObj(KoordOfObj obj) {
        return obj.getX2();
    }

    public int getY1KoordOfMultObj(KoordOfObj obj) {
        return obj.getY1();
    }

    public int getY2KoordOfMultObj(KoordOfObj obj) {
        return obj.getY2();
    }

    public void AddOnMap(KoordOfObj obj) {
        if (this.getObjInCoord(obj.getX(), obj.getY()) == null) {
            if(this.myMap[obj.getX()][obj.getY() - 1] != null) {
                //this.myMap[obj.getX()][obj.getY()] = obj;
                System.out.println(obj.toString() + " уже здесь!");
            }else if(this.enumMap[obj.getX()][obj.getY()-1] != Enum.Air){
                this.myMap[obj.getX()][obj.getY()] = obj;
                System.out.println(obj.toString() + " уже здесь!");
            } else {
                for (int i = obj.getY(); this.myMap[obj.getX()][i-1] == null;i--) {
                    if(this.enumMap[obj.getX()][i-1] == Enum.Air) {
                        this.myMap[obj.getX()][i] = obj;
                        System.out.println(obj.toString() + "Падает!");
                        ShowMap();
                        MoveObj(obj.getX(), i, obj.getX(), i - 1);
                    }
                    else{
                        ShowMap();
                        break;
                    }
                }
            }
            System.out.println(obj.toString() + " уже здесь!");
            this.myMap[obj.getX()][obj.getY()] = obj;
        }
        else{
            System.out.println("Это место уже занято(");
        }
    }

    public KoordOfObj getObjInCoord(int x, int y) {
        return this.myMap[x][y];
    }

    public Enum getEnumInCoord(int x, int y) {
        return this.enumMap[x][y];
    }
    public Svetimost getSvetimostInCoord(int x,int y){
        return this.svetMap[x][y];
    }
    public void MoveObj(int x, int y, int xwant, int ywant) {
        KoordOfObj obj = this.getObjInCoord(x, y);
        this.myMap[xwant][ywant] = obj;
        DeleteObj(x,y);
    }

    public void DeleteObj(int x, int y) {
        this.myMap[x][y] = null;
    }
    public void ShowLightMap(){
        String s = "";
        for (int i = this.sizeY-1; i >= 0; i--) {
            for (int j = 0; j < this.sizeX; j++) {
                String p = " ";
                Svetimost sv = this.getSvetimostInCoord(j, i);
                Enum en = this.getEnumInCoord(j, i);
                Object obj = this.getObjInCoord(j,i);
                if (obj != null) {
                    p = " " + obj.getClass().getSimpleName().toCharArray()[0]+" ";
                } else {
                    switch (en) {
                        case Wall:
                            p = "|";
                            break;
                        case Surface:
                            p = "‾‾‾";
                            break;
                        case Air:
                            switch (sv) {
                                case OchBlizko:
                                    p = " * ";
                                    break;
                                case Blizko:
                                    p = " & ";
                                    break;
                                case NetakNeedak:
                                    p = " @ ";
                                    break;
                                case Daleko:
                                    p = " . ";
                                    break;
                                case OchenDaleko:
                                    p = " / ";
                                    break;
                            };
                            break;
                    }

                    }
                s += p;
            }
            s += "\n";
        }
        System.out.println(s);
    }
    public void ShowMap() {

        String s = "";
        for (int i = this.sizeY-1; i >= 0; i--) {
            for (int j = 0; j < this.sizeX; j++) {
                String p = " ";
                Object obj = this.getObjInCoord(j, i);
                Enum en = this.getEnumInCoord(j, i);
                if (obj != null) {
                    p = " " + obj.getClass().getSimpleName().toCharArray()[0]+" ";
                } else {
                    switch (en) {
                        case Wall:
                            p = "|";
                            break;
                        case Surface:
                            p = "‾";
                            break;
                        case Air:
                            p = " . ";
                            break;
                    }
                }
                s += p;
            }
            s += "\n";
        }
        System.out.println(s);
    }
}