package ListenerDemo;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;
import org.testng.annotations.Listeners;

@Listeners(CustomListener.class)

public class CustomListener implements IExecutionListener, ISuiteListener {
    private long startTime;
    @Override
    public void onExecutionStart(){
        startTime=System.currentTimeMillis();
        System.out.println("Started at -"+ startTime);
    }
    @Override
    public void onExecutionFinish(){
        long endTime=System.currentTimeMillis();
        System.out.println("Finished at -"+ endTime);
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }


}
