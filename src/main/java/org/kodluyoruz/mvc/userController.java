package org.kodluyoruz.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

//@Controller: ister json ister web sayfası genel bir anotasyon

@RestController
@RequestMapping("/api/user")
public class userController {

    private Map<UUID, User> users = new HashMap<>();

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody UserDto userDto,
                     @RequestHeader("Authorization") String authHeader) {

        System.out.println(authHeader);

        User u = new User(UUID.randomUUID(),userDto.getName(),userDto.getAge());
        users.put(u.getId(),u);
        return u;
    }

    //@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    @GetMapping(value = "/{id}" ,produces = "application/json")
    public User get(@PathVariable UUID id){
       return users.get(id);
        /*return users.get(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND), "User not found with id:"+id);*/
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<User> get(@RequestParam String name){
        return users.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getName().startsWith(name))
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

}
