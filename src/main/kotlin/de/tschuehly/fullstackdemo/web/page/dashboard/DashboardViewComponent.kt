package de.tschuehly.fullstackdemo.web.page.dashboard


import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.core.scene.SceneService
import de.tschuehly.fullstackdemo.web.component.scene.table.SceneTableViewComponent
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class DashboardViewComponent(
    private val analyticsService: AnalyticsService,
    private val sceneService: SceneService,
    private val chartViewComponent: ChartViewComponent,
    private val sceneTableViewComponent: SceneTableViewComponent
) {
    fun render() = ViewContext(
        "requestChartVC" toProperty chartViewComponent.render(
            ChartViewComponent.ChartDetails(
                "bar",
                400, 200,
                "Number of Requests",
                analyticsService.getLabelList(),
                analyticsService.getRequestCountList()
            )
        ),
        "renderTimeLabelList" toProperty analyticsService.getLabelList(),
        "sceneTableVC" toProperty sceneTableViewComponent.render()
    )


}