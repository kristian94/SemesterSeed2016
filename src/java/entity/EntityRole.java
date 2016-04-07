/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


//@NamedQueries({
//    @NamedQuery(name="_Role.FindBy_Role", query="Select r from _Role where r._role = :_role")
//})

@Entity
public class EntityRole implements Serializable {
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
    private static final long serialVersionUID = 1L;
    @Id
    private String roleName;
    
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleName != null ? roleName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityRole)) {
            return false;
        }
        EntityRole other = (EntityRole) object;
        if ((this.roleName == null && other.roleName != null) || (this.roleName != null && !this.roleName.equals(other.roleName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity._Role[ id=" + roleName + " ]";
    }
    
}
