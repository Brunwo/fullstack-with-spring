package de.tschuehly.fullstackdemo.web.page.calendar

import de.tschuehly.fullstackdemo.web.page.calendar.eventModal.EventModalViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
data class CalendarViewComponent(
    private val eventModalViewComponent: EventModalViewComponent
) : ViewContext {
    fun render() =  eventModalViewComponent.render()
}

// add a functionality  that removes the need to write render function when ViewComponent is used
