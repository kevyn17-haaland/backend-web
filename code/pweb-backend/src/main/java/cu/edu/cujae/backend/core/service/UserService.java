package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.UserDto;

public interface UserService {
	
	void createUser(UserDto user) throws SQLException;
	
	void updateUser(UserDto user);
	
	List<UserDto> listUsers() throws SQLException;
	
	UserDto getUserById(String userId) throws SQLException;
	
	void deleteUser(String id) throws SQLException;
}
