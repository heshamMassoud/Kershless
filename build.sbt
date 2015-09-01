name := """kershless"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaCore,
  javaWs % "test",
  "org.springframework" % "spring-context" % "4.1.1.RELEASE",
  "org.springframework.data" % "spring-data-mongodb" % "1.7.1.RELEASE",
  "org.mongodb" % "mongo-java-driver" % "3.0.1",
  "com.google.code.findbugs" % "findbugs" % "3.0.1",
  "net.sourceforge.pmd" % "pmd" % "5.3.2"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)