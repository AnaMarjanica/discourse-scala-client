# Discourse client for scala
Discourse client allows you to consume [the Discourse API](https://meta.discourse.org/t/discourse-api-documentation/22706) in your scala projects.  
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/95beb2c674fa49769c219f7d77cf810a)](https://www.codacy.com/app/ana-marjanica/discourse-scala-client?utm_source=github.com&utm_medium=referral&utm_content=amarjanica/discourse-scala-client&utm_campaign=badger)
## Installation
Add this in your sbt build definition:  
```libraryDependencies += "com.amarjanica" %% "discourse-scala-client" % "1.1.0"```

## Example of usage
```
import com.amarjanica.discourse.{Credentials, DiscourseClient}

val discourseUrl = "http://127.0.0.1:80" // replace it
val credentials = Credentials(
  api_username = "your_discourse_username",
  api_key = "very_long_string"
)
val discourseClient = new DiscourseClient(discourseUrl, Some(credentials))
```

