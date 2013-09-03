package sbk.dict.model.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="Request")
public class RequestBean {
	@Id
	@GeneratedValue
	@Column(name="reqId")
	int 	reqId;
	@Column(name="ip")
	String 	ip;
	@Column(name="reqtime")
	Date	reqtime;
	@Column(name="lastname")
	String  lastname;
	@Column(name="firstname")
	String  firstname;
	@Column(name="organization")
	String  organization;
	@Column(name="position")
	String  position;
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getReqtime() {
		return reqtime;
	}
	public void setReqtime(Date reqtime) {
		this.reqtime = reqtime;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
