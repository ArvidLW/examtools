//package DesignPattern;
//
////接口方法，隐式声明为public abstract,变量为public static final;
//interface Car{
//    void start();
//}
//class CarA implements Car{
//    CarA(){
//        System.out.println("CarA");
//    }
//    @Override
//    public void start() {
//
//    }
//}
//class CarB implements Car{
//    CarB(){
//        System.out.println("CarB");
//    }
//    @Override
//    public void start() {
//
//    }
//}
//public class SimpleFactory{
//    public static Car Create(String name){
//        switch (name){
//            case "CarA": return new CarA();
//            case "CarB": return new CarB();
//            default: return null;
//        }
//    }
//}