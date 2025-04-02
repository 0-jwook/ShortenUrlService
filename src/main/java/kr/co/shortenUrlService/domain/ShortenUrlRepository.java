package kr.co.shortenUrlService.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface ShortenUrlRepository {
  void saveShortenUrl(ShortenUrl shortenUrl);
}
