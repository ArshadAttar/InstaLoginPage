package Instagram.InstaLoginPage.repository;

import Instagram.InstaLoginPage.model.InstaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<InstaDTO,Integer> {
        @Query("select i from InstaDTO i where (i.email=:data OR i.userName=:data OR i.contact=:data) AND i.password=:password")
        InstaDTO findByUserData(@Param("data") String data, @Param("password") String password);
}
