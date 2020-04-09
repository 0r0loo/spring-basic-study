# 스프링 프레임워크 기본적인것 공부

## spring framework

- 경량의 컨테이너로서 자바 객체를 직접 관리
- POJO(Plain Old Java Object) 방식의 프레임워크
- IoC(Inversion of Control) 지원
- DI(Dependency Injection) 지원
- AOP(Aspect-Oriented Programming) 지원
- iBATIS, myBatis, Hibernate 등 데이터베이스 라이브러리 지원



## Inversion of Control(IoC)

### IoC

- 제어 역전
- 개발자가 코드의 흐름이나 객체 생성에 관련된 코드를 프로그래밍 코드에 직접 작성하는 것이 아닌 프레임워크가 사용하는 파일에 작성하면 이를 토대로 프레임워크가 객체를 생성하여 반환하고 코드가 동작하는 순서를 결정하게 된다.

### POJO Class

- POJO(Plain Old Java Object) : 자바 모델, 기능, 프레임워크 등에 따르지 않고 홀로 독립적이며 단순한 기능만 가지는 객체
- Bean 객체라고 부른다.

### IoC 컨테이너의 종류

- BeanFactory(구버젼)
- ApplicationContext(5버전)

### BeanFactory

- 클래스를 통해 객체를 생성하고 이를 전달한다.
- 상속 등 객체 간의 관계를 형성하고 관리한다.
- Bean에 관련된 설정을 위한 xml 파일은 즉시 로딩하지만 객체는 개발자가 요구할 때 생성된다.
- XmlBeanFactroy

### ApplicationContext

- 클래스를 통해 객체를 생성하고 이를 전달한다.
- 상속 등 객체 간의 관계를 형성하고 관리한다.
- 국제화 지원 등 문자열에 관련된 다양한 기능을 제공한다.
- 리스너로 등록되어 있는 Bean에 이벤트를 발생시킬 수 있다.
- Bean에 관련된 설정을 위한 xml 파일은 즉시 로딩하면서 객체를 미리 생성해서 가지고 있다.
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContext
- XmlWebApplicationContext



스프링 프레임워크는 IoC컨테이너를 이용해 Bean 객체들을 관리한다.





### Spring Bean 객체 생성

- spring에서는 사용활 Bean 객체를 bean configuration file에 정의를 하고 필요할 때 객체를 가져와 사용하는 방법을 이용한다.
- bean 태그 : 사용할 Bean을 정의하는 태그

### bean 태그의 기본 속성

- class : 객체를 생성하기 위해 사용할 클래스를 지정한다.
- id : Bean 객체를 가져오기 위해 사용하는 이름을 지정한다.
- lazy-init : 싱글톤인 경우 xml을 로딩할 때 객체 생성 여부를 설정한다. 
  - true : xml 로딩 시 객체를 생성하지 않고 객체를 가져올 때 생성한다.
- scope : 객체의 범위를 성정한다
  - singleton : 객체를 하나만 생성해서 사용한다.
  - prototype : 객체를 가져올 때 마다 객체를 생성한다.

### Bean 객체의 생명 주기

생성

1. spring의 Bean은 다음과 같은 상황일 때 객체가 생성된다.
2. Singleton 인 경우 xml 파일을 로딩 할 때 객체가 생성된다.
3. Singleton이고 lazy-init 속성이 true일 경우 getBean 메서드를 사용할 때 객체가 생성된다.
4. prototype 일 경우 getBean 메서드를 사용할 때 객체가 생성된다.

소멸

1. spring의 Bean은 다음과 같은 상황일 때 객체가 소멸된다.
2. IoC 컨테이너가 종료 될 때 객체가 소멸된다.

### 객체 생성과 소멸 시 호출될 메서드 등록

- 객체가 생성되면 가장 먼저 생성자가 호출된다.
- init-method : 생성자 호출 이후 자동으로 호출된다.
- destroy-method : 객체가 소멸될 때 자동으로 호출된다.
- default-init-method : init-method를 설정하지 않은 경우 자동으로 호출된다.
- default-detroy-method : destroy-method를 설정하지 않은 경우 자동으로 호출된다.

### 메서드가 없을 경우

