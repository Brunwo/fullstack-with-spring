package de.tschuehly.fullstackdemo.web.component.scene

import de.tschuehly.fullstackdemo.web.component.scene.form.SceneFormViewComponent
import de.tschuehly.fullstackdemo.web.component.scene.table.SceneTableViewComponent
import de.tschuehly.fullstackdemo.web.component.util.modal.ModalViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/component/scene")
class sceneComponentController(
    private val modalViewComponent: ModalViewComponent,
    private val sceneFormViewComponent: SceneFormViewComponent,
    private val sceneTableViewComponent: SceneTableViewComponent
) {
    @GetMapping("/modal/{sceneId}")
    fun sceneModal(@PathVariable sceneId: Int) =
        modalViewComponent.render(
            sceneFormViewComponent.render(sceneId)
        )

    @GetMapping("/table")
    fun sceneTable() = sceneTableViewComponent.render()
}