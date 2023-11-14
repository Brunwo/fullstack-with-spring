package de.tschuehly.fullstackdemo.web.component.util

import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.IViewContext

// to avoid creating a wrapper object ??
interface ViewWrapper : IViewContext, ViewContext {
companion object {
    }

}