package com.mysite.sbb;

import lombok.Data;
import lombok.Setter;
import lombok.AccessLevel;
import java.time.LocalDateTime;

@Data
@Setter(AccessLevel.NONE)
public class CardDto {
    private Integer id;
    @Setter
    private String shape;
    @Setter
    private String path;
    @Setter
    private LocalDateTime createDate;

    public CardDto() {

    }

    public CardDto(Integer id, String shape, String path) {
        super(); //뭐야?
        this.id = id;
        this.shape = shape;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }
    public String getShape() {
        return shape;
    }

    public void setShape(String shape){
        this.shape = shape;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getDate(LocalDateTime createDate){
        return createDate;
    }
    public void setDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

}
