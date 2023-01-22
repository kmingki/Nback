package com.mysite.sbb;

import java.time.LocalDateTime;

public class ScoreDto {

    private Integer score;

    public ScoreDto(Integer score) {
        super();
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score){
        this.score = score;
    }
}
