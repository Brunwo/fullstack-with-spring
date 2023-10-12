package de.tschuehly.fullstackdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class SpringFullstackDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringFullstackDemoApplication>(*args)
}

/**
 *  if login pops when auth fauls
 *
 *  https://github.com/wimdeblauwe/htmx-spring-boot


@Bean
@Throws(Exception::class)
fun filterChain(http: HttpSecurity): SecurityFilterChain {
    // probably some other configurations here
    val entryPoint = HxRefreshHeaderAuthenticationEntryPoint()
    val requestMatcher = RequestHeaderRequestMatcher("HX-Request")
    http.exceptionHandling { exception -> exception.defaultAuthenticationEntryPointFor(entryPoint, requestMatcher) }
    return http.build()
}
 */