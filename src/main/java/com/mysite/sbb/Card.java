package com.mysite.sbb;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String shape;

    @Column(length = 500)
    private String path;

    @CreatedDate
    private LocalDateTime createDate;

    @Builder
    public Card(String shape, String path, LocalDateTime time) {
        this.shape = shape;
        this.path = path;
        this.createDate = time;
    }

}
