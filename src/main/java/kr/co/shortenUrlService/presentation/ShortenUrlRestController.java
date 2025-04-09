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


  //단축 URL을 생성하는 API
  @PostMapping("/shortenUrl")
  public kr.co.shortenUrlService.presentation.ShortenUrlCreateResponseDto createShortenUrl(
          @Valid @RequestBody kr.co.shortenUrlService.presentation.ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
  ) {
    //서비스 코드를 추가해야한다.
    //그리고 DTO타입으로 반환해야한다.
    kr.co.shortenUrlService.presentation.ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto);

    return shortenUrlCreateResponseDto;
  }

  //key를 넘겨주면 리다이렉트해주는 API
  @GetMapping("{shortenUrlKey}")
  public ResponseEntity<?> redirectShortenUrl() {
    return ResponseEntity.ok().body(null);
  }

  //key를 넘겨주면 정보를 조회해주는 API
  @GetMapping("/shortenUrl/{shortenUrlKey}")
  public kr.co.shortenUrlService.presentation.ShortenUrlInformationDto getShortenUrlInformation(
          @PathVariable String shortenUrlKey
  ) {
    ShortenUrlInformationDto shortenUrlInformationDto= simpleShortenUrlService.getshortenUrlInformationByShortenUrlKey(shortenUrlKey);

    return shortenUrlInformationDto;
  }
}
