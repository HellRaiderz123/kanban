package com.mytasknowcobackend.kanban.api;

import com.mytasknowcobackend.kanban.model.Issues;
import com.mytasknowcobackend.kanban.model.Users;
import com.mytasknowcobackend.kanban.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mytasknow.azurewebsites.net")
@RequestMapping("api/v1/users")
@RestController
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public void addUser(@RequestBody Users users) {
        usersService.addUsers(users);
    }

   @GetMapping
    public List<Users> returnallUsers(){
        return  usersService.returnAllUsers();
   }
   

   @GetMapping(path = "{userId}")
    public Users selectUserbyId(@PathVariable("userId") String userId){ return usersService.selectUserbyId(userId);  }

    @DeleteMapping(path = "{userId}")
    public void deleteUserbyId(@PathVariable("userId") String userId){
        usersService.deleteUserbyId(userId);
    }

    @PutMapping(path = "{userId}")
    public  void  updateUserbyId(@PathVariable("userId") String userId, @RequestBody Users updatedUser){
        usersService.updateUserbyId(userId,updatedUser);
    }

}
