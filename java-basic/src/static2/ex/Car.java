package static2.ex;

public class Car {
    private static int count = 0;
    String name;
    Car(String name){
        this.name = name;
        System.out.println("차량 구입, 이름: "+name);
        count++;
    }
    public static void showTotalCars(){
        System.out.println("구매한 차량 수: "+count);
    }
}
