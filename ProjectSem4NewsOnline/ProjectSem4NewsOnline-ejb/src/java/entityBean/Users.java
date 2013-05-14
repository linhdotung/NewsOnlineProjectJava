/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Welcome
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUId", query = "SELECT u FROM Users u WHERE u.uId = :uId"),
    @NamedQuery(name = "Users.findByUName", query = "SELECT u FROM Users u WHERE u.uName = :uName"),
    @NamedQuery(name = "Users.findByUPassword", query = "SELECT u FROM Users u WHERE u.uPassword = :uPassword"),
    @NamedQuery(name = "Users.findByUEmail", query = "SELECT u FROM Users u WHERE u.uEmail = :uEmail"),
    @NamedQuery(name = "Users.findByUAddress", query = "SELECT u FROM Users u WHERE u.uAddress = :uAddress"),
    @NamedQuery(name = "Users.findByUTel", query = "SELECT u FROM Users u WHERE u.uTel = :uTel"),
    @NamedQuery(name = "Users.findByUDelete", query = "SELECT u FROM Users u WHERE u.uDelete = :uDelete")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "u_id")
    private Integer uId;
    @Size(max = 50)
    @Column(name = "u_name")
    private String uName;
    @Size(max = 50)
    @Column(name = "u_password")
    private String uPassword;
    @Size(max = 50)
    @Column(name = "u_email")
    private String uEmail;
    @Size(max = 200)
    @Column(name = "u_address")
    private String uAddress;
    @Size(max = 12)
    @Column(name = "u_tel")
    private String uTel;
    @Column(name = "u_delete")
    private Boolean uDelete;

    public Users() {
    }

    public Users(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getUAddress() {
        return uAddress;
    }

    public void setUAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getUTel() {
        return uTel;
    }

    public void setUTel(String uTel) {
        this.uTel = uTel;
    }

    public Boolean getUDelete() {
        return uDelete;
    }

    public void setUDelete(Boolean uDelete) {
        this.uDelete = uDelete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Users[ uId=" + uId + " ]";
    }
    
}
