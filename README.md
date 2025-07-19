# Architecture Sample for Android

### Used Architecture
- Clean Architecture
- MVVM, MVI
- Multi Modularization

### Used Library
- Coroutine (for Asynchronization)
- Retrofit2 (for Network)
- Glide (for Image)
- Dagger2 - Hilt (for Dependency Injection)
- DataBinding (for View)
- AAC ViewModel (for Viewmodel)
- Timber (for Logging)

### Used Open APIs
- Punk Beer API (https://punkapi.com/)

### Module Structure
- app (for DI, Managing Application Class)
- data 
- domain
- presentation

### Refactoring Improvements

#### 🔧 **에러 처리 개선**
- 네트워크 에러 처리 추가
- 예외 상황에 대한 적절한 사용자 피드백
- 로깅을 통한 디버깅 개선

#### 📱 **UI/UX 개선**
- 로딩 상태 표시 (ProgressBar)
- 에러 상태 표시 및 재시도 기능
- 더 나은 레이아웃 구조
- 이미지 로딩 에러 처리

#### 🏗️ **코드 구조 개선**
- 불필요한 Dispatcher 사용 제거
- 상수 파일을 통한 하드코딩 제거
- 더 나은 상태 관리
- 코드 중복 제거

#### 🧪 **테스트 준비**
- 단위 테스트 구조 준비
- Mockito를 활용한 테스트 환경 구성

#### 📊 **성능 개선**
- 네트워크 타임아웃 설정
- 이미지 로딩 최적화
- 메모리 누수 방지

### Key Features
1. **MVVM 패턴**: Model-View-ViewModel 구조
2. **MVI 패턴**: Model-View-Intent 단방향 데이터 플로우
3. **Clean Architecture**: 명확한 계층 분리
4. **Dependency Injection**: Hilt를 통한 의존성 관리
5. **Reactive Programming**: Kotlin Flow 사용
6. **Error Handling**: 포괄적인 에러 처리
7. **State Management**: 정교한 상태 관리

### Getting Started
1. Clone the repository
2. Open in Android Studio
3. Build and run the project
4. Choose between MVVM and MVI patterns

### Architecture Benefits
- **Testability**: 각 계층이 독립적으로 테스트 가능
- **Maintainability**: 명확한 책임 분리
- **Scalability**: 새로운 기능 추가 용이
- **Reusability**: 컴포넌트 재사용 가능

contact : taleskoo@gmail.com

Copyright 2023. YHKOO95. All rights reserved.
