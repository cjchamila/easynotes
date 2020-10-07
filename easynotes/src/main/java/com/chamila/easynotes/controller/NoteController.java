package com.chamila.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chamila.easynotes.exception.ResourceNotFoundException;
import com.chamila.easynotes.model.Note;
import com.chamila.easynotes.repository.NoteRepository;


@RestController
@RequestMapping("/api")
public class NoteController {
	
	@Autowired
	NoteRepository noteReporsitory;
	
	// Get All Notes
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
	    return noteReporsitory.findAll();
	    
	    
	}

	
	// Create a new Note
	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note note) {
	    return noteReporsitory.save(note);
	}
	
	
	// Get a Single Note
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value = "id") Long noteId) {
	    return noteReporsitory.findById(noteId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	
	
	// Update a Note
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId,
	                                        @Valid @RequestBody Note noteDetails) {

	    Note note = noteReporsitory.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    note.setTitle(noteDetails.getTitle());
	    note.setContent(noteDetails.getContent());

	    Note updatedNote = noteReporsitory.save(note);
	    return updatedNote;
	}
	
	// Delete a Note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
	    Note note = noteReporsitory.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    noteReporsitory.delete(note);

	    return ResponseEntity.ok().build();
	}
	
}
