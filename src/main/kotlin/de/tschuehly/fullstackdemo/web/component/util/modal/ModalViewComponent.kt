package de.tschuehly.fullstackdemo.web.component.util.modal

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class ModalViewComponent {
    fun render(embeddedComponent: ViewContext) =   ModalView(embeddedComponent)
    data class ModalView(val embeddedComponent: ViewContext) : ViewContext
}