package br.com.leonardogtc.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leonardogtc.domain.Post;
import br.com.leonardogtc.repository.PostRepository;
import br.com.leonardogtc.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		return repo.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Post.class.getName()));
	}

	public List<Post> findByTitle(String text) {
//		return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // Adjust maxDate to include the whole day
		return repo.fullSearch(text, minDate, maxDate);
	}

}
