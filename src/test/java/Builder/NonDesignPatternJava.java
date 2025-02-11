package Builder;

public class NonDesignPatternJava {
    public void step1(){
        System.out.println("Step1");
    }
    public void step2(){
        System.out.println("Step2");
    }
    public void step3(){
        System.out.println("Step3");
    }

    public static void main(String[] args) {
    NonDesignPatternJava np=  new NonDesignPatternJava();
    np.step1();
    np.step2();
    np.step3();
    }
}
