## build
```shell
$> ./gradlew clean bootWar         
```

## deploy
```shell
$> nohup java -jar -Dspring.profiles.active=prod build/libs/demo-0.0.1-SNAPSHOT.war &
```

## stop
```shell
$> jobs
```
위 명령어로, 현재 백그라운드에서 돌아가고 있는 파일을 확인한 뒤 해당 index 를 확인하고 아래 명령어로 포어그라운드로 가져옴.
```shell
$> fg %{index}

## 예시
$> fg %1
```
그리고 나서 control + c 로 꺼주면 됨.