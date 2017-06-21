package br.com.biazus.desafiosuntech.domain.model.users.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users implements UsersData {
	
	private static final long serialVersionUID = 3436583323844172018L;

	@Id
	@SequenceGenerator(name="users_sequence", sequenceName="USERS_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_sequence")
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(max=20)
    private String userName;
	
	@NotNull
	@NotEmpty
	@Size(max=20)
    private String password;
	
	@Type(type="true_false")
    private Boolean isEnabled;
    
    private Date registerDate;
    
    @NotNull
    @NotEmpty
    @Size(max=100)
    private String name;
    
    @NotNull
    @NotEmpty
    @Size(max=100)
    private String surname;
    
    @NotNull
    @NotEmpty
    @Size(max=150)
    private String email;
    
    @NotNull
    @NotEmpty
    @Size(max=11)
    private String phone;
    
    public Users() {
    }
    
    
    public Users(UsersData usersData) {
    	this.id = usersData.getId();
    	this.userName = usersData.getUserName();
    	this.password = usersData.getPassword();
    	this.isEnabled = usersData.getIsEnabled();
    	this.registerDate = usersData.getRegisterDate();
    	this.name = usersData.getName();
    	this.surname = usersData.getSurname();
    	this.email = usersData.getEmail();
    	this.phone = usersData.getPhone();
    }

    @Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	@Override
	public Date getRegisterDate() {
		return registerDate;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPhone() {
		return phone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Users other = (Users) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
