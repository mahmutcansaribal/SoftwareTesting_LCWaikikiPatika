
# İçindekiler
### [Proje Açıklaması](#proje-açıklaması)
### [Çevresel Bilgiler](#çevresel-bilgiler)
### [Kullanılan Teknolojiler ve Araçlar](#kullanılan-teknolojiler-ve-araçlar)
### [Proje Yapısı](#proje-yapısı)
### [Kullanılan Yapı](#kullanılan-yapı)
### [Test Senaryoları](#test-senaryoları)
### [BaseTest ve BasePage Sınıfları Yapısı ](#basetest-ve-basepage-sınıfları-yapısı)
### [Test Sınıfı ve Page Sınıfı Etkileşimi](#test-sınıfı-ve-page-sınıfı-etkileşimi)
### [Raporlama Araçları : Allure Report ve Extent Report](#raporlama-araçları--allure-report-ve-extent-report)
### [Proje Çalışır Ekran Görüntüsü/Videosu](#proje-çalişir-ekran-görüntüsüvideosu)
## Proje Açıklaması

Bu proje, LCW  e-ticaret platformunda kullanıcı akışlarını test etmek ve doğrulamak amacıyla geliştirilmiş bir otomasyon test paketidir. 
Test senaryoları, kullanıcı girişinden, ürünü aramaya, filtreleme ve sıralama işlemlerine kadar çeşitli işlemleri kapsamaktadır.
Proje, **Java**, **Selenium**, **TestNG**, **Allure Report**, **Extent Report**, **Log4j2** gibi teknolojilerle desteklenmiş ve **Page Object Model** tasarım deseni kullanılarak geliştirilmiştir.

---
## Çevresel Bilgiler

- **İşletim Sistemi** : Windows 11 64-bit
- **Tarayıcı** : Google Chrome Version 131.0.6778.87
- **Java Version** : OpenJDK 21
- **IDE** : IntelliJ IDEA Community Edition 2024.3
---
- **İşlemci** : Intel Core i5 9300H
- **RAM** : 16GB
- **Monitör** : 2560x1440 
---
## Kullanılan Teknolojiler ve Araçlar

- **Programlama Dili** : Java
- **JAVA JDK** : 21
- **Test Framework** : TestNG
- **Otomasyon Tool** : Selenium WebDriver
- **Raporlama Tool** : Allure Report, Extent Report, Log4j2
- **Build Tool** : Maven
---
## Proje Yapısı
Bu proje, **Page Object Model (POM)** tasarım desenini kullanarak oluşturulmuştur. POM, her sayfa için ayrı bir sınıf (Page Class) oluşturmayı ve testlerin bu sayfa nesneleriyle etkileşimde bulunmasını sağlar. Bu sayede, test senaryoları ve sayfa nesneleri birbirinden bağımsız hale gelir ve kodun bakımı kolaylaşır.
### Kullanılan Yapı

- **Page Object**: Her web sayfası için ayrı bir sınıf (örneğin, `HomePage`, `ProductPage`, `CartPage`) oluşturulmuştur. Bu sınıflar, sayfanın elementleri ve bu elementlerle yapılacak işlemleri içerir.
- **Test Sınıfları**: Test senaryoları, ilgili sayfa nesneleriyle etkileşimde bulunarak gerçekleştirilmektedir.

---
## Test Senaryoları

| Test Name               | Test Scenario                                                         | Status | Expected Result                                                       | Actual Result                                                   | Açıklamalar                            |
|-------------------------|-----------------------------------------------------------------------|--------|-----------------------------------------------------------------------|-----------------------------------------------------------------|----------------------------------------|
| LogIn Test              | Kullanıcı giriş yapma butonuna tıklama işlemi.                        | Pass   | Giriş sayfası açılmalı.                                               | Giriş sayfası başarıyla açıldı.                                 | Giriş sayfası çalışıyor.               |
| LogOn Test              | Kullanıcı giriş işlemi.                                               | Pass   | Kullanıcı giriş yapmalı.                                              | Kullanıcı başarıyla giriş yaptı.                                | Kullanıcı başarılı giriş yaptı.        |
| Category Selection Test | Kategori seçme işlemi.                                                | Pass   | Kategori seçimi yapılmalı.                                            | Kategori başarıyla seçildi.                                     | Kategori seçimi doğru şekilde yapıldı. |
| Product Test            | Ürün filtreleme, listeleme ve seçme işlemi.                           | Pass   | Ürünler filtrelenmeli ve listelenmeli                                 | Ürünler doğru şekilde listelendi.                               | Filtreleme ve ürün seçimi doğru        |
| Product Detail Test     | Ürün detaylarının görüntülenmesi ve ürün özellikleri seçme işlemleri. | Pass   | Ürün detayları doğru şekilde görüntülenmeli ve boy özelliği seçilmeli | Ürün detayları başarıyla görüntülendi ve boy özelliği seçildi.  | Ürün detayları doğru görüntülendi.     |
| Cart Test               | Ürün detaylarını kontrol etme ve favorilere ekleme işlemleri.         | Pass   | Ürünler sepete eklenmeli ve favoriler ekranına gidilmeli.             | Ürünler başarıyla sepete eklendi ve favoriler ekranına gidildi. | Sepet işlemleri doğru çalıştı          |

