package kr.co.shortenUrlService.infrastructure;

import kr.co.shortenUrlService.domain.ShortenUrl;
import kr.co.shortenUrlService.domain.ShortenUrlRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//레포지토리의 역할은 '저장하는건데 이 레포지토리는 자바 자료구조에 저장하는역할을 수행
@Repository
public class MapShortenUrlRapository implements ShortenUrlRepository {
  private Map<String, ShortenUrl> shortenUrls = new ConcurrentHashMap<>();


  @Override
  public void saveShortenUrl(ShortenUrl shortenUrl) {
    shortenUrls.put(shortenUrl.getShortenUrlKey(), shortenUrl);
  }
}
