package com.mysite.sbb;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;

@RequiredArgsConstructor
@Service
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> getList() {
        return this.cardRepository.findAll();
    }

    public Card getRandomCard(Long size) {

        int index = (int)(Math.random()*size); //이것을 인덱스로 하는 카드를 가져와서 list에 붙인다. 인덱스에 맞는 조회

        Page<Card> cardPage = cardRepository.findAll(PageRequest.of(index, 1));
        Card c = null;
        if(cardPage.hasContent()) {
            c = cardPage.getContent().get(0);
        }
        return c;
    }

    public List<Card> getRandomCardList(int n) {

        ArrayList <Card> cardList = new ArrayList();

        //1. 총 카드의 갯수를 가져온다.
        Long size = this.cardRepository.count();

        for (int i = 0 ; i < n; i++) {
            //2. 개수 중 에서 랜덤한 5-6개의 카드를 뽑는다.
            Card card = getRandomCard(size);
            cardList.addAll(Arrays.asList(card, card, card, card, card));
        }

        //cardList의 원소를 중복으로 셔플해야된다.
        Collections.shuffle(cardList);

        return cardList;
    }
}
