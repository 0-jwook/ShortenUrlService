package kr.co.shortenUrlService.presentation;

import kr.co.shortenUrlService.domain.LackOfShortenUrlKeyException;
import kr.co.shortenUrlService.domain.NotFoundShortenUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//글로벌한 예외 처리자를 만들때 사용하는 어노테이션
public class GlobalExceptionHandler {
  @ExceptionHandler(NotFoundShortenUrlException.class)
  //NotFoundShortenUrlException 을 처리하는 메서드를 만듧. 그 메서드의 이름은 앞에 handle을 붙인다
  public ResponseEntity<?> handleNotFoundShortenUrlException(
          NotFoundShortenUrlException e
  ) {
    //아래 메시지와 함꼐 404 상태코드를 넘겨준다
    return new ResponseEntity<>("단축 Url을 찾지 못했습니다.", HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(LackOfShortenUrlKeyException.class)
  public ResponseEntity<?> handleLackOfShortenUrlKeyException(
          LackOfShortenUrlKeyException e
  ){
    return new ResponseEntity<>("단축 Url 자원이 부족합니다.", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
