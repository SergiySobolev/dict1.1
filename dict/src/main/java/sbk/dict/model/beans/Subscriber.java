package sbk.dict.model.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Subscriber")
public class Subscriber {
	@Id
	@GeneratedValue
	@Column(name="SubscriberId")
	int subscriberId;
	@Column(name="SubscriberName")
	String subscriberName;
	@Column(name="CompanyName")
	String companyName;
	@Column(name="organizationId")
	String departament;
	@Column(name="position")
	String position;
	@Column(name="SubscrLastName")
	String subscrLastName;
	@Column(name="SubscrFirstName")
	String subscrFirstName;
	@Column(name="SubscrMiddleName")
	String subscrMiddleName;
	@Column(name="SubscriberEmplId")
	String emplId;
		
	@ManyToOne
	@JoinColumn(name="SubscriberType",insertable=false,updatable=false,nullable=false)				
	SubscriberType	subsType;
	
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="SubscriberId")
	Set<PhoneNumber> phoneNumberSet;
	
	@JoinColumn(name="MobilePhone")
	String	mobilePhone;
	@JoinColumn(name="InnerPhone")
	String  innerPhone;
	@JoinColumn(name="OuterPhone")
	String  outerPhone;

	public int getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartament() {
		return departament;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSubscrLastName() {
		return subscrLastName;
	}
	public void setSubscrLastName(String subscrLastName) {
		this.subscrLastName = subscrLastName;
	}
	public String getSubscrFirstName() {
		return subscrFirstName;
	}
	public void setSubscrFirstName(String subscrFirstName) {
		this.subscrFirstName = subscrFirstName;
	}
	public String getSubscrMiddleName() {
		return subscrMiddleName;
	}
	public void setSubscrMiddleName(String subscrMiddleName) {
		this.subscrMiddleName = subscrMiddleName;
	}	
	public SubscriberType getSubsType() {
		return subsType;
	}
	public void setSubsType(SubscriberType subsType) {
		this.subsType = subsType;
	}
	public Set<PhoneNumber> getPhoneNumberSet() {
		return phoneNumberSet;
	}
	public void setPhoneNumberSet(Set<PhoneNumber> phoneNumberSet) {
		this.phoneNumberSet = phoneNumberSet;	
	}
	public String getEmplId() {
		return emplId;
	}
	public void setEmplId(String emplId) {
		this.emplId = emplId;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getInnerPhone() {
		return innerPhone;
	}
	public void setInnerPhone(String innerPhone) {
		this.innerPhone = innerPhone;
	}
	public String getOuterPhone() {
		return outerPhone;
	}
	public void setOuterPhone(String outerPhone) {
		this.outerPhone = outerPhone;
	}
	public Subscriber(){
		this.phoneNumberSet = new HashSet<PhoneNumber>();
	}
}
