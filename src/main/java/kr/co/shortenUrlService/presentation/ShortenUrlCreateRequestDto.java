package kr.co.shortenUrlService.presentation;

import jakarta.validation.constraints.NotNull;
import kr.co.shortenUrlService.domain.ShortenUrl;
import org.hibernate.validator.constraints.URL;


//사용자가 요철할 때 사용하는 데이터 형식(요청 DTO)
//실제로 요청이 날라올 때 JSON 형식으로 날라와서 스프링에서는 JSON이 DTO로 변환이 되어 받아진다
public class ShortenUrlCreateRequestDto {

  @NotNull
  @URL(regexp = "/^(https?|ftp):\\/\\/(-\\.)?([^\\s\\/?\\.#-]+\\.?)+(\\/[^\\s]*)?$/i")
  public String originalUrl;

  public ShortenUrlCreateRequestDto(ShortenUrl shortenUrl) {
  }

  public String getOriginalUrl() {
    return originalUrl;
  }
}
