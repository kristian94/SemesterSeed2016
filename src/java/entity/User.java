/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Kristian
 */
@NamedQueries({
    @NamedQuery(name = "User.FindAll", query = "Select u from User u"),
    @NamedQuery(name = "User.FindById", query = "Select u from User u where u.id = :id"),
    @NamedQuery(name = "User.FindByUserName", query = "Select u from User u where u.userName = :userName")

})

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;  //Pleeeeease dont store me in plain text
    private long salt;
    private String userName;
//    @ManyToMany
//    private List<EntityRole> roles = new ArrayList();

    private List<String> roles = new ArrayList();
    
    public void addRole(String r){
        roles.add(r);
    }
    
    public List<String> getRoles(){
        return roles;
    }
    
//    public void add_Role(EntityRole r) {
//        roles.add(r);
//    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ id=" + id + " ]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getSalt() {
        return salt;
    }

    public void setSalt(long salt) {
        this.salt = salt;
    }

//    public List<String> getRoles() {
//        List<String> res = new ArrayList();
//        
//        for(EntityRole r: roles){
//            res.add(r.getRoleName());
//            System.out.println(r.getRoleName());
//        }
//        
//        return res;
//    }
//
//    public void setRoles(List<EntityRole> roles) {
//        this.roles = roles;
//    }

}
