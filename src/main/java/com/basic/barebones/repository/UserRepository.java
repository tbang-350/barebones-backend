package com.basic.barebones.repository;

import com.basic.barebones.entity.Chartdata;
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

    @Query(value = "select sum(if(month = 'Jan' ,total,0)) as 'Jan' ,sum(if(month = 'Feb' ,total,0)) as 'Feb',sum(if(month = 'Mar' ,total,0)) as 'Mar',sum(if(month = 'Apr' ,total,0)) as 'Apr',"
            +"sum(if(month = 'May' ,total,0)) as 'May',sum(if(month = 'Jun' ,total,0)) as 'Jun',sum(if(month = 'Jul' ,total,0)) as 'Jul',sum(if(month = 'Aug' ,total,0)) as 'Aug',sum(if(month = 'Sep' ,total,0)) as 'Sep',"
            +"sum(if(month = 'Oct' ,total,0)) as 'Oct',sum(if(month = 'Nov' ,total,0)) as 'Nov',sum(if(month = 'Dec' ,total,0)) as 'Dec'"
            +"from (select min(date_format(registered_at ,'%b')) as month ,count(user_name) as total from users group by month(registered_at) order by month(registered_at)) as users",nativeQuery = true)
    Chartdata getChartdata();
}
