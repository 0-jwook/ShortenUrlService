# Shorten URL Service

## 프로젝트 개요
단축 URL 서비스를 제공하는 백엔드 애플리케이션입니다. 사용자가 긴 URL을 입력하면 짧은 URL을 생성하여 반환하고, 해당 단축 URL을 통해 원본 URL로 리디렉션할 수 있습니다.

## 기술 스택
- **언어**: Java
- **프레임워크**: Spring Boot
- **빌드 도구**: Gradle 또는 Maven
- **데이터 저장소**: 인메모리 저장소 (HashMap 기반)


## 주요 기능
1. **URL 단축**: 사용자가 입력한 긴 URL을 짧은 URL로 변환합니다.
2. **단축 URL 리디렉션**: 단축 URL을 통해 원본 URL로 이동할 수 있습니다.
3. **저장소 관리**: 인메모리 저장소(HashMap)를 사용하여 단축 URL 데이터를 관리합니다.

## 실행 방법
1. 프로젝트를 클론합니다:
   ```sh
   git clone https://github.com/your-repository/shorten-url-service.git
   ```
2. 프로젝트 디렉토리로 이동합니다:
   ```sh
   cd shorten-url-service
   ```
3. 애플리케이션을 실행합니다:
   ```sh
   ./gradlew bootRun  # Gradle 사용 시
   mvn spring-boot:run  # Maven 사용 시
   ```

## API 명세
### 1. URL 단축
- **Endpoint**: `POST /shorten`
- **Request Body**:
  ```json
  {
    "originalUrl": "https://example.com/long-url"
  }
  ```
- **Response**:
  ```json
  {
    "shortenedUrl": "http://localhost:8080/abcd2345"
  }
  ```

### 2. 단축 URL 리디렉션
- **Endpoint**: `GET /{shortenedKey}`
- **Response**: 302 Redirect to the original URL

## 기여 방법
1. 이슈를 확인하고 작업할 기능을 선택합니다.
2. 새로운 브랜치를 생성하고 기능을 구현합니다.
3. PR(Pull Request)을 생성하여 코드 리뷰를 요청합니다.

## 라이선스
이 프로젝트는 MIT 라이선스를 따릅니다.

