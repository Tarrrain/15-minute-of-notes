package com.notein.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table (name = "notes")
public class Note {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id создается автоматически
	private Long Id;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	@Column(nullable = false)
	private LocalDateTime createdAt;
    public Note(){}
    public Note (String content){
        this.content = content; this.createdAt = LocalDateTime.now();
    }
    public Long getId() {return Id;}
	public void setId(Long Id) {this.Id = Id;}
	public String getContent() {return content;}
	public void setContent(String content){this.content = content;}
	public LocalDateTime getCreatedAt(){return createdAt;}
	public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt;}
}
