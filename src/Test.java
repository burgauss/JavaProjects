public class Test {
    public static void main(String[] args) throws InterruptedException 
    { 
        // calling garbage collector 
        System.gc();  
              
        // waiting for gc to complete 
        Thread.sleep(1000);  
      
        System.out.println("end of main"); 
    } 
  
    @Override
    protected void finalize()  
    { 
        System.out.println("finalize method called"); 
    } 
}
