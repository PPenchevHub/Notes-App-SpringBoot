package com.ppenchev.notes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@Getter
@Setter
public class Note {
    @Column(name = "id")
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "cratedOn")
    private LocalDate createdOn = LocalDate.now();

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
