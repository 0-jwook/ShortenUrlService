package kr.co.shortenUrlService.domain;


import java.util.Random;

//여기서 비밀리에 매우중요하게 수행되는 핵심 비지니스 로직이 저장되어야함
//이를테면 키생성 알고리즘 같은거
public class ShortenUrl {
  private String originalUrl;
  private String shortenUrlKey;
  private  Long redirectCount;

  public ShortenUrl(String originalUrl, String shortenUrlKey) {
    this.originalUrl = originalUrl;
    this.shortenUrlKey = shortenUrlKey;
    this.redirectCount = 0L;
  }

  public static String generateShortenUrlKey(){
    String base56Characters = "23456789qwertyupasdfghjkzxcvbnmQWERTYUASDFGHJKLZXCVBNM";
    Random random = new Random();
    StringBuilder shortenUrlKey = new StringBuilder();
    for(int counter = 0; counter < 8; counter++){
      char base56Character =
              base56Characters.charAt(random.nextInt(base56Characters.length()));
      shortenUrlKey.append(base56Character);
    }

    return shortenUrlKey.toString();
  }

  public String getShortenUrlKey() {
    return shortenUrlKey;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }
}
