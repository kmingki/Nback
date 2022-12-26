package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Collections;
import org.springframework.ui.Model; //Model 객체는 자바클래스와 템플릿간의 연결고리역할을 한다.
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor //자동으로 생성자를 생성한다.
@Controller
public class MainController {
    private final CardService cardService;

    @GetMapping("/nback")
    public String index() {
        return "loading"; //템플릿의 이름
    }

    @GetMapping("/start")
    public String start(Model model) {
        return "start"; //본 게임
    }
    @RequestMapping(value="/cards", method={ RequestMethod.GET })
    @ResponseBody //자바객체를 http응답 본문의 객체로 변환
    public List<Card> getCards() {

        List <Card> cardList = this.cardService.getRandomCardList(6);
        Collections.shuffle(cardList);

        return cardList;
    }
    @GetMapping("/")
    public String root(){
        return "redirect:/nback";
    }


}
