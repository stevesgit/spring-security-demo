package cn.steve.security.web.controller;

import cn.steve.security.dto.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By SteveWoo
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    @JsonView(User.UserSimpleView.class)
    public List<User> query(@RequestParam String username) {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        users.add(user1);
        User user2 = new User();
        users.add(user2);
        User user3 = new User();
        users.add(user3);
        return users;
    }

    @JsonView(User.UserDeatailView.class)
    @GetMapping(value = "/{id:\\d+}")
    public User getInfo(@PathVariable String id) {
//        System.out.println(id);
//        throw new UserNotExistException(id);
//        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping()
    public User create(@RequestBody @Validated User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        user.setId(1);
        return user;
    }

    @PutMapping
    public User update(@RequestBody @Validated User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        user.setId(1);
        return user;
    }
}
