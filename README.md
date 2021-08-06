
# MVC모델(Spring) 숙달을 위한 console만을 이용한 게시판


- 회원, CRUD게시판, 게시판 답글 구현

![console MVC ](https://user-images.githubusercontent.com/80736178/128418431-54a2a633-e4e8-4891-b2d2-276bff29d1de.png)

* Start, Controller , Front, domain, Repository로 구성

1. Front 패키지의 구성 => 최대한 Spring의 html파일과 흡사하게 만들어봄. 차이점은 thymeleaf /어노테이션

![front구성](https://user-images.githubusercontent.com/80736178/128495217-3138c709-1a1b-4876-b7fb-82f3dafbcbfe.png)

2. 나머지는 보통의 Java파일과 크게 다를 바 없음.



# Console 실행

* 1. 회원

![회원가입로그인보드리스트](https://user-images.githubusercontent.com/80736178/128495515-96fabe0c-3087-4a60-b12d-463326fd417a.png)


* 2. 게시판 - [Create, Read]
![작성](https://user-images.githubusercontent.com/80736178/128495649-95d1527f-6259-49f8-8098-5192f4325efb.png)

![작성확인](https://user-images.githubusercontent.com/80736178/128495654-e248c306-13b6-47c0-a352-24661b05cb37.png)

* 3.댓글 (게시판 조회창에서 실행)
![댓글작성](https://user-images.githubusercontent.com/80736178/128495782-96d70497-47de-4ac4-9055-8163e0db2831.png)

![댓글목록](https://user-images.githubusercontent.com/80736178/128495776-d98641a8-bf02-46f7-ad44-4cf00f64af50.png)

![댓글삭제](https://user-images.githubusercontent.com/80736178/128495780-ff4c6830-c832-4a46-89ce-638286127f1e.png)


4.게시판(update, delete)

![수정](https://user-images.githubusercontent.com/80736178/128495983-70abc4aa-e15a-4bd7-a149-4d276aabd04d.png)
![삭제](https://user-images.githubusercontent.com/80736178/128495991-03b41065-7b1e-4798-8e5d-aa2e5d663cd6.png)
