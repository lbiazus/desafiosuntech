package br.com.biazus.desafiosuntech.domain.model.users.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.biazus.desafiosuntech.domain.model.users.entity.Users;
import br.com.biazus.desafiosuntech.domain.model.users.entity.UsersDTO;
import br.com.biazus.desafiosuntech.domain.model.users.repository.UsersRepository;
import br.com.biazus.desafiosuntech.exception.users.UserNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public List<UsersDTO> findAllUsers() {
		return convertInDTOList(usersRepository.findAll());
	}

	private List<UsersDTO> convertInDTOList(List<Users> users) {
		List<UsersDTO> usersDTO = new ArrayList<>();
		for (Users user : users) {
			usersDTO.add(new UsersDTO(user));
		}
		return usersDTO;
	}
	
	public List<UsersDTO> findUsers(UsersDTO user) {
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("userName", match -> match.contains().ignoreCase())
				.withMatcher("name", match -> match.contains().ignoreCase())
				.withMatcher("email", match -> match.contains().ignoreCase());
		
		return convertInDTOList(usersRepository.findAll(Example.of(new Users(user), matcher)));
	}
	
	public UsersDTO findBy(Integer id) throws UserNotFoundException {
		Users user = usersRepository.findOne(id);
		if (user == null) {
			throw new UserNotFoundException();
		}
		
		return new UsersDTO(user);
	}
	
	public UsersDTO save(UsersDTO userDTO) {
		Users user = new Users(userDTO);
		/*if (userDTO.getId() != null) {
			user = usersRepository.findOne(userDTO.getId());
			user.
		}*/
		
		Users userPersisted = usersRepository.save(user);
		return new UsersDTO(userPersisted);
	}
	
	public void delete(UsersDTO user) throws UserNotFoundException {
		if (user.getId() == null) {
			throw new UserNotFoundException();
		}
		
		if (usersRepository.findOne(user.getId()) == null) {
			throw new UserNotFoundException();
		}
		
		usersRepository.delete(user.getId());
	}
}
