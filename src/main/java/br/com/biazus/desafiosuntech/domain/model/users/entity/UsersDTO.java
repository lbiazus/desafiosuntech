package br.com.biazus.desafiosuntech.domain.model.users.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UsersDTO implements UsersData {

	private static final long serialVersionUID = 3680347395512916818L;
	
	private Integer id;
	private String userName;
	private String password;
	private Boolean isEnabled;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date registerDate;
	private String name;
	private String surname;
	private String email;
	private String phone;
	
	public UsersDTO() {
	}
	
	public UsersDTO(UsersData usersData) {
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
