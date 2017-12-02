package si.inspirited.engine;

import org.apache.commons.lang3.StringUtils;
import si.inspirited.domain.Message;
import si.inspirited.domain.User;
import si.inspirited.ejb.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;

@Stateless
public class Engine {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    private List<User> users;

    public String generateNewUserName() {
        Random random = new Random();

        while (true) {
            int suffix = random.nextInt(777777777);

            User user = entityManager.find(User.class, "User" + suffix);
            if (user == null) {
                user.setPassword("0000");
                entityManager.persist(user);
                return "User" + suffix;
            }
        }

    }
    public boolean checkIfDoublicated(String data){
        if(StringUtils.isEmpty(data)){
            return false;
        }

        Message message = entityManager.find(Message.class, data);
        if(message != null){
            return true;
        }

        if(password.equals(userEntity.getPassword())){
            return true;
        }

        return false;
    }

    public boolean sendMessage(String data){
        if(StringUtils.isEmpty(data)){
            return false;
        }

        UserEntity userEntity = entityManager.find(UserEntity.class, login);
        if(userEntity != null){
            return false;
        }

        userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(password);
        entityManager.persist(userEntity);

        return true;
    }

    public List<UserEntity> getAllUsers(){
        Query query = entityManager.createQuery("select entity from UserEntity entity");
        return query.getResultList();
    }
}

}