---
## BaseTest ve BasePage Sınıfları Yapısı
### BaseTest

**BaseTest** sınıfı, tüm testlerin temelini oluşturmaktadır. Aşağıda bulunan işlemleri içerir.
- WebDriver başlatma ve bitirme.
- Test öncesi ve sonrası yapılacak işlemler.

````
public WebDriver driver;
    public String baseUrl = "https://www.lcw.com/";

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
````
Bu sınıf, tüm testlerde ortak kullanılan yapı taşlarını içerdiği için her test sınıfı **BaseTest** sınıfından türetilir.

Proje içerisinden örnek bir Test Class;

````
public class LogInTest extends BaseTest {

    HomePage homePage;

    @Test
    @Description("Test Description: Clicking the 'Sign In' button to navigate to the login page.")
    @Severity(SeverityLevel.CRITICAL)
    public void logInTest(){
        homePage = new HomePage(driver);
        homePage.goToLoginPage();
    }
}
````
---
BaseTest Class, Test Class, Page Classes ve BasePage Class arasındaki zincir yapısı;
### Zincir Yapı

1- LogInTest Class (BaseTest Extend Etme) 

``public class LogInTest extends BaseTest {``

- LogInTest Class, BaseTest Class'tan extend edilir.
- BaseTest Class, testlerin temelini oluşturur ve WebDriver nesnesi, testin başlatılması ve bitirlmesi gibi ortak işlemler tanımlanır
- LogInTest Class, BaseTest'ı extend ederek. BaseTest sınıfındaki tüm özelliklere ve metotlara erişebilir. Yani driver gibi ortak nesneleri kullanabilir

2- HomePage Class vs. Driver Nesnesi Gönderme

``homePage = new HomePage(driver);``

- LogInTest Class'ında, ``homePage`` nesnesi HomePage sınıfının bir örnegi olarak oluşturulur.
- Buradaki driver, BaseTest sınıfından gelir.
- Bu sayede LogInTest Class, HomePage Classının Constructor'ına **driver** nesnesini iletebilir.

3- HomePage Constructor ve super() Kullanımı

```
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);  
    }
}
```
- HomePage sınıfının constructor'ı, driver nesnesini parametre olarak alır ve bu nesnesi BasePage sınıfına iletir.
- HomePage sınıfı BasePage sınıfından türediği için, **super(driver)** çağrısı, driver nesnesini BasePage sınıfına aktarır.

4- BasePage Class'ı

```
public class BasePage {
    WebDriver driver;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
```
- BasePage sınıfı,, tüm sayfa nesnelerinin temel sınıfıdır. Burada WebDriver nesnesi sınıfın bir parçası haline gelir.
- BasePage sınıfındaki constructor, driver nesnesini alır ve bu nesneyi sınıfın bir değişkeni olarak saklar.
- HomePage ve diğer Page Class'lar BasePage sınıfından türediği için, driver nesnesi bu sınıflarda da kullanılabilir.

Bu şekilde homePage ve diğer Page sınıfları, driver nesnesine erişim sağlar.
![Akış Şeması](https://github.com/mahmutcansaribal/SoftwareTesting_LCWaikikiPatika/blob/main/assets/AkisSemasi.png?raw=true)

---
### BasePage
**BasePage** class, sayfa nesnelerinin ortak işlemlerini içerir ve **Page Object Model (POM)** desenini uygular.

BasePage class'da, driver, wait, actions gibi tüm Pages classlarında kullanılacak ortak işlemler için bir yapı inşaa ettim.
Örneğin element bulma, tıklama, veri yazma, yönlendirme, listeleme gibi temel fonksiyonları BasePage içerisine yazarak diğer page classların kalıtımla bu fonksiyonlara erişimini sağladım.
Burada **Dont Repeat Yourself (DRY)**, yani kendini tekrarlama ilkesine bağlı kalarak Clean Code tekniğinde geliştirmeler yapmaya odaklandım.

BasePage Class neler içeriyor bir kaç örnek;

Elementleri bulmak için kullandığım fonksiyon.
```
public WebElement find(By locator){
        return driver.findElement(locator);
    }
```
Elementlere tıklama işlemi için kullandığım fonksiyon.
```
public void click(By locator){
        find(locator).click();
    }
```
Loading animasyonunda testlerin başarısız olmasını engellemek için geçiş animasyonunun invisible edilmesini beklediğim fonksiyon.
```
    public void waitToLoadingAnimation(){
        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeContains(
                        By.cssSelector(".desktop-filter-area"),
                        "class",
                        "desktop-filter-area--fetching")
        ));
    }
```
Bu tarz bir çok Page Class'da kullanılacak kodları tek seferde yazarak Clean Code ve DRY ilkesine bağlı kalmaya çalıştım.

---

## Test Sınıfı ve Page Sınıfı Etkileşimi

Test sınıfları, sayfa sınıflarını kullanarak test senaryolarını çalıştırır. Aşağıda, HomeTest sınıfından bir örnek verilmiştir.

```
    HomePage homePage;

    @Test
    @Description("Test Description: Clicking the 'Sign In' button to navigate to the login page.")
    @Severity(SeverityLevel.CRITICAL)
    public void logInTest(){
        homePage = new HomePage(driver);
        homePage.goToLoginPage();
    }
```
Bu test sınıfı, HomePage sayfasındaki öğeleri ve kullanıcı akışını test etmek amacıyla yazılmıştır. 
HomePage sınıfı, ana sayfada bulunan öğelere erişim sağlayan ve bu öğelerle etkileşime giren yöntemleri içerir. 
Bu sınıfta, kullanıcı girişine yönlendiren bir test senaryosu bulunmaktadır.
- Test Adı: logInTest
- Test Açıklaması: Bu test, ana sayfadaki "Sign In" (Giriş Yap) butonuna tıklayarak kullanıcıyı giriş sayfasına yönlendirmeyi doğrular.

Test Adımı:
- HomePage sınıfından bir örnek oluşturuluyor.
- goToLoginPage() metodu kullanılarak ana sayfadan giriş sayfasına yönlendirilir.
  
Testin açıklaması ve kritik seviyesi, raporlama araçları (Allure, Extent Reports) tarafından raporlanarak testin kritik önemini belirtir. Bu, testin başarılı olmasının ve sistemin doğru şekilde çalışmasının kritik olduğunu gösterir.

Sayfa sınıfları, her bir sayfada yapılacak işlemleri içerir.
HomePage sınıfında, giriş sayfasına yönlendiren ``goToLoginPage()`` metodu bulunmaktadır.

```
    By cookiesAccept = By.id("cookieseal-banner-accept"); // Çerez kabul butonu
    
    @FindBy(id="user_1_")
    WebElement logInBtn; // Giriş yap butonu
    
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }
    
    public HomePage goToLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAccept));
        click(cookiesAccept);

        wait.until(ExpectedConditions.visibilityOf(logInBtn));
        actions.moveToElement(logInBtn).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(logOnBtn));
        click(logOnBtn);

        return this;
    }
```
- By sınıfını kullanarak sayfadaki öğeleri tanımlar. Bu öğeler, çerez kabul butonu, giriş butonu, sepet ve favoriler gibi öğelerdir.
- @FindBy ile de logInBtn öğesi tanımlanır, bu öğe PageFactory tarafından yönetilir.
- super(driver) ile BasePage sınıfının constructor'ı çağrılır.
- PageFactory.initElements(driver, this) ile sayfa nesneleri (elementler) başlatılır.
- WebDriverWait ve Actions sınıfları tanımlanarak sayfa üzerindeki öğelerle etkileşime geçmek için hazır hale geliriz.
- goToLoginPage(): Kullanıcıyı giriş sayfasına yönlendiren bir metot. Çerez kabul butonuna tıklanır, ardından giriş butonuna yönlendirilir.
- Her bir metodun dönüş türü HomePage sınıfıdır. Bu, method chaining (metod zincirleme) yapılmasını sağlar ve her metod çağrısı sonrasında aynı HomePage nesnesine devam edilir. Örneğin, goToLoginPage().goToCart() gibi zincirleme işlemler mümkündür.

---
## Raporlama Araçları : Allure Report ve Extent Report

Bu projede, test senaryolarının sonuçlarını görsel olarak sunmak için iki farklı raporlama aracı kullanılmaktadır: 
**Allure Report** ve **Extent Report**. 
Bu araçlar, testlerin başarı durumu, hatalar ve test süreci hakkında ayrıntılı bilgi sağlayarak, testlerin izlenebilirliğini artırır ve hata ayıklama sürecini kolaylaştırır.

- **Allure Report**: Testlerin başarı, hata ve adım detaylarını grafiksel olarak sunar. Kullanıcı dostu ve etkileşimli raporlar sağlar. Test adımları ve hata mesajları gibi detayları gösterir.

- **Extent Report:** Kapsamlı HTML raporları sunar. Test adımları, başarılar, hatalar ve ekran görüntüleri gibi multimedya öğeleriyle zenginleştirilmiş dinamik raporlar oluşturur.

Her iki araç, testlerin izlenebilirliğini artırır ve hata ayıklamayı kolaylaştırır.

---

## PROJE ÇALIŞIR EKRAN GÖRÜNTÜSÜ/VİDEOSU
![Cart Test](https://github.com/mahmutcansaribal/SoftwareTesting_LCWaikikiPatika/blob/main/assets/CartTest.gif?raw=true)