package com.mysite.sbb;

import java.time.LocalDateTime;

/*
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/* 작성한 리포지터리를 테스트하기 위해서 jUnit 기반의 스프링부트 테스트 프레임 워크*/

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //인메모리 데이터베이스 말고 mysql 사용하기위한 용도
@Commit
class SbbApplicationTests {

	@Autowired
	private CardRepository cardRepository;

	@Test
	void create() {

		String diamond_string = "diamond";
		String diamond_path = "img/diamond.png";
		Card diamond = Card.builder().shape(diamond_string).path(diamond_path).createDate(LocalDateTime.now()).build();
		Card edge = Card.builder().shape("edge").path("img/edge.png").createDate(LocalDateTime.now()).build();
		Card heart = Card.builder().shape("heart").path("img/heart.png").createDate(LocalDateTime.now()).build();
		Card molecule = Card.builder().shape("molecule").path("img/molecule.png").createDate(LocalDateTime.now()).build();
		Card sides = Card.builder().shape("sides").path("img/sides.png").createDate(LocalDateTime.now()).build();
		Card zigzag = Card.builder().shape("zigzag").path("img/zigzag.png").createDate(LocalDateTime.now()).build();

		this.cardRepository.save(diamond); // 다이아몬드 카드 저장
		this.cardRepository.save(edge);
		this.cardRepository.save(heart);
		this.cardRepository.save(molecule);
		this.cardRepository.save(sides);
		this.cardRepository.save(zigzag);
	}

}
