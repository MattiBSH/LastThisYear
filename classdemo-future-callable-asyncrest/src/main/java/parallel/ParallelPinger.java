package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sequental.SequentialPinger;

//Perhaps this you go into a separate file
class PingURL implements Callable<String> {
  String url;
  PingURL(String url) {this.url = url;}
  @Override
  public String call() throws Exception {
      
      
    return SequentialPinger.getStatus(url);
  }
}

public class ParallelPinger {
    
    
    /*
    Create your Callables, and start them via a method on the executor and add the returned future to the list
    Call a "relevant" method on all your futures to get the response, and to the List you eventually will return
    */
  public static List<String> getStatusFromAllServers() throws Exception{
          ExecutorService executor = Executors.newCachedThreadPool();

        SequentialPinger sp=new SequentialPinger();
       
        List<Future<String>> futures = new ArrayList<>(); 
         String[] list=sp.getHostList();
         List<String>result=new ArrayList<>();
         
        for(String url:list){
            Callable <String>pinger=new PingURL(url);
            Future future=executor.submit(pinger);
            futures.add(future);
        }
        
        for(Future<String>future : futures){
            result.add(future.get());
        }
        return result;
  }

  public static void main(String[] args) throws Exception {
          long timeStart = System.nanoTime();
    List<String> results = getStatusFromAllServers();
    for(String r: results){
      System.out.println(r);
    }
    long timeEnd = System.nanoTime();
    long total = (timeEnd - timeStart) / 1_000_000;
    System.out.println("Time to check URLS: " + total + "ms.");
  }
}
