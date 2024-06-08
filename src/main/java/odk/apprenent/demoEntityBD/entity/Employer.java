package odk.apprenent.demoEntityBD.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String name;
    private String address;
    private String phone;

    @ManyToOne
    private Departement departement;

}
