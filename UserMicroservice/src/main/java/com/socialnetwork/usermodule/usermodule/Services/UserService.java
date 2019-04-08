package com.socialnetwork.usermodule.usermodule.Services;

import com.socialnetwork.usermodule.usermodule.Entities.User;
import com.socialnetwork.usermodule.usermodule.Entities.UserGroup;
import com.socialnetwork.usermodule.usermodule.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository _repository){
        this.repository = _repository;
    }

    public User getUserById (Integer userId){
        return repository.findById(userId);
    }

    public User getUserByFirstName (String firstName){
        return repository.findByFirstName(firstName);
    }

    public List<User> getUserFriends (Integer user_id){
        User user = repository.findById(user_id);
        return user.getFriends();
    }

    public List<UserGroup> getAllGroupsOfUser (Integer user_id){
        User user = repository.findById(user_id);
        return user.getGroups();
    }

    public User saveNewUser (User user){
        this.repository.save(user);
        return user;
    }

    public void addFriend (Integer user_id, Integer friend_id) throws Exception{
        User user = this.repository.findById(user_id);
        User friend = this.repository.findById(friend_id);

        if(user_id == friend_id)
        {
            throw new Exception("Ne može sam sebe dodat");
        }

        if(user == null || friend == null){
            throw new Exception("No user with given id found");
        }

        List<User> friendList = user.getFriends();
        if(friendList.contains(friend))
        {
            throw new Exception("Already friends");
        }
        //provjeriti da li su vec povezani

        user.getFriends().add(friend);
        this.repository.save(user);

    }

    public void deleteUser(Integer userId) throws Exception {
        User user = this.repository.findById(userId);

        if(user == null){
            throw new Exception("User with this id does not exist");
        }

        this.repository.delete(user);
    }

}
