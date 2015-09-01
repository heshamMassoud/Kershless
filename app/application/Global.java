package application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;
import play.GlobalSettings;
import configs.SpringConfiguration;

public class Global extends GlobalSettings {

	private static ApplicationContext applicationContext;

	@Override
	public void onStart(Application application) {
		System.out.println("on start");
		applicationContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class);
	}

	public static ApplicationContext getContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"application context is not initialized");
		}
		return applicationContext;
	}
}