## Spring Boot Security OAuth2

Dans ce repo, nous allons voir un exemple de la sécurisation des API REST à l'aide de Spring Boot Security OAuth2. Nous
allons
implémenter AuthorizationServer , ResourceServer et certaines API REST pour différentes opérations CRUD.

### Qu'est-ce qu'OAuth ?
---
**OAuth** est simplement un protocole d'autorisation sécurisé qui traite de l'autorisation d'une application tierce à
accéder aux données de l'utilisateur sans exposer son mot de passe. par exemple. (Connexion avec fb, gPlus, twitter sur
de nombreux sites Web..) fonctionnent tous sous ce protocole.
Fondamentalement, trois parties sont impliquées : le fournisseur oAuth, le client oAuth et le propriétaire. Ici, le
fournisseur oAuth fournit le jeton d'authentification tel que Facebook, Twitter. De même, oAuth Client sont les
applications qui souhaitent accéder aux informations d'identification au nom du propriétaire et le propriétaire est l'
utilisateur qui a un compte sur les fournisseurs oAuth tels que Facebook et Twitter.

### Rôles OAuth2
---
OAuth2 fournit 4 rôles différents.

- **Resource Owner** : Utilisateur
- **Client** : Application
- **Resource Server** : API
- **Authorization Server** : API

### OAuth2 Grant Types
---
Voici les 4 différents types de subvention définis par OAuth2 :

- **Authorization Code** : utilisé avec les applications côté serveur
- **Implicit** : utilisé avec des applications mobiles ou des applications Web (applications qui s'exécutent sur l'
  appareil de l'utilisateur)
- **Resource Owner Password Credentials** : utilisées avec des applications approuvées, telles que celles détenues par
  le service lui-même
- **Client Credentials** : utilisées avec l'accès à l'API Applications

### Technologies utilisées
---

- Java 11
- Spring Boot 2.7.3
- spring-security-oauth2 2.5.2.RELEASE
- PostgreSQL
- Maven 3
- Tout IDE prenant en charge Java et Spring Boot (Spring Tool Suite (STS), IntelliJ, VSC, NetBeans, etc.)
- Postman, curl ou n'importe quel client HTTP pour tester l'API REST

### Explication codes sources
---

- Configuration du serveur d'autorisation OAuth2 `AuthorizationServerConfig` : cette classe
  s'étend `AuthorizationServerConfigurerAdapter` et est chargée de générer des jetons spécifiques à un client.
- `@EnableAuthorizationServer` : active un serveur d'autorisation. `AuthorizationServerEndpointsConfigurer` définit les
  points de terminaison d'autorisation et de jeton et les services de jeton.
- Configuration du serveur de ressources OAuth2 `ResourceServerConfig` : La ressource dans notre contexte est l'API REST
  que nous avons exposée pour l'opération crud. Pour accéder à ces ressources, le client doit être authentifié.
- `@EnableResourceServer` : active un serveur de ressources
- Configuration de la sécurité `SecurityConfig` : Cette classe étend WebSecurityConfigurerAdapter et fournit une
  configuration de sécurité Spring habituelle. Ici, nous utilisons l'encodeur bcrypt pour encoder nos mots de passe.
- `@EnableWebSecurity` : active la prise en charge de la sécurité Web Spring Security.
- `@EnableGlobalMethodSecurity` : prise en charge du contrôle d'accès au niveau de la méthode, tel que@PreAuthorize
  @PostAuthorize
- Rest APIs : API REST très basiques que nous avons exposées à des fins de test.
- `Userservice` qui est responsable de la récupération des détails de l'utilisateur à partir de la base de données.

### Exécuter et tester l'application
---

- Exécuter l'application `mvn spring-boot:run`
- Un utiliusateur est initialisé dans la classe Main dont username = Darvin / password = password
- Importer dans Postman la collection `spring-security-oauth2.postman_collection.json` pour tester les APIs