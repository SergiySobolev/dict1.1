package sbk.dict.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="PhoneNumber")
public class PhoneNumber implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="PhoneId")
	int    PhoneId;	
	@ManyToOne
	@JoinColumn(name="TypeId",
	            insertable=false, updatable=false,
	            nullable=false)
	PhoneType	phoneType;	
	@ManyToOne
	@JoinColumn(name="SubscriberId",
	            insertable=false, updatable=false,
	            nullable=false)
	Subscriber	subscriber;	
	@Column(name="PhoneNumber")
	String phoneNumber;
	public int getPhoneId() {
		return PhoneId;
	}
	public void setPhoneId(int phoneId) {
		PhoneId = phoneId;
	}
	public PhoneType getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}
	public Subscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
