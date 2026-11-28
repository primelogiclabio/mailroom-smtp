# Changelog

All notable changes to mailroom-smtp are listed here. The format follows
[Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and versions follow [Semantic Versioning](https://semver.org/).

## [Unreleased]

### Added

- Module skeleton on mailroom-parent 0.3.0 and mailroom 0.1.0-SNAPSHOT: `mailroom-smtp` (Java 21 set, tested on
  JDK 21 and 25) and `mailroom-smtp-java8` (Java 8 set, tested on JDK 8), each with its `Automatic-Module-Name`
  `io.primelogiclab.mailroom.smtp` and a smoke test, plus tests both sets share in `shared-tests/`.
- Jakarta Mail API 2.1.5 and Angus Mail 2.0.5 in both sets, with a shared test that finds Angus Mail's `smtp` and
  `smtps` providers on each set's JDKs.
- CI and release workflows from mailroom-parent 0.3.0's templates; snapshots deploy from `main`.

[Unreleased]: https://github.com/primelogiclabio/mailroom-smtp/commits/main
