package mvctest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities", indexes = @Index(unique = true, columnList="username, authority"))
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String authority;

	@ManyToOne
    @JoinColumn(name = "username", nullable = false)
	private User user;
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
}
