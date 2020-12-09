import java.util.concurrent.TimeUnit;



import io.reactivex.Observable;

import io.reactivex.schedulers.Schedulers;

public class ObsSubsEx {



	public static void main(String[] args) throws InterruptedException {	



		Observable.just("subscribeOn One").subscribeOn(Schedulers.computation()).map(ObsSubsEx::toUpper).subscribe(ObsSubsEx::printVal);	



		TimeUnit.SECONDS.sleep(1);	



		Observable.just("subscribeOn Two").map(ObsSubsEx::toUpper).subscribeOn(Schedulers.computation()).subscribe(ObsSubsEx::printVal);		



		TimeUnit.SECONDS.sleep(1);		



		Observable.just("observeOn").map(ObsSubsEx::toUpper).observeOn(Schedulers.computation()).subscribe(ObsSubsEx::printVal);	



		TimeUnit.SECONDS.sleep(1);

	}

	

	private static String toUpper(String val) {

		System.out.println("Uppercase done on thread:"+Thread.currentThread().getName());

		return val.toUpperCase();

	}



	private static void printVal(String val) {

		System.out.println("Final value is:"+val+":Thread:"+Thread.currentThread().getName());

	}

}

