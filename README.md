# Proje Açıklaması

Bu proje, e-ticaret platformu üzerinde kullanıcı akışlarını test etmek ve doğrulamak amacıyla geliştirilmiş bir otomasyon test paketidir. 
Test senaryoları, kullanıcı girişinden, ürünü aramaya, filtreleme ve sıralama işlemlerine kadar çeşitli işlemleri kapsamaktadır.
Proje, **Java**, **Selenium**, **TestNG** teknolojileri ve **Page Object Model** tasarım deseni kullanılarak geliştirilmiştir.

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
- **Test Framework** : TestNG
- **Otomasyon Tool** : Selenium WebDriver
- **Raporlama Tool** : Allure Report
- **Build Tool** : Maven
---
## Proje Yapısı
Bu proje, **Page Object Model (POM)** tasarım desenini kullanarak oluşturulmuştur. POM, her sayfa için ayrı bir sınıf (Page Class) oluşturmayı ve testlerin bu sayfa nesneleriyle etkileşimde bulunmasını sağlar. Bu sayede, test senaryoları ve sayfa nesneleri birbirinden bağımsız hale gelir ve kodun bakımı kolaylaşır.
### Kullanılan Yapı

- **Page Object**: Her web sayfası için ayrı bir sınıf (örneğin, `HomePage`, `ProductPage`, `CartPage`) oluşturulmuştur. Bu sınıflar, sayfanın elementleri ve bu elementlerle yapılacak işlemleri içerir.
- **Test Sınıfları**: Test senaryoları, ilgili sayfa nesneleriyle etkileşimde bulunarak gerçekleştirilmektedir.

---
## Test Senaryoları

| Test Adı                | Açıklama                                                              | Durum | Açıklamalar                            |
|-------------------------|-----------------------------------------------------------------------|-------|----------------------------------------|
| LogIn Test              | Kullanıcı giriş yapma butonuna tıklama işlemi.                        | Pass  | Giriş sayfası çalışıyor.               |
| LogOn Test              | Kullanıcı giriş işlemi.                                               | Pass  | Kullanıcı başarılı giriş yaptı.        |
| Category Selection Test | Kategori seçme işlemi.                                                | Pass  | Kategori seçimi doğru şekilde yapıldı. |
| Product Test            | Ürün filtreleme, listeleme ve seçme işlemi.                           | Pass  | Filtreleme ve ürün seçimi doğru        |
| Product Detail Test     | Ürün detaylarının görüntülenmesi ve ürün özellikleri seçme işlemleri. | Pass  | Ürün detayları doğru görüntülendi.     |
| Cart Test               | Ürün detaylarını kontrol etme ve favorilere ekleme işlemleri.         | Pass  | Sepet işlemleri doğru çalıştı          |