- default-init-method : 아무 일도 발생하지 않는다.
- default-destroy-method : 아무 일도 발생하지 않는다.
- init-method : 오류가 발생한다.
- destroy-method : 오류가 발생한다.

### BeanPostProcessor

- Bean 객체를 정의할 때 init-method 속성을 설정하면 객체가 생성될 때 자동으로 호출될 메서드를 지정할 수 있다.
- 이 때 BeanPostProcessor 인터페이스를 구현한 클래스를 정의하면 Bean 객체를 생성할 때 호출될 init 메서드 호출을 가로채 다른 메서드를 호출 할수있다.
- postProcessBeforeInitialization : init-method에 지정된 메서드가 호출되기 전에 호출된다.
- postProcessAfterInitialization : init-method에 지정된 메서드가 호출된 후에 호출된다.
- init-method가 지정되어 있지 않더라도 자동으로 호출된다.

------



## Dependency Injection(DI)    (xml방법이랑 java방법ㅋ)

- 의존성 주입은 spring에서 아주 중요한 개념이자 장점이다.
- Bean 객체를 생성할 때 Bean 객체가 관리할 값이나 객체를 주입하는 것을 의미한다.
- Bean 객체 생성 후 Bean 객체가 가질 기본 값을 자바 코드로 설정하는 것이 아닌 Bean을 정의하는 xml 코드에서 정의하는 개념이다.

### 생성자를 통한 주입

- Bean을 정의할 때 construct-arg 태그를 이용해 주입하게 되면 생성자를 통해 주입할 수 있다.
- value : 기본 자료형 값과 문자열 값을 설정한다.
- ref : 객체를 설정한다.
- type : 저장할 값의 타입을 설정한다.
- index : 지정된 값을 주입할 생성자의 매개변수 인덱스 번호

### Setter 메서드를 통한 주입

- Bean을 정의할 때 Bean 객체가 가지고 있을 기본 값을 생성자가 아닌 Setter 메서드를 통해 주입할 수 있다.
- name : 데이터를 주입할 프로퍼티의 이름 (set 빼고 같으면됨)
- value : 기본 자료형 및 문자열을 주입할 때 사용하는 속성
- ref : 객체의 주소 값을 주입할 때 사용하는 속성

### 컬렉션 주입

- Bean을 정의할 때 주입해야 하는 멤버가 컬렉션인 경우 컬렉션이 관리할 객체를 초기에 설정할 수 있다.
- List, Map, Set, Property

### 자동 주입

- Bean을 정의할 때 주입할 객체는 생성자를 통한 주입이나 setter를 통한 주입을 사용했다.
- srping에서는 객체를 주입할 때 자동으로 주입될 수 있도록 설정할 수 있다.
- 자동 주입은 이름, 타입, 생성자를 통해할 수 있으며 autowire라는 용어로 부른다.

### 이름을 통한 주입

- autowire : byName, byType, constructor
- byName : 빈 객체의 프로퍼티 이름과 정의된 빈의 이름이 같은 것을 찾아 자동으로 주입한다.
- byType : 빈 객체의 프로퍼티 타입과 정의된 빈의 타입이 일치할 경우 주입된다.
  - 이 때, 동일 타입의 빈이 두 개 이상 정의되어 있으면 오류가 발생한다.
- constructor : 생성자의 매개 변수 타입과 정의된 빈의 타입이 일치할 경우 주입된다.
  - 이 때, 동일 타입의 빈이 두 개 이상 정의되어 있으면 오류가 발생한다.

------



## Annotation

### Java 코드를 활용한 Bean 등록 방법!

- xxx.xml 파일을 만들어 이를 통해 빈 객체를 생성하고 java코드에서 가져와서 사용하였지만~
- 이제는 xxx.xml 파일에 등록했던 내용을 java 파일에서 작업하는 방법!
- xml과 java파일의 차이는 xml은 값을 정해줘야 하는 반면 java 파일은 코드를 자유롭게 작성할 수 있다.

### spring context 생성

- AnnotationConfigApplicationContext

### @Configuration

- @Configuration 어노테이션은 현재 자바 파일이 빈 등록을 위한 자바 파일임을 알려준다.

