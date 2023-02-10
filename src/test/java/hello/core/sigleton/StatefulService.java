package hello.core.sigleton;

public class StatefulService {
//    private int price; 좋지않은 방법

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);

        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
