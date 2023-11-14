package de.tschuehly.fullstackdemo.web.component.util.alpineTab

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@ViewComponent
 class AlpineTabViewComponent  {
    fun render(tabs: List<Tab>) = TabsView (tabs.map { it.tabHeader }, tabs.map { it.tabContent })
    data class Tab(
        val tabHeader: String,
        val tabContent: String
    ) : ViewContext
    data class TabsView(val headerList : List<String>, val contentList : List<String>) : ViewContext
}
