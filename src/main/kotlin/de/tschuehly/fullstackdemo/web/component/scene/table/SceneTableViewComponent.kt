package de.tschuehly.fullstackdemo.web.component.scene.table

import de.tschuehly.fullstackdemo.core.scene.SceneService
import de.tschuehly.fullstackdemo.web.component.util.advancedTable.AdvancedTableViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class SceneTableViewComponent(
    private val sceneService: SceneService,
    private val sceneTable: AdvancedTableViewComponent
) {
    fun render(enableEdit: Boolean = false): ViewContext {
        val sceneList = sceneService.getsceneData().map { scene ->
            scene.getSceneAsList()
        }
        return SceneTableView(sceneTable.render(
            AdvancedTableViewComponent.Table(
                listOf("Id", "First Name", "Last Name", "Phone Number", "Email", "Birth Date"),
                sceneList,
                "/component/scene/modal"
            ))
        )
    }

    data class SceneTableView(val sceneTable : AdvancedTableViewComponent.Table) : ViewContext
}