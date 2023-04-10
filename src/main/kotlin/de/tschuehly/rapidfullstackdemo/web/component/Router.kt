package de.tschuehly.rapidfullstackdemo.web.component

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.web.component.calendar.CalendarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.dashboard.DashboardViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.form.FormViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.tabbed.TabbedViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class Router(
    private val dashboardViewComponent: DashboardViewComponent,
    private val chartViewComponent: ChartViewComponent,
    private val formViewComponent: FormViewComponent,
    private val analyticsService: AnalyticsService,
    private val calendarViewComponent: CalendarViewComponent,
    private val tabbedViewComponent: TabbedViewComponent
) {
    @GetMapping(SidebarViewComponent.dashboardHref)
    fun home() = dashboardViewComponent.render()

    @GetMapping(SidebarViewComponent.formsHref)
    fun forms() = formViewComponent.render()

    @GetMapping(SidebarViewComponent.calendarHref)
    fun calendar() = calendarViewComponent.render()

    @GetMapping(SidebarViewComponent.tabbedHref)
    fun tabs() = tabbedViewComponent.render()

    @GetMapping("/lineChartComponent")
    fun chartComponent(
        @RequestParam name: String
    ) = chartViewComponent.render(
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