### @Bean

- @Bean 어노테이션은 bean 객체를 정의할 때 사용한다.
- 메서드의 이름이 bean의 이름이 된다.
- @Bean(name=이름) : bean의 이름을 새롭게 정의한다.
- @Lazy : lazy-init 속성을 지정한다.
- @Scope : bean의 scope를 설정한다.
- @Primary : primary 속성을 지정한다.

### init, destroy 메서드

- 객체가 생성되거나 소멸될 때 자동으로 호출되는 메서드를 등록한다
- @Bean(initMethod="init", destroyMethod= "destroy")  (""안은 예시임)

### 주입

- Bean에 대한 주입은 생성자를 직접 호출하거나 setter 메서드를 직접 호출하여 값을 주입한다.

### 자동 주입

- @Bean(autowire=주입방식) : 자동 주입 방식을 설정한다
- Autowire.BY_NAME : 이름을 통한 자동 주입
- Autowire.BY_TYPE : 타입을 통한 자동 주입
- 스프링 5.1부터 Deprecated 되었다. 5.1부터는 Bean에 직접 설정하는 방식을 추천하고 있다.

### 어노테이션을 이용한 빈 설정

- spring 2.5버전 부터 xml을 통한 빈 설정 방법 외에 어노테이션을 이용한 빈 설정 방법을 제공하고 있다.
- 빈 설정 파일에 다음과 같은 코드를 추가하면 빈에 대한 설정을 xml 파일이 아닌 빈 클래스의 어노테이션을 검색해 반영하게 된다
- <context:annotation-config/>

### @Autowired

- 객체 타입을 통해 bean 객체를 자동으로 주입한다.

### @Qualifier

- @Autowired로 주입 시 같은 타입의 Bean이 여러 개 정의 되어 있다면 Qualifier에 설정 되어 있는 bean을 찾아 주입한다.

### 생성자 주입

- 생성자에 주입 시 참조변수 타입 변수들은 자동으로 주입되고 기본 자료형 및 문자열 값만 주입을 설정해주면 된다.
- @Value("100") int data

### JSR-250 어노테이션

- 스프링에서 기본으로 제공되지는 않지만 자바 플랫폼 공통 어노테이션인 JSR-250을 적용할 수 있다.
- 적용을 위해서는 반드시 라이브러리를 추가해야한다.

### @postConstruct

- 생성자 호출 후 자동으로 호출될 함수를 등록한다.

### @preDestroy

- 객체 소멸 전 자동으로 호출될 함수를 등록한다.

### @Resouce

- Bean의 이름을 통해 주입한다.



------



## Component

### @Component

- @Component 어노테이션을 사용하면 Bean Configuration 파일에 Bean을 등록 하지 않아도 자동으로 등록 된다.

### XML을 이용하는 방식

- Bean에 설정된 설정들을 탐색하기 위해 다음과 같이 작성

```xml
<context:component-scan base-package="com.cho.beans"/>
```

### Bean Configuration Class 사용

- Bean에 설정된 설정들을 탐색하기 위해 다음과 같이 작성

```java
@ComponentScan(basePackages={"com.cho.beans"})
```

### @Bean, @Component

- @Bean : 개발자가 Class의 코드를 수정할 수 없는 경우, 같은 클래스 타입의 Bean을 여러 개 등록할 경우
- @Component : 개발자가 Class의 코드를 수정할 수 있는 경우

***

## Componet Bean 기본 설정

### @Component

- @Component 어노테이션만 사용하면 타입을 통해 Bean 객체를 가져올 수 있다.

### @Component("이름")

- 설정한 이름으로 Bean 객체를 가져올 수 있다.

### @Lazy

- getBean 메서드를 호출할 때 객체가 생성된다.

### @Scope("prototype")

- Prototype으로 설정한다(호출할때마다 새로운 객체 생성)

### @PostConstruct, @PreDestroy

- 생성자 호출 이후 자동으로 호출될 메서드와 객체가 소멸될 때 자동으로 호출되는 메서드를 등록한다.

***

## Component 자동 주입

### Component 자동 주입

