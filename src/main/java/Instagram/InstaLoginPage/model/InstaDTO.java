package Instagram.InstaLoginPage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "insta_dto")

public class InstaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int userId;

    @Column
    private String accountHolderName;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String  contact;

    @Column
    private  String password;
}
