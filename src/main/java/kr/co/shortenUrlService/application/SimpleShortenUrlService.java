package kr.co.shortenUrlService.application;
import kr.co.shortenUrlService.domain.ShortenUrl;
import kr.co.shortenUrlService.domain.ShortenUrlRepository;
import kr.co.shortenUrlService.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenUrlService.presentation.ShortenUrlCreateResponseDto;
import kr.co.shortenUrlService.presentation.ShortenUrlInformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//서비스 코드의 역할은
//컨트롤러로 부터 넘어온 requestDto를 가지고 도메인객체를 만들어서 레포지토리에게 전달
//그리고 만든 도메인 객체를 반환하기위해 responseDto로 변환하여 반환
@Service
public class SimpleShortenUrlService {
  private final ShortenUrlRepository shortenUrlRepository;

  @Autowired
  public SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
    this.shortenUrlRepository = shortenUrlRepository;
  }


  public ShortenUrlCreateResponseDto generateShortenUrl(
          ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
  ) {
    //해야하는 일 4가지
    //1. 원래 URL과 단축URL키 생성
    String originalUrl = shortenUrlCreateRequestDto.getOriginalUrl();
    String shortenUrlkey = ShortenUrl.generateShortenUrlKey();

    //2. 원래 URL과 단축 URL키를 통해 ShortenUrl 객체 생성
    ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlkey);

    //생성된 ShortenUrl 객체를 레포지토리를 통해 저장
    shortenUrlRepository.saveShortenUrl(shortenUrl);

    //ShortenUrl을 ShortenUrlCreateResponseDto로 변환하여서 반환.
    ShortenUrlCreateResponseDto shortenUrlCreateResponseDto
            = new ShortenUrlCreateResponseDto(shortenUrl);
    return null;
  }

  public ShortenUrlInformationDto getshortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
    //shotenUrlInfo를 찾기전에 일단 먼저 key로 shortenUrl도메인 객체부터 찾는다.
    ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);
    //찾은 shortenUrl을 이용해서 shortenUrlInforamtionDto를 생성해서 반환한다
    ShortenUrlInformationDto shortenUrlInformationDto = new ShortenUrlInformationDto(shortenUrl);
    return shortenUrlInformationDto;
  }
}
