# STW

Java web application sample


# System Architecture

Model-View-Controller (MVC)

## Front-end
![JSF](https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/20110510-jsf-logo.tiff/lossless-page1-320px-20110510-jsf-logo.tiff.png)
![primefaces](http://www.bradchen.com/images/primefaces-logo.png)

Front-end: JSF (JavaServer Faces)
JSF framework with primefaces javascript library to present the user interface.

http://www.primefaces.org/


## Back-end

![Spring](https://acntech.no/content/images/2016/10/logo-spring-103x60.png)
![Eclipselink](https://wiki.eclipse.org/images/6/6b/Eclipselink-logo.gif)

Back-end: Spring framework + JPA - Eclipselink

With JSF ManagedBean, get and set the form data from UI.

With Spring framework do the transaction and JPA(EclipseLink) do the java object for insert-update-delete data from database.


![MySQL](https://www.mysql.com/common/logos/logo-mysql-170x115.png)

Database: MySQL


![TomEE](http://tomee.apache.org/resources/images/feather-logo.png)

Web server: TomEE




## Directory Structure

```
stw-master
    │  README.md
    │
    ├─server_ext_jar
    │      jsf-api-2.2.9.jar
    │      jsf-impl-2.2.9.jar
    │      mysql-connector-java-5.1.36-bin.jar
    │      spring-instrument-tomcat-4.0.6.RELEASE.jar
    │
    ├─src
    │  ├─main
    │  │  └─java
    │  │      └─com
    │  │          └─stw
    │  │              ├─constant
    │  │              │      GConstant.java
    │  │              │
    │  │              ├─controller
    │  │              │  │  CTF0002Controller.java
    │  │              │  │  LangController.java
    │  │              │  │  LoginController.java
    │  │              │  │
    │  │              │  └─form
    │  │              │          CTF0002Form.java
    │  │              │          CTF0002FormDialog.java
    │  │              │          LoginForm.java
    │  │              │
    │  │              ├─converter
    │  │              │      NumberConverter.java
    │  │              │
    │  │              ├─jpa
    │  │              │      CUser.java
    │  │              │
    │  │              ├─lib
    │  │              │  ├─manager
    │  │              │  │      AccessControlManager.java
    │  │              │  │      ApplicationFilter.java
    │  │              │  │      StwSession.java
    │  │              │  │
    │  │              │  └─util
    │  │              │          UrlFilter.java
    │  │              │
    │  │              ├─resource
    │  │              │      fldlen.properties
    │  │              │      label.properties
    │  │              │      label_zh_TW.properties
    │  │              │
    │  │              └─service
    │  │                  │  CTF0002Service.java
    │  │                  │  LoginService.java
    │  │                  │
    │  │                  └─impl
    │  │                          CTF0002ServiceImpl.java
    │  │                          LoginServiceImpl.java
    │  │
    │  └─META-INF
    │          persistence.xml
    │
    └─WebContent
        │  index.jsp
        │
        ├─CTF0001
        │      ctf0001.xhtml
        │      index.jsp
        │
        ├─CTF0002
        │      ctf0002.xhtml
        │      index.jsp
        │      userDtlDialog.xhtml
        │
        ├─INDEX0001
        │      homePage.xhtml
        │      index.jsp
        │
        ├─LOGIN
        │      index.jsp
        │      login.xhtml
        │
        ├─META-INF
        │      MANIFEST.MF
        │
        ├─resources
        │  ├─css
        │  │      desktopMain.css
        │  │      main.css
        │  │      mainMenuStyles.css
        │  │      mobileMain.css
        │  │
        │  ├─img
        │  │  │  favicon.ico
        │  │  │
        │  │  ├─background
        │  │  │      white-brick.png
        │  │  │
        │  │  ├─icons
        │  │  │  ├─png
        │  │  │  │      Book.png
        │  │  │  │      Calendar.png
        │  │  │  │      Chat.png
        │  │  │  │      Clipboard.png
        │  │  │  │      Compas.png
        │  │  │  │      Gift-Box.png
        │  │  │  │      Infinity-Loop.png
        │  │  │  │      Mail.png
        │  │  │  │      Map.png
        │  │  │  │      Pensils.png
        │  │  │  │      Pocket.png
        │  │  │  │      Retina-Ready.png
        │  │  │  │      Toilet-Paper.png
        │  │  │  │      Watches.png
        │  │  │  │
        │  │  │  └─svg
        │  │  │          book.svg
        │  │  │          calendar.svg
        │  │  │          chat.svg
        │  │  │          clipboard.svg
        │  │  │          clocks.svg
        │  │  │          compas.svg
        │  │  │          gift-box.svg
        │  │  │          loop.svg
        │  │  │          mail.svg
        │  │  │          map.svg
        │  │  │          paper-bag.svg
        │  │  │          pencils.svg
        │  │  │          retina.svg
        │  │  │          ribbon.svg
        │  │  │          toilet-paper.svg
        │  │  │
        │  │  ├─loading
        │  │  │      ajax-loader.gif
        │  │  │
        │  │  ├─login
        │  │  │      icon.png
        │  │  │      imac-2x.png
        │  │  │      imac.png
        │  │  │
        │  │  ├─logo
        │  │  │      s_logo.png
        │  │  │      word_logo.png
        │  │  │
        │  │  └─tile
        │  │          ribbon-2x.png
        │  │          ribbon.png
        │  │
        │  └─js
        │          common.js
        │          mainMenuScript.js
        │
        └─WEB-INF
            │  applicationContext.xml
            │  faces-config.xml
            │  web.xml
            │
            ├─lib
            │      aopalliance-1.0.jar
            │      aristo-1.0.1.jar
            │      aspectjweaver-1.8.1.jar
            │      axis.jar
            │      c3p0-0.9.1.1.jar
            │      com.springsource.org.aopalliance_1.0.0.jar
            │      com.springsource.org.apache.commons.collections_3.2.0.jar
            │      com.springsource.org.aspectj.runtime_1.6.5.RELEASE.jar
            │      com.springsource.org.aspectj.weaver_1.6.5.RELEASE.jar
            │      com.springsource.org.objectweb.asm_2.2.3.jar
            │      commons-discovery-0.2.jar
            │      commons-lang3-3.3.2.jar
            │      commons-logging.jar
            │      dom4j-1.6.1.jar
            │      flick-1.0.10.jar
            │      gson-2.2.3.jar
            │      jaxrpc.jar
            │      jstl-1.2.jar
            │      openejb-javaagent-4.7.1.jar
            │      org.springframework.osgi.core_2.0.0.M2-SNAPSHOT.jar
            │      org.springframework.osgi.io_2.0.0.M2-SNAPSHOT.jar
            │      poi-3.10-FINAL-20140208.jar
            │      poi-3.10-FINAL.jar
            │      poi-ooxml-3.10-FINAL-20140208.jar
            │      poi-ooxml-3.10-FINAL.jar
            │      poi-ooxml-schemas-3.10-FINAL-20140208.jar
            │      poi-ooxml-schemas-3.10-FINAL.jar
            │      primefaces-5.3.jar
            │      primefaces-extensions-4.0.0.jar
            │      quartz-2.2.1.jar
            │      quartz-jobs-2.2.1.jar
            │      saaj.jar
            │      spring-aop-4.0.6.RELEASE.jar
            │      spring-aspects-4.0.6.RELEASE.jar
            │      spring-beans-4.0.6.RELEASE.jar
            │      spring-build-src-4.0.6.RELEASE.jar
            │      spring-context-4.0.6.RELEASE.jar
            │      spring-core-4.0.6.RELEASE.jar
            │      spring-expression-4.0.6.RELEASE.jar
            │      spring-framework-bom-4.0.6.RELEASE.jar
            │      spring-instrument-4.0.6.RELEASE.jar
            │      spring-instrument-tomcat-4.0.6.RELEASE.jar
            │      spring-jdbc-4.0.6.RELEASE.jar
            │      spring-jms-4.0.6.RELEASE.jar
            │      spring-messaging-4.0.6.RELEASE.jar
            │      spring-orm-4.0.6.RELEASE.jar
            │      spring-tx-4.0.6.RELEASE.jar
            │      spring-web-4.0.6.RELEASE.jar
            │      spring-webmvc-4.0.6.RELEASE.jar
            │      spring-webmvc-portlet-4.0.6.RELEASE.jar
            │      spring-websocket-4.0.6.RELEASE.jar
            │      stax-api-1.0.1.jar
            │      theme2.jar
            │      wsdl4j.jar
            │      xml-apis-1.0.b2.jar
            │      xmlbeans-2.3.0.jar
            │
            └─templates
                    blockUI.xhtml
                    mainFooter.xhtml
                    mainHeader.xhtml
                    mainTemplate.xhtml

```
