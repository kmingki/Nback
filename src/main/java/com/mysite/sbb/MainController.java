package com.mysite.sbb;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.ui.Model; //Model 객체는 자바클래스와 템플릿간의 연결고리역할을 한다. Model 객체에 값을 담아두면 템플릿에서 그 값을 사용할 수 있다.
import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.sbb.CardDto;
import com.mysite.sbb.ScoreDto;

@RequiredArgsConstructor //자동으로 생성자를 생성한다. final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할을 한다.
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

    //게임 시작 후 카드 불러오기
    @RequestMapping(value="/cards", method={ RequestMethod.GET })
    @ResponseBody //자바객체를 http응답 본문의 객체로 변환
    public List<Card> getCards() {

        List <Card> cardList = this.cardService.getRandomCardList(6);
        Collections.shuffle(cardList);
        Collections.shuffle(cardList);
        Collections.shuffle(cardList);

        //중복된 부분 섞는 역할
        cardList = this.cardService.shuffleCards(cardList);

        return cardList;
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/nback";
    }

    @PostMapping("/result")
    @ResponseBody
    public int post(@RequestBody Map<String, ArrayList> requestData) { //Json 정보가 자동으로 Map으로 변환되어 해당 변수에 저장된다.

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        ArrayList<CardDto> cards = mapper.convertValue(requestData.get("cards"), new TypeReference<ArrayList<CardDto>>(){});
        ArrayList<Object> result = requestData.get("result");

        int count = 0;
        for (int i = 0; i < result.size() ; i++) {

            String s = String.valueOf(result.get(i));

            if (s.equals("miss")) {
                continue;
            } else if (s.equals("ArrowLeft")) {
                //두번째 전과 같으면
                if (cards.get(i+3).getShape().equals(cards.get(i+1).getShape())) {
                    count+=1;
                }
            } else if (s.equals("ArrowRight")) {
                if (cards.get(i+3).getShape().equals(cards.get(i).getShape())) {
                    count+=1;
                }
            } else if (s.equals(" ")) { //space 눌렀을때
                if (!cards.get(i+3).getShape().equals(cards.get(i+1).getShape())) {
                    if (!cards.get(i+3).getShape().equals(cards.get(i).getShape())) {
                        count+=1;
                    }
                }
            }
        }

        return count;
    }

    @GetMapping("/finish") //파라미터를 안써줌
    public String endGame(ScoreDto score, Model model) {

        System.out.println(score.getScore());
        model.addAttribute("score",score.getScore());
        return "score"; //템플릿의 이름
    }
}
