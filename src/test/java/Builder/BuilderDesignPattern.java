import org.testng.reporters.AbstractXmlReporter;

public class BuilderDesignPattern {
    //Change return type to class type
    //this always points to current/calling object.Returning the same to have same reference.

    public BuilderDesignPattern stage1(){
        System.out.println("Stage 1");
        return this;
    }
    public BuilderDesignPattern stage2(String str){
        System.out.println("Stage 2 "+str);
        return this;
    }
    public BuilderDesignPattern stage3(){
        System.out.println("Stage 3");
        return this;
    }
    public static void main(String[] args){
        BuilderDesignPattern bp = new BuilderDesignPattern();
        bp.stage1().stage2(" Malini").stage3();
    }
}