- @Bean을 통해 설정했던 주입과 동일한 방식을 이용한다.
- @Autowired : 타입을 통한 자동 주입
- @Qualifier : 이름을 통한 자동 주입
- 생성자의 경우 타입이 같은 Bean을 찾아 자동으로 주입한다.





***



## AOP

## AOP

### AOP 

- Aspect Oriented Programming : 관점 지향 프로그래밍
- 하나의 프로그램을 관점(혹은 관심사)라는 논리적인 단위로 분리하여 관리하는 개념
- 로깅, 감시, 선언적 트랜잭션, 보안, 캐싱 등 다양한 곳에서 사용되고 있다.
- 관심사를 통해 Spring Framework가 어떤 메서드가 호출 되는지 관심있게 지켜보다가 특정 메서드가 호출되면 자동으로 메서드 전과 후에 다른 메서드가 호출 될 수 있도록 한다.

### Spring AOP 용어

- Joint Point : 모듈이 삽입되어 동작하게 되는 특정 위치(메서드 호출 등)
- Point Cut : 다양한 Joint Point 중에 어떤 것을 사용할지 선택
- Advice : Joint Point에 삽입되어 동작할 수 있는 코드
- Weaving : Advice를 핵심 로직 코드에 적용 하는 것
- Aspect : Point Cut + Advice

### Spring AOP Advice 종류

- before : 메서드 호출 전에 동작하는 Advice
- after-returning : 에외 없이 호출된 메서드의 동작이 완료 되면 동작하는 Advice
- after-throwing : 호출된 메서드 동작 중 예외가 발생했을 때 동작하는 Advice
- after : 예외 발생 여부에 관계없이 호출된 메서드의 동작이 완료되면 동작하는 Advice
- around : 메서드 호출 전과 후에 동작하는 Advice

### Spring AOP 구현

- XML을 이용한 구현 방법
- @AspectJ 어노테이션을 이용한 구현 방법

### 라이브러리 추가

- org.aspectj

***

## execution 명시자

### Execution 명시자

- pointcut을 저장할 때 사용하는 문법
- execution(접근 제한자 리턴타입 클래스이름 메서드이름(매개변수))
- 접근 제한자 : public만 지원된다.
- 리턴 타입 : 메서드의 매개 변수 타입
- 클래스 이름 : 패키지를 포함한 클래스 이름
- 메서드 이름 : 메서드의 이름
- 매개 변수 : 매개변수의 형태
- *: 하나의 모든 것을 의미
- ..: 개수 상관없이 모든 것을 의미

***

## @AspectJ 어노테이션 사용하기

### @AspectJ

- @AspectJ 어노테이션을 활용해 Advisor 역할을 할 Bean을 설정

### 지원 어노테이션

- @Before : 관심사 동작 이전에 호출
- @After : 관심사 동작 이후에 호출
- @Around : 관심사 동작 이전 이후를 의미
- @AfterReturning : 예외 없이 정상적으로 종료 되었을 때 호출
- @AfterThrowing : 에외가 발생하여 종료 되었을 때 호출





***



## JDBC & MyBatis

## Spring JDBC

### Spring JDBC

- Spring Framework는 JDBC 프로그래밍을 위해 JdbcTemplate 클래스를 제공하고 있다.
- JdbcTemplate 클래스는 SQL 쿼리문을 손쉽게 구현할 수 있도록 구현되어 있다.



### 라이브러리 추가

- Spring Framework는 JDBC 프로그래밍을 위해 JdbcTemplate 클래스를 제공하고 있다.
- JdbcTemplate 클래스는 SQL 쿼리문을 손쉽게 구현할 수 있도록 구현되어 있다.

### Mapper 클래스

- Select문을 데이터를 가져올 때 어떤 컬럼의 값을 bean 어디에 주입할 것인지 결정을 해줘야 하는데 이 역할을 하는 클래스를 Mapper 클래스라고 부른다.

***

## MyBatis

### MyBatis

- Spring Framework에서 제공하는 JDBC 라이브러리를 보다 쉽게 작업할 수 있도록 만든 라이브러리
- Mapper의 역할을 확장하여 쿼리문 작성 모두 Mapper에서 할 수 있도록 지원한다.
- Spring Framework의 대표적인 JDBC 라이브러리 이다.





















