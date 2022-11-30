package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

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

import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers() throws SQLException {
		List<UserDto> userList = userService.listUsers();
        return ResponseEntity.ok(userList);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) throws SQLException {
		UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
	
	@PostMapping("/")
    public ResponseEntity<String> create(@RequestBody UserDto user) throws SQLException {
		userService.createUser(user);
        return ResponseEntity.ok("User Created");
    }
	
	@PutMapping("/")
    public ResponseEntity<String> update(@RequestBody UserDto user) throws SQLException {
		//TODO code for update
        return ResponseEntity.ok("User Updated");
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
		userService.deleteUser(id);
        return ResponseEntity.ok("User deleted");
    }
}
