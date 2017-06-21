package br.com.biazus.desafiosuntech.domain.model.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import br.com.biazus.desafiosuntech.domain.model.users.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>, QueryByExampleExecutor<Users> {

}
