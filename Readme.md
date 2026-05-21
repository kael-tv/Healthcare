mvn clean package -DskipTests
mvn package -DskipTests

Roadmap ajout de méthode:
-Repository (JPA)
-Service, (appelle le repo, donne responsedto)
-Controller (avec endpoint, @PathVariable, @RequestParam, @Body etc)
    

prochaine fois:
Modèle — l'entité JPA, les champs, sans validation
Repository — juste l'interface JPA
DTO — Request et Response tout de suite, avant même le service
Mapper — la conversion entre entité et DTO
Service — avec les DTO dès le départ
Controller — avec ResponseEntity dès le départ
Validation — les annotations sur les RequestDto
GlobalExceptionHandler — une fois pour tout le projet, réutilisable

###TODO DTO 

###TODO héritage docker compose + découpage clean

#facultatif: jib
#circuit breaker

#très facultatif
#refactorer les adresses des endpoints des 2 api avec des termes + pro