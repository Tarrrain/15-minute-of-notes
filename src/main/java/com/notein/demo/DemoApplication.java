package com.notein.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	
	public DemoApplication() {}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//DemoApplication(content);
	}
	public DemoApplication(String content)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("notes:\n");
		String text = input.nextLine();
		System.out.println("you wrote:" + text);
		return;
	}
	


}
