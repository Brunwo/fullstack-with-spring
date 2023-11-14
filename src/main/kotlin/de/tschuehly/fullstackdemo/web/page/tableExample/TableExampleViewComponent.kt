package de.tschuehly.fullstackdemo.web.page.tableExample

import de.tschuehly.fullstackdemo.web.component.scene.table.SceneTableViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
data class TableExampleViewComponent(
    private val sceneTableViewComponent: SceneTableViewComponent
) : ViewContext {
    fun render() =  object : ViewContext {}
}
