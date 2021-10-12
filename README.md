# the bug report demo
the issue: https://github.com/apache/shardingsphere/issues/12994#issue-1022675388
the shardingsphere-jdbc version:5.0.0-beta
- create a table customer in your local mysql databse,you can excute the schema.sql;

- just run EncryptDemoApplication

first step: no config the encrypt rule,it will throw exception

```java
Caused by: org.hibernate.HibernateException: The database returned no natively generated identity value
	at org.hibernate.id.IdentifierGeneratorHelper.getGeneratedIdentity(IdentifierGeneratorHelper.java:75) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:61) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3199) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3805) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:330) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:287) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:193) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:123) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:102) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:720) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:706) ~[hibernate-core-5.4.25.Final.jar:5.4.25.Final]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_281]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_281]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_281]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_281]
	at org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:314) ~[spring-orm-5.2.12.RELEASE.jar:5.2.12.RELEASE]
	at com.sun.proxy.$Proxy181.persist(Unknown Source) ~[na:na]
	at org.springframework.data.jpa.repository.support.SimpleJpaRepository.save(SimpleJpaRepository.java:554) ~[spring-data-jpa-2.3.6.RELEASE.jar:2.3.6.RELEASE]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_281]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_281]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_281]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_281]
	at org.springframework.data.repository.core.support.ImplementationInvocationMetadata.invoke(ImplementationInvocationMetadata.java:72) ~[spring-data-commons-2.3.6.RELEASE.jar:2.3.6.RELEASE]
	at org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:382) ~[spring-data-commons-2.3.6.RELEASE.jar:2.3.6.RELEASE]
	at org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:205) ~[spring-data-commons-2.3.6.RELEASE.jar:2.3.6.RELEASE]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:550) ~[spring-data-commons-2.3.6.RELEASE.jar:2.3.6.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.2.12.RELEASE.jar:5.2.12.RELEASE]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:155) ~[spring-data-commons-2.3.6.RELEASE.jar:2.3.6.RELEASE]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:130) ~[spring-data-commons-2.3.6.RELEASE.jar:2.3.6.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.2.12.RELEASE.jar:5.2.12.RELEASE]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:367) ~[spring-tx-5.2.12.RELEASE.jar:5.2.12.RELEASE]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:118) ~[spring-tx-5.2.12.RELEASE.jar:5.2.12.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.2.12.RELEASE.jar:5.2.12.RELEASE]
	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:139) ~[spring-tx-5.2.12.RELEASE.jar:5.2.12.RELEASE]
	... 14 common frames omitted
```

second step: add the encrypt rule below,and  it run well
```xml
spring.shardingsphere.rules.encrypt.tables.customer.columns.first_name.cipher-column=first_name_cipher
spring.shardingsphere.rules.encrypt.tables.customer.columns.first_name.plain-column=first_name
spring.shardingsphere.rules.encrypt.tables.customer.columns.first_name.encryptor-name=name-encryptor
```


it also run well with the version 4.1.1,you can try

```xml
        <dependency>
            <groupId>org.apache.shardingsphere</groupId>
            <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
            <version>4.1.1</version>
        </dependency>

        <dependency>
            <groupId>org.apache.shardingsphere</groupId>
            <artifactId>sharding-jdbc-spring-namespace</artifactId>
            <version>4.1.1</version>
        </dependency>
```
4.1.1 config properties
````
spring.shardingsphere.datasource.name=ds
spring.shardingsphere.datasource.ds.type=com.zaxxer.hikari.HikariDataSource
spring.shardingsphere.datasource.ds.driver-class-name=com.mysql.jdbc.Driver
spring.shardingsphere.datasource.ds.jdbc-url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8
spring.shardingsphere.datasource.ds.username=root
spring.shardingsphere.datasource.ds.password=wnw2004820048
spring.shardingsphere.encrypt.encryptors.encryptor_aes.type=aes
spring.shardingsphere.encrypt.encryptors.encryptor_aes.props.aes.key.value=1234567890123456
#spring.shardingsphere.encrypt.tables.customer.columns.first_name.plainColumn=first_name
#spring.shardingsphere.encrypt.tables.customer.columns.first_name.cipherColumn=first_name_cipher
#spring.shardingsphere.encrypt.tables.customer.columns.first_name.encryptor=encryptor_aes
spring.shardingsphere.props.sql.show=true
spring.shardingsphere.props.query.with.cipher.column=false
````
