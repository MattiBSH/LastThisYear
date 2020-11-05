package webscraper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
//import jdk.jshell.spi.ExecutionControl;
class GetTagDTO implements Callable<TagDTO>{
  String url;
  GetTagDTO(String url){
    this.url = url;
  }
  @Override
  public TagDTO call() throws Exception {
    TagCounter tc = new TagCounter(url);
    tc.doWork();
    return new TagDTO(tc);
  }
}

public class Tester {

    public static List<TagCounter> runSequental() {
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://www.fck.dk"));
        urls.add(new TagCounter("https://www.google.com"));
        urls.add(new TagCounter("https://politiken.dk"));
        urls.add(new TagCounter("https://cphbusiness.dk"));
        for (TagCounter tc : urls) {
            tc.doWork();
        }
        return urls;
    }

    public static List<TagDTO> runParrallel() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
         String[] urls={"https://www.fck.dk","https://www.google.com","https://politiken.dk","https://cphbusiness.dk"};
         List<TagDTO>tDTOs=new ArrayList<>();
         List<Future<TagDTO>> futures = new ArrayList<>();

        for(String url:urls){
            Future<TagDTO> future =executor.submit(new GetTagDTO(url));
            futures.add(future);
        }
        for(Future f: futures){
            System.out.println(f);
        }
        
        for (Future<TagDTO> future : futures) {
            tDTOs.add(future.get());
        }
        return tDTOs;
      
    }

    public static void main(String[] args) throws Exception {
        long timeSequental;
        long start = System.nanoTime();

        List<TagCounter> fetchedData = new Tester().runSequental();
        long end = System.nanoTime();
        timeSequental = end - start;
        System.out.println("Time Sequential: " + ((timeSequental) / 1_000_000) + " ms.");

        for (TagCounter tc : fetchedData) {
            System.out.println("Title: " + tc.getTitle());
            System.out.println("Div's: " + tc.getDivCount());
            System.out.println("Body's: " + tc.getBodyCount());
            System.out.println("----------------------------------");
        }

        
        
        start = System.nanoTime();
        //TODO Add your parrallel calculation here     
        long timeParallel = System.nanoTime() - start;
        long start2 = System.nanoTime();
        runParrallel();
        long end2 = System.nanoTime();
        System.out.println("Time Parallel: " + ((end2 - start2) / 1_000_000) + " ms.");
        System.out.println("Paralle was " + timeSequental / timeParallel + " times faster");
       
         
    }
}
