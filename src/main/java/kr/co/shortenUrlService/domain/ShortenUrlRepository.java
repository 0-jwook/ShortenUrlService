package kr.co.shortenUrlService.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface ShortenUrlRepository {
  void saveShortenUrl(kr.co.shortenUrlService.domain.ShortenUrl shortenUrl);

  ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey);
}
