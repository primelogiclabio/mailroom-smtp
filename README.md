# mailroom-smtp

SMTP transport for [mailroom](https://github.com/primelogiclabio/mailroom): sends through any SMTP server, such as an
on-premises relay, a provider's SMTP service, or [Mailpit](https://mailpit.axllent.org/) during development, so a
mailroom app can use SMTP next to its other providers, with routing and failover. It is built on the Jakarta Mail 2.1
API with [Eclipse Angus Mail](https://eclipse-ee4j.github.io/angus-mail/) as the implementation.

> **Status:** early development. The modules are empty skeletons; the transport arrives in the next steps, and there
> is no release yet. Snapshots are published from `main`.

## Modules

Like every mailroom module, the transport comes as two sets of jars with the same version and API: one for Java 21
apps and one for Java 8 apps. Use the set that matches mailroom's own: each set depends only on its own mailroom
artifacts.

| Artifact | Set | Depends on |
| --- | --- | --- |
| `mailroom-smtp` | Java 21 | `mailroom-core`, Jakarta Mail API 2.1, Angus Mail 2.0 |
| `mailroom-smtp-java8` | Java 8 | `mailroom-core-java8`, Jakarta Mail API 2.1, Angus Mail 2.0 |

Both sets use the same Angus Mail line, 2.0.x, which runs on Java 8 (from 2.0.1); Angus Mail 2.1 needs Java 11.

The transport uses the `jakarta.mail` packages. An older Java EE server that ships `javax.mail` keeps its own copy:
the packages differ, so the two can sit side by side. A check on a real Java 8 app server is still to come.

## Getting the snapshots

Artifacts are published to `https://repo.primelogiclab.io`, which can be read without signing in. Add:

```xml
<repositories>
    <repository>
        <id>primelogiclab-releases</id>
        <url>https://repo.primelogiclab.io/releases</url>
        <snapshots><enabled>false</enabled></snapshots>
    </repository>
    <repository>
        <id>primelogiclab-snapshots</id>
        <url>https://repo.primelogiclab.io/snapshots</url>
        <releases><enabled>false</enabled></releases>
        <snapshots><enabled>true</enabled></snapshots>
    </repository>
</repositories>
```

Coordinates: groupId `io.primelogiclab.mailroom`, artifactIds as above, version `0.1.0-SNAPSHOT`.

## Building

Requires Maven 3.9 or newer (or the included wrapper) and JDK 21 or newer to build:

```
./mvnw verify
```

`mailroom-smtp-java8` has a `java8-set` file, which tells
[mailroom-parent](https://github.com/primelogiclabio/mailroom-parent) 0.3.0 to build it for Java 8 and run its tests
on JDK 8. Each set is tested on its own JDKs: the Java 21 set on 21 and 25, the Java 8 set on 8 only, so a build that
runs the tests needs JDK 8 in `~/.m2/toolchains.xml` (see
[mailroom-parent](https://github.com/primelogiclabio/mailroom-parent#running-the-tests-on-another-jdk)). To test on
one JDK, pass its version, which skips the other set's tests:

```
./mvnw verify -Dtest.jdk=8
./mvnw verify -Dtest.jdk=25
```

Tests both sets share live in `shared-tests/java`; tests of one set's implementation stay in its module. CI runs the
Java 8 set's tests on JDK 8 and the Java 21 set's on JDK 21 and 25.

## Compatibility

| mailroom-smtp | Runs on | Built with |
| --- | --- | --- |
| 0.1.x | Java 21, 25 | Maven 3.9+, JDK 21+ and a JDK 8 toolchain, [mailroom-parent](https://github.com/primelogiclabio/mailroom-parent) 0.3.0, mailroom 0.1.x, Jakarta Mail API 2.1.5, Angus Mail 2.0.5 |
| 0.1.x, `-java8` set | Java 8 | The same |

## License

[Apache License 2.0](LICENSE)
