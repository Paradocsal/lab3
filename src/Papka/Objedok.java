package Papka;

public abstract class Objedok implements Kavo{
    String name;


    public Objedok(String name) {
        this.name = name;
//        this.komnata[x][y] = 666;

    }

    //    int x,y;
//    public void Setx(int x){
//        this.x = x;
//
//    }
//    public void Sety(int y){
//        this.y = y;
//
//    }
    public void Setxy(int x, int y) {
        //this.x = x;
        //this.y = y;

        komnata[50 - y][x] = 5;

    }
    public int[][] komnata = new int[51][51];

    public  void Setxymultiplied(int x1, int x2, int y1, int y2, int num) {//вывод правильно не работает возможно из-за проблем с super и this.Можно попробовать это исправить, перекинув этот метод в классы ниже, может с помощью интерефейса
        for (int i = 51 - y2; i <= 51 - y1; i++) {
            for (int j = x1; j <= x2; j++) {
                komnata[i][j] = num;
            }
        }

    }


    public void Show() {
        for (int i = 1; i < komnata.length; i++) {
            for (int j = 1; j < komnata[i].length; j++) {


                System.out.print(komnata[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    //    public int[][] ShowKomnata() {/*работает для гета(даёт весь массив, но не выводит его)
//        return komnata;
//    }*/

    //    public int Getx(){
//        return x;
//    }
//    public int GetXplusY(){
//        return x+y;
//    }
}
