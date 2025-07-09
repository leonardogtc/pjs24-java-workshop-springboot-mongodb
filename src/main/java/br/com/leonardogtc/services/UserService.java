package br.com.leonardogtc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leonardogtc.domain.User;
import br.com.leonardogtc.dto.UserDTO;
import br.com.leonardogtc.repository.UserRepository;
import br.com.leonardogtc.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
//	public User findById(String id) {
//		User user = repo.findOne(id);
//		if (user == null) {
//			throw new br.com.leonardogtc.services.exception.ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + User.class.getName());
//		}
//		return user;
//	}
	
	public User findById(String id) {
		return repo.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + User.class.getName()));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id); // Ensure the user exists before attempting to delete
		repo.deleteById(id);
	}
	
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
