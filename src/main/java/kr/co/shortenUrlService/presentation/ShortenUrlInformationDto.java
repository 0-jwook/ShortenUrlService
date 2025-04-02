package kr.co.shortenUrlService.presentation;

public class ShortenUrlInformationDto {
  private String originalUrl;
  private String shortenUrlKey;
  private Integer redirectCount;

  public String getOriginalUrl() {
    return originalUrl;
  }

  public String getShortedUrlKey() {
    return shortenUrlKey;
  }

  public Integer getRedirectCount() {
    return redirectCount;
  }
}
