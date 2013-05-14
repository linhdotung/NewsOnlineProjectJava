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
@Table(name = "BlackListWords")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlackListWords.findAll", query = "SELECT b FROM BlackListWords b"),
    @NamedQuery(name = "BlackListWords.findByBId", query = "SELECT b FROM BlackListWords b WHERE b.bId = :bId"),
    @NamedQuery(name = "BlackListWords.findByBWord", query = "SELECT b FROM BlackListWords b WHERE b.bWord = :bWord")})
public class BlackListWords implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_id")
    private Integer bId;
    @Size(max = 100)
    @Column(name = "b_word")
    private String bWord;

    public BlackListWords() {
    }

    public BlackListWords(Integer bId) {
        this.bId = bId;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public String getBWord() {
        return bWord;
    }

    public void setBWord(String bWord) {
        this.bWord = bWord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlackListWords)) {
            return false;
        }
        BlackListWords other = (BlackListWords) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.BlackListWords[ bId=" + bId + " ]";
    }
    
}
