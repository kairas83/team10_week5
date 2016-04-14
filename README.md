#TEAM10 WEEk5
-----------------------------
##MEMBER(username)
* Bark WonHo		(kairas83)
* Hong SangGi		(sanggihong)
* Yoon HyunGyu		(yoonhg)
* Choi HyunWoo		(chw1787)

-----------------------------
##실행방법
이 프로그램은 하나의 argument 입력 또는 입력이 없음을 전제하고있습니다.

argument값은 입력받을 텍스트파일의 이름입니다.
입력이 없을 때 디폴트값은`input_default.txt`입니다.

해당 텍스트파일의 내용은 plan, 사용한 시간, 회선 수가 순서대로 공백으로 나뉘어져있어야 하며,
한 줄당 하나의 account정보임을 전제하고있습니다.

예시) `input_default.txt`의 내용

gold 878 4

gold 1123 1

gold 1123 4

silver 523 2

silver 44 5

silver 521 5

-----------------------------

입력으로 줄 텍스트파일은 프로젝트폴더 최상위에 존재해야합니다

phonebill

　　├ **((your textfile))**

　　└ src

　　　├ main
  
　　　│　└ java
 
　　　│　　└ org
  
　　　│　　　└ iptime
  
　　　│　　　　└ kairas
  
　　　│　　　　　└ phonebill
  
　　　└ test
  
-----------------------------

##실행 명령어
argument 입력 없을 때 `mvn exec:java -Dexec.mainClass="org.iptime.kairas.phonebill.App"`

argument 입력 있을 때 `mvn exec:java -Dexec.mainClass="org.iptime.kairas.phonebill.App" -Dexec.args="filename.txt"`

-----------------------------
##과정상세

###전화 요금 조회 프로그램

전화 요금을 계산해주는 프로그램입니다. 
프로그램의 구성은 메인   App, file 입력을 받고, 로그를 출력하는 AppView, 고객의 정보를 저장할  Account, 계산을 하는 Calculator,
그리고 Account와 Calculator를 이용해 고지서를 구성하는 PhoneBill이 있습니다.
Gold, Silver는 각각의 plan 특성을 저장하며 이는 Plan 클래스를 상속하고 있습니다.

* App은 주요 흐름을 관장합니다.
AppView에 file입력에 대한 결과로 Account로 이루어진 LinkedList를 요구하고, 해당 결과를 다시 PhoneBill에 넘겨주며 고지서를 구성할 String값을 요구합니다.

* PhoneBill은 Account의 입력이 들어오는대로 해당 Account정보를 넘겨주며 Calculator에 요금 계산을 요구한 후,
Calculator와 Account에 저장된 정보들을 토대로 고지서를 구성합니다.

* Account는 플랜타입,사용시간,회선수를 저장하고 있습니다.

* Calculator는 계산을 요구받으면 받은 Account정보와 미리 선언된 Plan객체들을 이용해 적절한 방법으로 계산하며, 결과를 바로 리턴하지 않고 각각 총 요금과, 요금에 대한 계산식을 내부 인자에 저장후, 해당 값에 대한 요청이 있을 때에야 값을 반환합니다.

* Plan은 정보들을 갖게 될 부모 클래스입니다.
각각 Plan 정보들에 대한 값은 자식 클래스인 Gold, Silver 선언시 입력됩니다.
Calculator는 내부 인자로 Plan의 자식 클래스당, 해당 객체 하나를 소유하고있어야합니다.

![Alt text](http://cfile1.uf.tistory.com/image/255D8B4E51ADD7CD04EF09 "optional text")
