package odk.apprenent.demoEntityBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import odk.apprenent.demoEntityBD.entity.Departement;
@SpringBootApplication
public class DemoEntityBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEntityBdApplication.class, args);


		Departement D = new Departement();
		D.setNom("Madou");
		System.out.println(D.getNom());


	}
}
