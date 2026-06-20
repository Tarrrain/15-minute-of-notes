package com.notein.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@SpringBootApplication
@Entity
public class DemoApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id создается автоматически
	private Long Id;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	@Column(nullable = false)
	private LocalDateTime createdAt;
	public DemoApplication() {}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//DemoApplication(content);
	}
	public DemoApplication(String content)
	{
		this.content = content;
		this.createdAt = LocalDateTime.now();
		Scanner input = new Scanner(System.in);
		System.out.print("notes:\n");
		String text = input.nextLine();
		System.out.println("you wrote:" + text);
		return;
	}
	public Long getId() {return Id;}
	public void setId(Long Id) {this.Id = Id;}
	public String getContent() {return content;}
	public void setContent(String content){this.content = content;}
	public LocalDateTime getCreatedAt(){return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt;}


}
