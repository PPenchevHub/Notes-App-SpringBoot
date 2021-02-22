package com.ppenchev.notes.controller;

import com.ppenchev.notes.model.Note;
import com.ppenchev.notes.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes/**")
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/api/notes")
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.CREATED);

    }
    @GetMapping("/api/notes/{title}")
    public ResponseEntity<Note> findNoteByTitle(@PathVariable("title") String title){
        if(title != null){
            return new ResponseEntity<>(noteService.findByTitle(title), HttpStatus.OK);

        }else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("api/notes/{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable("id") Long id){
        return new ResponseEntity<>(noteService.findNoteById(id), HttpStatus.OK);
    }
    @PostMapping("/api/notes")
    public ResponseEntity<HttpStatus> addNote(@RequestBody Note note){
        if(note != null){
            return new ResponseEntity<>(noteService.addNote(note), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/api/notes/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, @RequestBody Note note){
        if(note != null) return new ResponseEntity<>(noteService.updateNote(id, note), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/api/notes/delete/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable("id") Long id){
        return new ResponseEntity<>(noteService.deleteNote(id));

    }


}
