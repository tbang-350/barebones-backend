package com.basic.barebones.repository;

import com.basic.barebones.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.userName =?1")
    Optional<User> findUserByUsername(String userName);

    @Query(value = "select * from users,user_roles where users.user_id=user_roles.user_id and user_roles.role_id = 2",nativeQuery = true)
    public List<User> findAllContractors();

    @Query(value = "select * from users,user_roles where users.user_id=user_roles.user_id and user_roles.role_id = 3",nativeQuery = true)
    public List<User> findAllEmployees();

    @Query(value = "select count(user_name) from users,user_roles where users.user_id=user_roles.user_id and user_roles.role_id = 2",nativeQuery = true)
    public int countAllContractors();

    @Query(value = "select count(user_name) from users,user_roles where users.user_id=user_roles.user_id and user_roles.role_id = 3",nativeQuery = true)
    public int countAllEmployees();

    @Query(value = "select count(user_name) from users",nativeQuery = true)
    public int countAllUsers();
}
