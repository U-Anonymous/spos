import java.util.concurrent.Semaphore;
public class ReaderWriter {

	static Semaphore readLock = new Semaphore(1);
    static Semaphore writeLock = new Semaphore(1);
    static int readCount = 0;

    static class Write implements Runnable {
        public void run() {
            try {
                writeLock.acquire();
                System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING\n");
                Thread.sleep(5000);
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING\n");
                writeLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    static class Read implements Runnable {

        public void run() {
            try {
                //Acquire Section
                readLock.acquire();
                readCount++;
                if (readCount == 1) {
                    writeLock.acquire();
                }
                readLock.release();

                //Reading section
                System.out.println("Thread "+Thread.currentThread().getName() + " is READING\n");
                Thread.sleep(5000);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING\n");

                //Releasing section
                readLock.acquire();
                readCount--;
                if(readCount == 0) {
                    writeLock.release();
                }
                readLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Read read = new Read();
        Write write = new Write();
        
        Thread t1 = new Thread(write);
        t1.setName("Thread-1");
        
        Thread t2 = new Thread(read);
        t2.setName("Thread-2");
        
        Thread t3 = new Thread(write);
        t3.setName("Thread-3");
        
        Thread t4 = new Thread(read);
        t4.setName("Thread-4");
        
        t1.start();
        t3.start();
        t2.start();
        t4.start();
	}

}
