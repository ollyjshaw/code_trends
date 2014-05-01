name := "code_trends"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.twitter4j"% "twitter4j-core"% "3.0.3",
  "com.google.inject" % "guice" % "4.0-beta"
)     

play.Project.playJavaSettings
