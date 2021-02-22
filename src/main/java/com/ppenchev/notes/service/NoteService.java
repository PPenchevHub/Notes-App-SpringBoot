package com.ppenchev.notes.service;

import com.ppenchev.notes.exceptions.RessourceNotFoundException;
import com.ppenchev.notes.model.Note;
import com.ppenchev.notes.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NoteService {

    private NoteRepository noteRepository;

    public HttpStatus addNote(Note note){
        if(note != null) {
            this.noteRepository.save(note);
            return HttpStatus.CREATED;
        }
        else return HttpStatus.NO_CONTENT;
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
         return noteRepository.findById(id).orElseThrow(() ->
                 new RessourceNotFoundException("No Note found with id: " + id));
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
