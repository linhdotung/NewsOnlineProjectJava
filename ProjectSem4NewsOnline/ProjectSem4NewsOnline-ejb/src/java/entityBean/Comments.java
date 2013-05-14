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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findByCmId", query = "SELECT c FROM Comments c WHERE c.cmId = :cmId"),
    @NamedQuery(name = "Comments.findByCmEmail", query = "SELECT c FROM Comments c WHERE c.cmEmail = :cmEmail"),
    @NamedQuery(name = "Comments.findByCmTitle", query = "SELECT c FROM Comments c WHERE c.cmTitle = :cmTitle"),
    @NamedQuery(name = "Comments.findByCmContent", query = "SELECT c FROM Comments c WHERE c.cmContent = :cmContent"),
    @NamedQuery(name = "Comments.findByCmDelete", query = "SELECT c FROM Comments c WHERE c.cmDelete = :cmDelete")})
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cm_id")
    private Integer cmId;
    @Size(max = 100)
    @Column(name = "cm_email")
    private String cmEmail;
    @Size(max = 100)
    @Column(name = "cm_title")
    private String cmTitle;
    @Size(max = 200)
    @Column(name = "cm_content")
    private String cmContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cm_delete")
    private boolean cmDelete;
    @JoinColumn(name = "n_id", referencedColumnName = "n_id")
    @ManyToOne(optional = false)
    private News nId;

    public Comments() {
    }

    public Comments(Integer cmId) {
        this.cmId = cmId;
    }

    public Comments(Integer cmId, boolean cmDelete) {
        this.cmId = cmId;
        this.cmDelete = cmDelete;
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public String getCmEmail() {
        return cmEmail;
    }

    public void setCmEmail(String cmEmail) {
        this.cmEmail = cmEmail;
    }

    public String getCmTitle() {
        return cmTitle;
    }

    public void setCmTitle(String cmTitle) {
        this.cmTitle = cmTitle;
    }

    public String getCmContent() {
        return cmContent;
    }

    public void setCmContent(String cmContent) {
        this.cmContent = cmContent;
    }

    public boolean getCmDelete() {
        return cmDelete;
    }

    public void setCmDelete(boolean cmDelete) {
        this.cmDelete = cmDelete;
    }

    public News getNId() {
        return nId;
    }

    public void setNId(News nId) {
        this.nId = nId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmId != null ? cmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.cmId == null && other.cmId != null) || (this.cmId != null && !this.cmId.equals(other.cmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Comments[ cmId=" + cmId + " ]";
    }
    
}
