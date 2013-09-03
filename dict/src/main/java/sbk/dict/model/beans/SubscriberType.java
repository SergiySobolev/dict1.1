package sbk.dict.model.beans;

import java.io.Serializable;
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
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="SubsciberType")
public class SubscriberType implements Serializable {
	@Id
    @GeneratedValue
    @Column(name="TypeId")
	int typeId;
	
	@Column(name="TypeDesc")
	String typeDescription;
	
	@OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="SubscriberType", nullable=false)
	Set<Subscriber> subscribersSet;
	
	public int getTypeId() {		
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeDescription() {
		return typeDescription;
	}
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	public Set<Subscriber> getSubscribersSet() {
		return subscribersSet;
	}
	public void setSubscribersSet(Set<Subscriber> subscribersSet) {
		this.subscribersSet = subscribersSet;
	}	
	public SubscriberType(){
		subscribersSet	=	new HashSet<Subscriber>();
	}
}
