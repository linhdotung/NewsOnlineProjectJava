/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Welcome
 */
@Entity
@Table(name = "Publisher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findByPId", query = "SELECT p FROM Publisher p WHERE p.pId = :pId"),
    @NamedQuery(name = "Publisher.findByPName", query = "SELECT p FROM Publisher p WHERE p.pName = :pName"),
    @NamedQuery(name = "Publisher.findByPNickName", query = "SELECT p FROM Publisher p WHERE p.pNickName = :pNickName"),
    @NamedQuery(name = "Publisher.findByPEmail", query = "SELECT p FROM Publisher p WHERE p.pEmail = :pEmail"),
    @NamedQuery(name = "Publisher.findByPPassword", query = "SELECT p FROM Publisher p WHERE p.pPassword = :pPassword"),
    @NamedQuery(name = "Publisher.findByPTel", query = "SELECT p FROM Publisher p WHERE p.pTel = :pTel"),
    @NamedQuery(name = "Publisher.findByPDelete", query = "SELECT p FROM Publisher p WHERE p.pDelete = :pDelete")})
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_id")
    private Integer pId;
    @Size(max = 100)
    @Column(name = "p_name")
    private String pName;
    @Size(max = 100)
    @Column(name = "p_nick_name")
    private String pNickName;
    @Size(max = 100)
    @Column(name = "p_email")
    private String pEmail;
    @Size(max = 10)
    @Column(name = "p_password")
    private String pPassword;
    @Size(max = 12)
    @Column(name = "p_tel")
    private String pTel;
    @Column(name = "p_delete")
    private Boolean pDelete;
    @ManyToMany(mappedBy = "publisherCollection")
    private Collection<Category> categoryCollection;
    @JoinColumn(name = "r_id", referencedColumnName = "r_id")
    @ManyToOne
    private Roles rId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<News> newsCollection;

    public Publisher() {
    }

    public Publisher(Integer pId) {
        this.pId = pId;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPNickName() {
        return pNickName;
    }

    public void setPNickName(String pNickName) {
        this.pNickName = pNickName;
    }

    public String getPEmail() {
        return pEmail;
    }

    public void setPEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getPPassword() {
        return pPassword;
    }

    public void setPPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public String getPTel() {
        return pTel;
    }

    public void setPTel(String pTel) {
        this.pTel = pTel;
    }

    public Boolean getPDelete() {
        return pDelete;
    }

    public void setPDelete(Boolean pDelete) {
        this.pDelete = pDelete;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public Roles getRId() {
        return rId;
    }

    public void setRId(Roles rId) {
        this.rId = rId;
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Publisher[ pId=" + pId + " ]";
    }
    
}
