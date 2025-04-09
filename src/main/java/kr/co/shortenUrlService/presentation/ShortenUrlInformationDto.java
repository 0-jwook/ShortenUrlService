package kr.co.shortenUrlService.presentation;

import kr.co.shortenUrlService.domain.ShortenUrl;

public class ShortenUrlInformationDto {
  private String originalUrl;
  private String shortenUrlKey;
  private Integer redirectCount;

  public ShortenUrlInformationDto(ShortenUrl shortenUrl) {
    this.originalUrl = shortenUrl.getOriginalUrl();
    this.shortenUrlKey = shortenUrl.getShortenUrlKey();
    this.redirectCount = shortenUrl.getRedirectCount();
  }

  public String getOriginalUrl() {
    return originalUrl;
  }

  public String getShortenUrlKey() {
    return shortenUrlKey;
  }

  public Integer getRedirectCount() {
    return redirectCount;
  }
}
