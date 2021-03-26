package concorrencia;

public class ConRun implements Runnable{
	
	public void run(){
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
						
					e.printStackTrace();
				}
	}
}

    
    

