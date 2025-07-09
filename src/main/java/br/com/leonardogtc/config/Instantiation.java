package br.com.leonardogtc.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.leonardogtc.domain.Post;
import br.com.leonardogtc.domain.User;
import br.com.leonardogtc.repository.PostRepository;
import br.com.leonardogtc.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		// This method can be used to initialize data or perform actions at application startup
		// For example, you could create some initial users or set up the database
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); // Clear the database before adding new data
		postRepository.deleteAll(); // Clear the posts database before adding new data
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, dateFormat.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, dateFormat.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));

		System.out.println("Application started and ready to use!");
	}

}
