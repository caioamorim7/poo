### Rodar o projeto manualmente

```bash
javac -d target/classes src/main/java/br/edu/idp/cc/poo/dvdrental/Main.java src/main/java/br/edu/idp/cc/poo/dvdrental/model/Actor.java src/main/java/br/edu/idp/cc/poo/dvdrental/dao/ActorDAO.java src/main/java/br/edu/idp/cc/poo/dvdrental/util/*.java
```

```bash
java -cp target/classes:lib/* br.edu.idp.cc.poo.dvdrental.Main
```

### Rodar o projeto com maven

```bash
mvn install
```

```bash
mvn compile
```

```bash
mvn exec:java -Dexec.mainClass="br.edu.idp.cc.poo.dvdrental.Main"
```

