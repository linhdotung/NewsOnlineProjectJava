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
@Table(name = "News")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNId", query = "SELECT n FROM News n WHERE n.nId = :nId"),
    @NamedQuery(name = "News.findByNTitle", query = "SELECT n FROM News n WHERE n.nTitle = :nTitle"),
    @NamedQuery(name = "News.findByNContent", query = "SELECT n FROM News n WHERE n.nContent = :nContent"),
    @NamedQuery(name = "News.findByNImagePath", query = "SELECT n FROM News n WHERE n.nImagePath = :nImagePath"),
    @NamedQuery(name = "News.findByNSumary", query = "SELECT n FROM News n WHERE n.nSumary = :nSumary"),
    @NamedQuery(name = "News.findByNView", query = "SELECT n FROM News n WHERE n.nView = :nView"),
    @NamedQuery(name = "News.findByNRank", query = "SELECT n FROM News n WHERE n.nRank = :nRank"),
    @NamedQuery(name = "News.findByNDelete", query = "SELECT n FROM News n WHERE n.nDelete = :nDelete")})
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_id")
    private Integer nId;
    @Size(max = 100)
    @Column(name = "n_title")
    private String nTitle;
    @Size(max = 1073741823)
    @Column(name = "n_content")
    private String nContent;
    @Size(max = 100)
    @Column(name = "n_image_path")
    private String nImagePath;
    @Size(max = 100)
    @Column(name = "n_sumary")
    private String nSumary;
    @Column(name = "n_view")
    private Integer nView;
    @Column(name = "n_rank")
    private Integer nRank;
    @Column(name = "n_delete")
    private Boolean nDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nId")
    private Collection<Comments> commentsCollection;
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    @ManyToOne(optional = false)
    private Publisher pId;
    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    @ManyToOne(optional = false)
    private Category cId;

    public News() {
    }

    public News(Integer nId) {
        this.nId = nId;
    }

    public Integer getNId() {
        return nId;
    }

    public void setNId(Integer nId) {
        this.nId = nId;
    }

    public String getNTitle() {
        return nTitle;
    }

    public void setNTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getNContent() {
        return nContent;
    }

    public void setNContent(String nContent) {
        this.nContent = nContent;
    }

    public String getNImagePath() {
        return nImagePath;
    }

    public void setNImagePath(String nImagePath) {
        this.nImagePath = nImagePath;
    }

    public String getNSumary() {
        return nSumary;
    }

    public void setNSumary(String nSumary) {
        this.nSumary = nSumary;
    }

    public Integer getNView() {
        return nView;
    }

    public void setNView(Integer nView) {
        this.nView = nView;
    }

    public Integer getNRank() {
        return nRank;
    }

    public void setNRank(Integer nRank) {
        this.nRank = nRank;
    }

    public Boolean getNDelete() {
        return nDelete;
    }

    public void setNDelete(Boolean nDelete) {
        this.nDelete = nDelete;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    public Publisher getPId() {
        return pId;
    }

    public void setPId(Publisher pId) {
        this.pId = pId;
    }

    public Category getCId() {
        return cId;
    }

    public void setCId(Category cId) {
        this.cId = cId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nId != null ? nId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.nId == null && other.nId != null) || (this.nId != null && !this.nId.equals(other.nId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.News[ nId=" + nId + " ]";
    }
    
}
