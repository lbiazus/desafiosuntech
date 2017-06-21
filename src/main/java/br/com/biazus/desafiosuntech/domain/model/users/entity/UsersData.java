package br.com.biazus.desafiosuntech.domain.model.users.entity;

import java.io.Serializable;
import java.util.Date;

public interface UsersData extends Serializable {

	Integer getId();
	String getUserName();
	String getPassword();
	Boolean getIsEnabled();
	Date getRegisterDate();
	String getName();
	String getSurname();
	String getEmail();
	String getPhone();
}
