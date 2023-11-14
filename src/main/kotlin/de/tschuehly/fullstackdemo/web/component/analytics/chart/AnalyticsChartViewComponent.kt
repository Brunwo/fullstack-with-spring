package de.tschuehly.fullstackdemo.web.component.analytics.chart

import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
data class AnalyticsChartViewComponent(
     val analyticsService: AnalyticsService,
     val chartViewComponent: ChartViewComponent
) : ViewContext {

//fun render(nestedViewComponent: ViewContext) = LayoutView(nestedViewComponent)

    fun render(name: String) =
       chartViewComponent.render(
              ChartViewComponent.ChartDetails(
                "line",
                400,
                200,
                name,
                analyticsService.getTimeStampsFor(name),
                analyticsService.getComputeTimesFor(name)
            )
          )
}
