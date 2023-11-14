package de.tschuehly.fullstackdemo.web.aspect

import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.spring.viewcomponent.thymeleaf.ThymeleafViewComponentTagProcessor
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import kotlin.system.measureNanoTime

@Aspect
@Component

class WebAnalyticAspect(
    val analyticsService: AnalyticsService

) {

    private val logger = LoggerFactory.getLogger(WebAnalyticAspect::class.java)
    val componentRenderCountMap: MutableMap<String, Int> = mutableMapOf()
//
//    @Around(
//        "execution(* service(..)) &&"+
//                "target(org.springframework.web.servlet.DispatcherServlet)"
//    )
//    fun aroundViewRender(joinPoint: ProceedingJoinPoint): Any? {
//        var returnValue: Any? = null
//        val elapsed = measureNanoTime {
//            returnValue = joinPoint.proceed()
//        }
//        println("Component : ${joinPoint.`this`.javaClass.simpleName.substringBefore("$$")} took $elapsed ns to render ")
//        return returnValue
//
//    }


    // ok this trace timings inside ViewComponent
    @Around(
        "execution(* render(..)) && " +
                "@within(de.tschuehly.spring.viewcomponent.core.component.ViewComponent)"
    )
    fun aroundComponent(joinPoint: ProceedingJoinPoint): Any? {
        var returnValue: Any?
        val elapsedTime = measureNanoTime {
            returnValue = joinPoint.proceed()
        }
        val componentName = joinPoint.`this`.javaClass.simpleName.substringBefore("$$")
        val dataPointList = analyticsService.getAnalyticsDataFor(componentName)
        val requestCount = if (dataPointList.isEmpty()) 1 else dataPointList.last().requestCount + 1
        dataPointList.add(
            AnalyticsService.AnalyticDataPoint(
                LocalDateTime.now(),
                requestCount,
                elapsedTime
            )
        )
        analyticsService.saveAnalyticsDataFor(componentName, dataPointList)
        return returnValue
    }

    @Around("execution(* de.tschuehly.spring.viewcomponent.thymeleaf.ThymeleafViewComponentTagProcessor.doProcess(..))" // && " +
    //        "//@annotation(someAnnotation)"
       //     ThymeleafViewComponentTagProcessor AbstractAttributeTagProcessor
        //    "@within(de.tschuehly.spring.viewcomponent.thymeleaf.ThymeleafViewComponentTagProcessor)"
    )
    @Throws(Throwable::class)
    fun catchMethod(point: ProceedingJoinPoint): Any {
        //some action

        val result  : Any
        try {
            result = point.proceed()
        } catch (e: Exception) {
            logger.debug("args while trying to render : {}", point.args)
            throw e //can I do this?
        }
        //some action
        return result
    }

}
