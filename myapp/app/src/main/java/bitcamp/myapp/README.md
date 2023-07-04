비트캠프 1.1.1v Readm 파일입니다.

# 국비학원 인사 관리 시스템

이 프로젝트는 국비학원의 인사 관리를 위한 시스템으로, 수강생, 직원, 게시판, 공지사항 등을 관리할 수 있습니다.

## 실행 방법

1. `App` 클래스의 `main` 메서드를 실행하여 애플리케이션을 시작합니다.
2. 프로그램이 시작되면 학원명을 입력하세요.
3. 로그인에 성공하면 메인 메뉴가 표시됩니다.
4. 원하는 메뉴를 선택하여 해당 기능을 실행할 수 있습니다.
5. 프로그램을 종료하면 변경된 데이터가 저장됩니다.

## 기능 및 구조

### 기능

0. 로그인
   - 로그인: 프로그램 시작 시 학원명을 입력하고 관리자로 로그인합니다.
   - 로그인에 성공하면 메인 메뉴가 표시됩니다.
   - 로그인에 실패하면 프로그램이 종료됩니다.

1. 수강생 관리
   - 등록: 수강생 정보를 등록할 수 있습니다.
   - 목록: 등록된 수강생 정보를 조회할 수 있습니다.
   - 조회: 특정 수강생의 상세 정보를 조회할 수 있습니다.
   - 변경: 수강생 정보를 수정할 수 있습니다.
   - 삭제: 등록된 수강생 정보를 삭제할 수 있습니다.

2. 직원 관리
   - 등록: 직원 정보를 등록할 수 있습니다.
   - 목록: 등록된 직원 정보를 조회할 수 있습니다.
   - 조회: 특정 직원의 상세 정보를 조회할 수 있습니다.
   - 변경: 직원 정보를 수정할 수 있습니다.
   - 삭제: 등록된 직원 정보를 삭제할 수 있습니다.

3. 게시판 관리
   - 등록: 게시글을 등록할 수 있습니다.
   - 목록: 등록된 게시글 목록을 조회할 수 있습니다.
   - 조회: 특정 게시글의 상세 내용을 조회할 수 있습니다.
   - 변경: 게시글의 내용을 수정할 수 있습니다.
   - 삭제: 등록된 게시글을 삭제할 수 있습니다.

4. 공지사항 관리
   - 등록: 공지사항을 등록할 수 있습니다.
   - 목록: 등록된 공지사항 목록을 조회할 수 있습니다.
   - 조회: 특정 공지사항의 상세 내용을 조회할 수 있습니다.
   - 변경: 공지사항의 내용을 수정할 수 있습니다.
   - 삭제: 등록된 공지사항을 삭제할 수 있습니다.

### 구조

- `App` 클래스: 메인 애플리케이션 클래스입니다. 프로그램의 실행 흐름을 제어하고 메뉴를 관리합니다.
- `AdminManager` 클래스: 관리자 로그인을

 처리하는 클래스입니다.
- `TrainingCenter`, `TrainingCenterEmployee`, `TrainingCenterBoard` 클래스: 수강생, 직원, 게시글의 데이터 모델 클래스입니다.
- `TrainingCenterAddListener`, `TrainingCenterListListener`, `TrainingCenterDetailListener`, `TrainingCenterUpdateListener`, `TrainingCenterDeleteListener`, `TrainingCenterEmployeeAddListener`, `TrainingCenterEmployeeListListener`, `TrainingCenterEmployeeDetailListener`, `TrainingCenterEmployeeUpdateListener`, `TrainingCenterEmployeeDeleteListener`, `TrainingCenterBoardAddListener`, `TrainingCenterBoardListListener`, `TrainingCenterBoardDetailListener`, `TrainingCenterBoardUpdateListener`, `TrainingCenterBoardDeleteListener` 클래스: 각각의 기능을 처리하는 리스너 클래스입니다.
- `BreadcrumbPrompt` 클래스: 메뉴를 표시하고 사용자의 입력을 받는 클래스입니다.
- `Menu`, `MenuGroup` 클래스: 메뉴 구조를 관리하는 클래스입니다.
- `Gson`, `GsonBuilder`, `TypeToken` 클래스: JSON 데이터의 직렬화와 역직렬화를 위해 사용되는 Gson 라이브러리 클래스입니다.
- 기타 필요한 유틸리티 클래스와 인터페이스들이 있습니다.

## 데이터 저장 및 로드

프로그램은 JSON 형식을 사용하여 데이터를 저장하고 로드합니다. 각각의 데이터 클래스(`TrainingCenter`, `TrainingCenterEmployee`, `TrainingCenterBoard`)에 대한 리스트를 생성하여 JSON 파일로 저장하고, 프로그램 시작 시 해당 JSON 파일을 로드하여 데이터를 복원합니다.

- `loadJson` 메서드: JSON 파일을 읽어와 해당 데이터 클래스의 리스트에 복원합니다.
- `saveJson` 메서드: 데이터 클래스의 리스트를 JSON 형식으로 저장합니다.

## 주의사항

- 학원명을 입력하여 개별적인 데이터 파일을 생성합니다.
- 데이터 파일은 프로그램 실행 위치에 생성됩니다.
- 데이터 파일은 JSON 형식으로 저장됩니다.
- 데이터 파일명은 학원명을 기준으로 생성되며, 각각의 데이터 유형에 따라 파일명이 구분됩니다.
- 프로그램 실행 시 로그인하여 관리자로 로그인해야 합니다.

---
