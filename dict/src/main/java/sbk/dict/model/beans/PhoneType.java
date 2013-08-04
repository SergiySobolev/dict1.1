package sbk.dict.model.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PhoneType")
public class PhoneType {
	@Id
    @GeneratedValue
    @Column(name="PhoneTypeId")
	int			phoneTypeId;
	
	@Column(name="PhoneTypeDesc")
	String		phoneTypeDesc;
	
	@OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="TypeId", nullable=false, insertable=false, updatable=false)
	Set<PhoneNumber> numberSet;
	
	public int getPhoneTypeId() {
		return phoneTypeId;
	}
	public void setPhoneTypeId(int phoneTypeId) {
		this.phoneTypeId = phoneTypeId;
	}
	public String getPhoneTypeDesc() {
		return this.phoneTypeDesc;
	}
	public void setPhoneTypeDesc(String phoneTypeDesc) {
		this.phoneTypeDesc = phoneTypeDesc;
	}
	public Set<PhoneNumber> getNumberSet() {
		return numberSet;
	}
	public void setNumberSet(Set<PhoneNumber> numberSet) {
		this.numberSet = numberSet;
	}
	public PhoneType(){
		this.numberSet  = new HashSet<PhoneNumber>();
	}
}
