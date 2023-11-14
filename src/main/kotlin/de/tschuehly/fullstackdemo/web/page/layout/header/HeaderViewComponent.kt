package de.tschuehly.fullstackdemo.web.page.layout.header


import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class HeaderViewComponent(
) {
    fun render(activeTab: SidebarViewComponent.ActiveTab?) =
        HeaderView(
            activeTab,
            SidebarViewComponent.ActiveTab.values()
        )

    data class HeaderView(
        val activeTab: SidebarViewComponent.ActiveTab?,
        val tabs: Array<SidebarViewComponent.ActiveTab>
    ) : ViewContext
}