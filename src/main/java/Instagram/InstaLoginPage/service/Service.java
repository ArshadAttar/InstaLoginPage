package Instagram.InstaLoginPage.service;

import Instagram.InstaLoginPage.model.InstaDTO;
import Instagram.InstaLoginPage.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository instaRepository;

    public InstaDTO saveData(InstaDTO dto){
           return instaRepository.save(dto);
    }
//    public boolean checkEmail(String email, String password){
//       InstaDTO temp=instaRepository.findByEmail(email);
//      return temp!=null && temp.getPassword().equals(password);
//    }
//
//    public boolean checkUserName(String userName, String password){
//       InstaDTO temp=instaRepository.findByContact(userName);
//       return temp!=null && temp.getPassword().equals(password);
//    }
    public boolean validateData(String data, String password) {
        InstaDTO insta = instaRepository.findByUserData(data, password);
        return insta != null && insta.getPassword().equals(password);
    }
}

