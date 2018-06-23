# Contributing to Kershless

These are the contribution guidelines for the kershless API repo.

Thanks for taking the time to contribute :+1::tada: All contributions are welcome! 
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Contribution process for all committers](#contribution-process-for-all-committers)
  - [Typos](#typos)
  - [Features or Bug Fixes](#features-or-bug-fixes)
- [Development](#development)
  - [Build](#build)
      - [Run unit tests](#run-unit-tests)
      - [Package JARs](#package-jars)
      - [Package JARs and run tests](#package-jars-and-run-tests)
      - [Full build with tests, but without install to maven local repo (Recommended)](#full-build-with-tests-but-without-install-to-maven-local-repo-recommended)
  - [Integration Tests](#integration-tests)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Contribution process for all committers

### Typos

If you have push access to the repository you can fix them directly otherwise just make a pull request.

### Features or Bug Fixes

- Every PR should address an issue on the repository. If the issue doesn't exist, please create it first.
- Pull requests should always follow the following naming convention: 
`[issue-number]-[pr-name]`. For example,
to address issue #65 which refers to a style bug, the PR addressing it should have a name that looks something like
 `65-fix-style-bug`.
- Commit messages should always be prefixed with the number of the issue that they address. 
For example, `#65: Remove redundant space.`
- After your PR is merged to master:
    - Delete the branch.
    - Mark the issue it addresses with the `merged-to-master` label.
    - Close the issue **only** if the change was released.
    
## Development
### Build
##### Run unit tests
````bash
./gradlew test
````

##### Package JARs
````bash
./gradlew clean jar
````

##### Package JARs and run tests
````bash
./gradlew clean check
````

##### Full build with tests, but without install to maven local repo (Recommended)
````bash
./gradlew clean build
````

For more detailed information on build and release process, see [Build and Release](BUILD.md) documentation.

### Integration Tests

```bash
./gradlew integrationTest
```
