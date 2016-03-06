/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_Layer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thusha
 */
@Entity
@Table(name = "emp_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpDetails.findAll", query = "SELECT e FROM EmpDetails e"),
    @NamedQuery(name = "EmpDetails.findByEmpid", query = "SELECT e FROM EmpDetails e WHERE e.empid = :empid"),
    @NamedQuery(name = "EmpDetails.findByEmpname", query = "SELECT e FROM EmpDetails e WHERE e.empname = :empname"),
    @NamedQuery(name = "EmpDetails.findByDepartment", query = "SELECT e FROM EmpDetails e WHERE e.department = :department")})
public class EmpDetails implements Serializable {
    @Basic(optional = false)
    @Column(name = "Intime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intime;
    @Basic(optional = false)
    @Column(name = "Outtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outtime;
    @Basic(optional = false)
    @Lob
    @Column(name = "Image")
    private byte[] image;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "empid")
    private String empid;
    @Basic(optional = false)
    @Column(name = "empname")
    private String empname;
    @Basic(optional = false)
    @Column(name = "department")
    private String department;

    public EmpDetails() {
    }

    public EmpDetails(String empid) {
        this.empid = empid;
    }

    public EmpDetails(String empid, String empname, String department) {
        this.empid = empid;
        this.empname = empname;
        this.department = department;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        String oldEmpid = this.empid;
        this.empid = empid;
        changeSupport.firePropertyChange("empid", oldEmpid, empid);
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        String oldEmpname = this.empname;
        this.empname = empname;
        changeSupport.firePropertyChange("empname", oldEmpname, empname);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empid != null ? empid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpDetails)) {
            return false;
        }
        EmpDetails other = (EmpDetails) object;
        if ((this.empid == null && other.empid != null) || (this.empid != null && !this.empid.equals(other.empid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interface_Layer.EmpDetails[ empid=" + empid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        Date oldIntime = this.intime;
        this.intime = intime;
        changeSupport.firePropertyChange("intime", oldIntime, intime);
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        Date oldOuttime = this.outtime;
        this.outtime = outtime;
        changeSupport.firePropertyChange("outtime", oldOuttime, outtime);
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        byte[] oldImage = this.image;
        this.image = image;
        changeSupport.firePropertyChange("image", oldImage, image);
    }
    
}
