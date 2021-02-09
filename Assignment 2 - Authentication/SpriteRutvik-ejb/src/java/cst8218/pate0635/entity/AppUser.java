/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.pate0635.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rutvik
 */
@Entity
@Table(name = "APPUSER")
@XmlRootElement
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Long userid;
    
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
     
    @Size(max = 255)
    @Column(name = "GROUPNAME")
    private String groupname;

    public AppUser() {
    }

    public AppUser(Long id) {
        this.userid = userid;
    }

    public Long getId() {
        return userid;
    }

    public void setId(Long id) {
        this.userid = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return "";
    }

    public void setPassword(String mySecretPassword) {
        
     // initialize a PasswordHash object which will generate password hashes
     Instance<? extends PasswordHash> instance = CDI.current().select(Pbkdf2PasswordHash.class);
     PasswordHash passwordHash = instance.get();
     passwordHash.initialize(new HashMap<String,String>());  // todo: are the defaults good enough?
     // now we can generate a password entry for a given password
     String passwordEntry = mySecretPassword; //pretend the user has chosen a password mySecretPassword
     passwordEntry = passwordHash.generate(passwordEntry.toCharArray());
     //at this point, passwordEntry refers to a salted/hashed password entry corresponding to mySecretPassword
             this.password = passwordEntry;

    }
    
    public String getGroupName() {
        return groupname;
    }

    public void setGroupName(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appuser.AppUser[ userid=" + userid + " ]";
    }

    String String() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
