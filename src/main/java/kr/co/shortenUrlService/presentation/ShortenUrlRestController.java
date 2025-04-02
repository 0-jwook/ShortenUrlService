package kr.co.shortenUrlService.presentation;

import jakarta.validation.Valid;
import kr.co.shortenUrlService.application.SimpleShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortenUrlRestController {
  private SimpleShortenUrlService simpleShortenUrlService;

  @Autowired
  public ShortenUrlRestController(SimpleShortenUrlService simpleShortenUrlService) {
    this.simpleShortenUrlService = simpleShortenUrlService;
  }


  //단축 url을 생성하는 API
  @PostMapping("/shortenUrl")
  public ShortenUrlCreateResponseDto createShortenedUrl(
          @Valid @RequestBody ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
  ) {
    //서비스코드를 추가해야한다
    //DTO 타입을 반환해야한다
    ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto);

    return shortenUrlCreateResponseDto;
  }
  //key를 넘겨주면 리다이랙트 해주는 API
  @GetMapping("{shortenUrlKey")
  public ResponseEntity<?> redirectShortenUrl(){
    return ResponseEntity.ok().body(null);
  }


  //key를 넘겨주면 정보조회를 해주는 API
  @GetMapping("/shortenUrl/{shortenUrlKey")
  public ShortenUrlInformationDto getShortenUrlInformation(
          @PathVariable String shortenUrlKey
  ){
    return null;
  }
}
