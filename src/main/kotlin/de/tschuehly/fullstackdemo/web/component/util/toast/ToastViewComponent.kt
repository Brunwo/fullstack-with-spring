package de.tschuehly.fullstackdemo.web.component.util.toast

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class ToastViewComponent {
    fun render(message: String, durationMs: Int) = ToastView(
        message,
        durationMs
    )

    data class ToastView(
        val message: String,
        val duration: Int
    ) : ViewContext
}