package net.seyfe.waamainlab.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Post> posts;
}