# Nback Web Game

```
🎮 웹 브라우저로 N-back 게임을 즐길 수 있어요.
📈 본인의 게임 결과 추이를 확인할 수 있어요.
```

# 기술 스택


# 스크린샷


![메인스크린샷](https://user-images.githubusercontent.com/63445553/215508111-d8157e61-fa79-468d-8aa3-bbf675a0ea8f.PNG)


![채팅3_20_3](https://user-images.githubusercontent.com/63445553/215512032-e1694360-398b-4bfb-ab74-2ff521b29530.gif)


# 고민 한 점
1. 랜덤한 카드 종류를 DB로 부터 가져오는 기능
+ 페이징 기법을 응용한 방법으로 해결   
레코드를 하나의 페이지당 1개의 게시글을 가지도록 분할하고, 그 중 랜덤한 하나의 페이지만 고를 수 있도록 해결하였습니다.


# 아쉬운 점 / 개선해야 할 점
1. 같은 카드가 연속적으로 나오는 경우
2. 위의 경우를 방지하기 위해 카드 배열을 순회하여 검사하는 경우에 시간복잡도가 높아지는 경우
