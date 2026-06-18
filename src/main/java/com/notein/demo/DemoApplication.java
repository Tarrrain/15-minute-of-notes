package com.notein.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@SpringBootApplication
@Entity
public class DemoApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //id создается автоматически
	private long Id;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		tookAText();
	}
	public static void tookAText()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("notes:\n");
		String text = input.nextLine();
		System.out.println("you wrote:" + text);
		return;
	}

}
