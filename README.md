
## 비용 관리 API

### API List
- Expense(비용) CRUD
- User CRUD


### 인증
- Spring Security + JWT

### Good
- Controller -> Service -> Repository -> Entity
- 더 추상화된 곳에서 덜 추상화된 곳으로 의존성이 흐르도록 구현 

> **Example** <br/>
Controller와 Service에서 사용하는 **DTO를 분리** <br>
(Service 계층은 Controller 계층의 어떤 것도 참조하지 않도록 함)

- 각 계층에 맞는 DTO로 변환하는 작업은 유틸성 클래스에서 수행한다. <br/>
  ex) `ExpenseAssembler`, `ExpenseDtoAssembler`