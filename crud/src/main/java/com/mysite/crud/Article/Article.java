package com.mysite.crud.Article;

import com.mysite.crud.User.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String title;
    private String body;
    private Long userId;

    @ManyToOne
    private User user;
    // 지금 사용하려는 것은 양방향이 아닌 단방향으로 User에는 OneToMany를 사용하지 않아도 된다.
}
