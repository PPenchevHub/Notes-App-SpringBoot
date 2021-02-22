package com.ppenchev.notes.service;

import com.ppenchev.notes.model.Note;
import com.ppenchev.notes.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NoteService {

    private NoteRepository noteRepository;

    public Note addNote(Note note){
        return this.noteRepository.save(note);
    }
    public List<Note> getAllNotes(){
        return this.noteRepository.findAll();
    }
    public Note findByTitle(String title){
        List<Note> notes = this.getAllNotes();
        for(Note n : notes){
            if(n.getTitle().equals(title)) return n;
        }
        return null;
    }
    public Note findNoteById(Long id){
        Optional<Note> note = noteRepository.findById(id);
         return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }
    public Note updateNote(Long id, Note note){
       Note temp = this.findNoteById(id);
       temp.setTitle(note.getTitle());
       temp.setContent(note.getContent());
       return temp;
    }
    public HttpStatus deleteNote(Long id){
        noteRepository.delete(this.findNoteById(id));
        return HttpStatus.OK;
    }



}
