package kr.co.shortenUrlService.application;

import kr.co.shortenUrlService.domain.ShortenUrl;
import kr.co.shortenUrlService.domain.ShortenUrlRepository;
import kr.co.shortenUrlService.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenUrlService.presentation.ShortenUrlCreateResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//서비스 코드의 역할은
//컨트롤러로 부터 넘어온 requestDTO를 가지고 도메인 객체를 만들어서 레포지토리에게 전달
//그리고 만든 도메인 객를 반환하기위해 requestDTO로 변환하여 반환
@Service
public class SimpleShortenUrlService {
  private ShortenUrlRepository shortenUrlRepository;

  @Autowired
  public SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
    this.shortenUrlRepository = shortenUrlRepository;
  }


  public ShortenUrlCreateResponseDto generateShortenUrl(
          ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
  ) {
    //해야하는일 4가지
    //1. 원래 URL과 단축 URL키 생성
    String originalUrl = shortenUrlCreateRequestDto.getOriginalUrl();
    String shortenUrlKey = ShortenUrl.generateShortenUrlKey();

    //2. 원래 URL과 단축 URL키를 통해 ShortenURL 객체 생성
    ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);

    //3. 생성된 ShortenURL 객체를 레파지토리를 통해 저장
    shortenUrlRepository.saveShortenUrl(shortenUrl);

    //4. ShortenURL을 ShortenUrlCreateRequestDto로 면환하여서 반환.
    ShortenUrlCreateRequestDto shortenUrlCreateResponseDto
            = new ShortenUrlCreateRequestDto(shortenUrl);
    return null;
  }
}
