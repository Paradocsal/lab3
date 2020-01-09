package Papka;

public class Table extends Objedok implements Kavo{
    public Table(String name) {
        super(name);


    }

    @Override
    public void Setxymultiplied(int x1, int x2, int y1, int y2, int num) {
        super.Setxymultiplied(x1, x2, y1, y2, num);
    }
    //вывод правильно не работает возможно из-за проблем с super и this.Можно попробовать это исправить, перекинув этот метод в классы ниже, может с помощью интерефейс

//    Setxymultiplied(35, 50, 1,15,3);


    @Override
    public void Show() {
        super.Show();
    }
}
