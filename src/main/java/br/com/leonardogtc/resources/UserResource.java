package br.com.leonardogtc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardogtc.domain.User;
import br.com.leonardogtc.dto.UserDTO;
import br.com.leonardogtc.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream()
				.map(user -> new UserDTO(user))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
