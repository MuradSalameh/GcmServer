package main.java.server;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutorService;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;





public class GcmServer {

	public static void main(String[] args) throws IOException, InterruptedException {

		URI basisUri = URI.create("http://localhost:4712/");
		// package mit den annotierten Klassen bekanntgeben
		ResourceConfig config = new ResourceConfig().packages("main.java.hibernate.model, main.java.hibernate.dao, main.java.server");
		// Server starten
		HttpServer server = JdkHttpServerFactory.createHttpServer(basisUri, config);
		System.out.println("Zum Beenden des GCM-Server die Eingabetaste drücken");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		server.stop(0);
		((ExecutorService) server.getExecutor()).shutdown();

	}

}
