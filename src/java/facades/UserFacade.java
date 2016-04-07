package facades;

import entity.User;
import entity.EntityRole;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import security.PasswordStorage;

public class UserFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SemesterSeedPU");
    EntityManager em = emf.createEntityManager();

    public UserFacade() {
        
        try{
            em.createNamedQuery("User.FindByUserName").setParameter("userName", "test").getSingleResult();
        }catch(NoResultException nre){
            setup();
        }
        
    }
    
    private void setup(){
        try {
            User u = new User();
//            EntityRole r = new EntityRole();
//            r.setRoleName("User");
            u.setUserName("test");
            u.setPassword(PasswordStorage.createHash("pass"));
            u.addRole("Admin");
//            u.add_Role(r);
            
            em.getTransaction().begin();
            em.persist(u);
//            em.persist(r);
            em.getTransaction().commit();
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUserByUserId(String id) {

        int idAsInt = Integer.parseInt(id);

        return (User) em.createNamedQuery("User.FindById").setParameter("id", idAsInt).getSingleResult();
    }
    /*
     Return the Roles if users could be authenticated, otherwise null
     */

    public List<String> authenticateUser(String userName, String password) {

        try {
            User user = (User) em.createNamedQuery("User.FindByUserName").setParameter("userName", userName).getSingleResult();

            return user != null && PasswordStorage.verifyPassword(password, user.getPassword()) ? user.getRoles() : null;
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
