public class Programa implements Runnable {

// Preemptivo (Windows)
// - evita selfish

// Cooperativo (nao windows)

  @Override
  public void run(){
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " is running: " + i);
    }
  }
  
  
  public static void main(String[] args) throws Exception {
        Thread[] ts = new Thread[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = Thread.ofPlatform().name("" + i).start(new Programa());
        }
        // for (int i = 0; i < 10; i++) {
        //     ts[i].start();
        // }
        System.out.println("All threads have finished.");
        Thread.sleep(10);
    }
}
