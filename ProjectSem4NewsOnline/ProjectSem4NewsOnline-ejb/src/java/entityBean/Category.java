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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "Category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCId", query = "SELECT c FROM Category c WHERE c.cId = :cId"),
    @NamedQuery(name = "Category.findByCName", query = "SELECT c FROM Category c WHERE c.cName = :cName"),
    @NamedQuery(name = "Category.findByCDelete", query = "SELECT c FROM Category c WHERE c.cDelete = :cDelete")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer cId;
    @Size(max = 50)
    @Column(name = "c_name")
    private String cName;
    @Column(name = "c_delete")
    private Boolean cDelete;
    @JoinTable(name = "Publish", joinColumns = {
        @JoinColumn(name = "c_id", referencedColumnName = "c_id")}, inverseJoinColumns = {
        @JoinColumn(name = "p_id", referencedColumnName = "p_id")})
    @ManyToMany
    private Collection<Publisher> publisherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cfatherID")
    private Collection<Category> categoryCollection;
    @JoinColumn(name = "c_fatherID", referencedColumnName = "c_id")
    @ManyToOne(optional = false)
    private Category cfatherID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private Collection<News> newsCollection;

    public Category() {
    }

    public Category(Integer cId) {
        this.cId = cId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Boolean getCDelete() {
        return cDelete;
    }

    public void setCDelete(Boolean cDelete) {
        this.cDelete = cDelete;
    }

    @XmlTransient
    public Collection<Publisher> getPublisherCollection() {
        return publisherCollection;
    }

    public void setPublisherCollection(Collection<Publisher> publisherCollection) {
        this.publisherCollection = publisherCollection;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public Category getCfatherID() {
        return cfatherID;
    }

    public void setCfatherID(Category cfatherID) {
        this.cfatherID = cfatherID;
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
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Category[ cId=" + cId + " ]";
    }
    
}
